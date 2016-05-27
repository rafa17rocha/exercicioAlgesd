import java.util.ArrayList;

public class Filtro
{
	public static ArrayList<Mercadoria> codigo(ArrayList<Mercadoria> mercadorias, int min, int max)
	{
		ArrayList<Mercadoria> filtrados = new ArrayList<Mercadoria>();

		for(Mercadoria me: mercadorias)
		{
			if(me.getCodigo() >= min && me.getCodigo() <= max)
				filtrados.add(me);
		}
		return filtrados;
	}

	public static ArrayList<Mercadoria> nome(ArrayList<Mercadoria> mercadorias, String min, String max)
	{
		ArrayList<Mercadoria> filtrados = new ArrayList<Mercadoria>();

		for(Mercadoria me: mercadorias)
		{
			if(me.getNome().compareToIgnoreCase(min) >= 0 && me.getNome().compareToIgnoreCase(max) <= 0)
			{
				filtrados.add(me);
			}
		}
		return filtrados;
	}

	public static ArrayList<Mercadoria> quantidade(ArrayList<Mercadoria> mercadorias, double min, double max)
	{
		ArrayList<Mercadoria> filtrados = new ArrayList<Mercadoria>();

		for(Mercadoria me: mercadorias)
		{
			if(me.getQuantidade() >= min && me.getQuantidade() <= max)
				filtrados.add(me);
		}
		return filtrados;
	}

	public static ArrayList<Mercadoria> preco(ArrayList<Mercadoria> mercadorias, double min, double max)
	{
		ArrayList<Mercadoria> filtrados = new ArrayList<Mercadoria>();

		for(Mercadoria me: mercadorias)
		{
			if(me.getPrecoUnitario() >= min && me.getPrecoUnitario() <= max)
				filtrados.add(me);
		}
		return filtrados;
	}
}