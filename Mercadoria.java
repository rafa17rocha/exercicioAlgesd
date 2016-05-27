public class Mercadoria
{
	private int		codigo;
	private String	nome;
	private double	quantidade;
	private int		unidade;
	private double	precoUnitario;

	public Mercadoria(int codigo, String nome, double quantidade, int unidade, double precoUnitario)
	{
		setCodigo(codigo);
		setNome(nome);
		setQuantidade(quantidade);
		setUnidade(unidade);
		setPrecoUnitario(precoUnitario);
	}

	// ##################################################
	// #####				Set's					#####
	// ##################################################

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public void setQuantidade(double quantidade)
	{
		this.quantidade = (quantidade > 0.0 ? quantidade : 0.0);
	}
	public void setUnidade(int unidade)
	{
		this.unidade = (unidade > 0 ? unidade : 0);
	}
	public void setPrecoUnitario(double precoUnitario)
	{
		this.precoUnitario = (precoUnitario > 0.0 ? precoUnitario : 0.0);
	}

	// ##################################################
	// #####				Get's					#####
	// ##################################################

	public int getCodigo()
	{
		return codigo;
	}
	public String getNome()
	{
		return nome;
	}
	public double getQuantidade()
	{
		return quantidade;
	}
	public int getUnidade()
	{
		return unidade;
	}
	public double getPrecoUnitario()
	{
		return precoUnitario;
	}
}