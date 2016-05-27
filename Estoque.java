import java.util.ArrayList;
import javax.swing.JFrame;

public class Estoque
{
	private ArrayList<Mercadoria> mercadorias;
	private EstoqueGui tabela;

	public Estoque()
	{
		mercadorias = new ArrayList<Mercadoria>();
	}

	public void add(Mercadoria me)
	{
		mercadorias.add(me);
	}

	public void ordenar(int o)
	{
		switch(o)
		{
			case 0: Ordem.codigo(mercadorias);
			break;

			case 1: Ordem.nome(mercadorias);
			break;

			case 2: Ordem.quantidade(mercadorias);
			break;

			case 3: Ordem.valor(mercadorias);
			break;
		}
	}

	public ArrayList<Mercadoria> get()
	{
		return mercadorias;
	}
}