import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

@SuppressWarnings("serial")

public class EstoqueTableModel extends AbstractTableModel
{
	private ArrayList<Mercadoria> linhas;
	private String[] colunas = new String[] {"Código", "Nome", "Quantidade", "Unidade", "Preço Unitário"};
	private static final int codigo = 0, nome = 1, quantidade = 2, unidade = 3, precoUnitario = 4;

	public EstoqueTableModel()
	{
		linhas = new ArrayList<Mercadoria>();
	}

	public EstoqueTableModel(ArrayList<Mercadoria> mercadorias)
	{
		linhas = mercadorias;
	}

	@Override
	public int getRowCount()
	{
		return linhas.size();
	}

	@Override
	public int getColumnCount()
	{
		return colunas.length;
	}

	@Override
	public String getColumnName(int columnIndex)
	{
		return colunas[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		Mercadoria mercadoria = linhas.get(rowIndex);

		switch(columnIndex)
		{
			case codigo:		return mercadoria.getCodigo();
			case nome:			return mercadoria.getNome();
			case quantidade:	return mercadoria.getQuantidade();
			case unidade:		return mercadoria.getUnidade();
			case precoUnitario:	return mercadoria.getPrecoUnitario();
			default:			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
}