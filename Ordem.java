import java.util.ArrayList;

public class Ordem
{

	// BubbleSort
	public static void nome(ArrayList<Mercadoria> ordenar)
	{
		Mercadoria aux;

		for(int i = ordenar.size() - 1; i >= 0; i--)
		{
			for(int a = 0; a < i; a++)
			{
				String atual	= ordenar.get(a).getNome();
				String proxima	= ordenar.get(a + 1).getNome();

				if(atual. compareToIgnoreCase(proxima) > 0)
				{
					aux = ordenar.get(a);
					ordenar.set(a, ordenar.get(a + 1));
					ordenar.set(a + 1, aux);
				}
			}
		}
	}

	// SelectionSort
	public static void quantidade(ArrayList<Mercadoria> ordenar)
	{
		Mercadoria aux;
		int menor;

		for(int i = 0; i < ordenar.size(); i++)
		{
			menor = i;

			for(int a = i + 1; a < ordenar.size(); a++)
			{
				if(ordenar.get(a).getQuantidade() < ordenar.get(menor).getQuantidade())
				{
					menor = a;
				}
			}

			if(menor != i)
			{
				aux = ordenar.get(i);
				ordenar.set(i, ordenar.get(menor));
				ordenar.set(menor, aux);
			}
		}
	}

	// InsertionSort
	public static void valor(ArrayList<Mercadoria> ordenar)
	{
		Mercadoria aux;

		for(int i = 1; i < ordenar.size(); i++)
		{
			for(int a = i; a > 0; a--)
			{
				if(ordenar.get(a).getPrecoUnitario() < ordenar.get(a - 1).getPrecoUnitario())
				{
					aux = ordenar.get(a - 1);
					ordenar.set(a - 1, ordenar.get(a));
					ordenar.set(a, aux);
				}
			}
		}
	}

	// QuickSort
	public static void codigo(ArrayList<Mercadoria> ordenar)
	{
		quick(ordenar, 0, ordenar.size() - 1);
	}

	public static void quick(ArrayList<Mercadoria> ordenar, int inicio, int fim)
	{
		int indice = separar(ordenar, inicio, fim);

		if (inicio < indice - 1)
			quick(ordenar, inicio, indice - 1);

		if (indice < fim)
			quick(ordenar, indice, fim);
	}

	public static int separar(ArrayList<Mercadoria> ordenar, int inicio, int fim)
	{
		int i = inicio;
		int j = fim;

		Mercadoria temp;
		Mercadoria pivot = ordenar.get((inicio + fim) / 2);
		 
		while (i <= j)
		{
			while (ordenar.get(i).getCodigo() < pivot.getCodigo())
				i++;

			while (ordenar.get(j).getCodigo() > pivot.getCodigo())
				j--;

			if (i <= j)
			{
				temp = ordenar.get(i);
				ordenar.set(i, ordenar.get(j));
				ordenar.set(j, temp);
				i++;
				j--;
			}
		}
		return i;
	}
}