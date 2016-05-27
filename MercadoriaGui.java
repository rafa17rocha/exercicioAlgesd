import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")

public class MercadoriaGui extends JFrame implements ActionListener
{
	private JButton		bCadastrar, bConsultar, bSalvar, bCancelar;
	private	JTextField	tCodigo, tNome, tQuantidade, tUnidade, tValorUnitario;
	private JLabel		lCodigo, lNome, lQuantidade, lUnidade, lValorUnitario;
	private JPanel		botoes, campos;

	private int			codigo = 0;
	private int			unidade = 0;
	private String		nome = "";
	private double		quantidade = 0.0;
	private double		valor = 0.0;

	private Estoque		estoque;

	public MercadoriaGui()
	{
		setLayout(new FlowLayout());

		botoes				= new JPanel();
		campos				= new JPanel();

		botoes.setLayout(new GridLayout(2, 2, 2, 2));
		campos.setLayout(new GridLayout(5, 2));

		bCadastrar			= new JButton("Cadastrar");
		bConsultar			= new JButton("Consultar");
		bSalvar				= new JButton("Salvar");
		bCancelar			= new JButton("Cancelar");

		tCodigo				= new JTextField(8);
		tNome				= new JTextField(8);
		tQuantidade			= new JTextField(8);
		tUnidade			= new JTextField(8);
		tValorUnitario		= new JTextField(8);

		lCodigo				= new JLabel("Código:");
		lNome				= new JLabel("Nome:");
		lQuantidade			= new JLabel("Quantidade:");
		lUnidade			= new JLabel("Unidade:");
		lValorUnitario		= new JLabel("Valor:");

		estoque				= new Estoque();

		botoes.add(bCadastrar);
		botoes.add(bConsultar);
		botoes.add(bSalvar);
		botoes.add(bCancelar);

		campos.add(lCodigo);
		campos.add(tCodigo);
		campos.add(lNome);
		campos.add(tNome);
		campos.add(lQuantidade);
		campos.add(tQuantidade);
		campos.add(lUnidade);
		campos.add(tUnidade);
		campos.add(lValorUnitario);
		campos.add(tValorUnitario);

		add(campos);
		add(botoes);

		bCadastrar.addActionListener(this);
		bConsultar.addActionListener(this);
		bSalvar.addActionListener(this);
		bCancelar.addActionListener(this);

		desabilitar();
		bConsultar.setEnabled(false);

		setSize(210, 208);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource() == bCadastrar)
		{
			habilitar();
		}
		if(evento.getSource() == bConsultar)
		{
			String[] opcoes = {"Código", "Nome", "Quantidade", "Preço"};
			int escolhaOrdenar = -1;
			int escolhaFiltrar = -1;

			escolhaOrdenar = JOptionPane.showOptionDialog(this, "Ordenar por:", "Ordenar", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

			estoque.ordenar(escolhaOrdenar);

			escolhaFiltrar = JOptionPane.showOptionDialog(this, "Filtrar por:", "Filtrar", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

			try
			{
				if(escolhaFiltrar == 0)
				{
					int min = Integer.parseInt(JOptionPane.showInputDialog(this, "Código mínimo:", "Filtro", JOptionPane.PLAIN_MESSAGE));
					int max = Integer.parseInt(JOptionPane.showInputDialog(this, "Código máximo:", "Filtro", JOptionPane.PLAIN_MESSAGE));

					ArrayList<Mercadoria> array = Filtro.codigo(estoque.get(), min, max);
					new EstoqueGui(this, array);
				}

				else if(escolhaFiltrar == 1)
				{
					String min = JOptionPane.showInputDialog(this, "Nome mínimo:", "Filtro", JOptionPane.PLAIN_MESSAGE);
					String max = JOptionPane.showInputDialog(this, "Nome máximo:", "Filtro", JOptionPane.PLAIN_MESSAGE);

					ArrayList<Mercadoria> array = Filtro.nome(estoque.get(), min, max);
					new EstoqueGui(this, array);
				}

				else if(escolhaFiltrar == 2)
				{
					double min = Double.parseDouble(JOptionPane.showInputDialog(this, "Quantidade mínima:", "Filtro", JOptionPane.PLAIN_MESSAGE));
					double max = Double.parseDouble(JOptionPane.showInputDialog(this, "Quantidade máxima:", "Filtro", JOptionPane.PLAIN_MESSAGE));

					ArrayList<Mercadoria> array = Filtro.quantidade(estoque.get(), min, max);
					new EstoqueGui(this, array);
				}

				else if(escolhaFiltrar == 3)
				{
					double min = Double.parseDouble(JOptionPane.showInputDialog(this, "Preço mínimo:", "Filtro", JOptionPane.PLAIN_MESSAGE));
					double max = Double.parseDouble(JOptionPane.showInputDialog(this, "Preço máximo:", "Filtro", JOptionPane.PLAIN_MESSAGE));

					ArrayList<Mercadoria> array = Filtro.preco(estoque.get(), min, max);
					new EstoqueGui(this, array);
				}
				else
				{
					new EstoqueGui(this, estoque.get());
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, "Preencha os campos corretamente.", "Erro", JOptionPane.PLAIN_MESSAGE);
			}
		}

		if(evento.getSource() == bSalvar)
		{
			String saida = "";

			try
			{
				codigo = Integer.parseInt(tCodigo.getText());

			}
			catch(Exception e)
			{
				saida += "- Código\n";
			}

			if(!tNome.getText().equals(""))
			{
				nome = tNome.getText();
			}
			else
			{
				saida += "- Nome\n";
			}

			try
			{
				quantidade = Double.parseDouble(tQuantidade.getText());
				if(quantidade <= 0.0)
				{
					saida += "- Quantidade\n";
				}

			}
			catch(Exception e)
			{
				saida += "- Quantidade\n";
			}

			try
			{
				unidade = Integer.parseInt(tUnidade.getText());
				if(unidade <= 0)
				{
					saida += "- Unidade\n";
				}

			}
			catch(Exception e)
			{
				saida += "- Unidade\n";
			}

			try
			{
				valor = Double.parseDouble(tValorUnitario.getText());
				if(valor <= 0.0)
				{
					saida += "- Valor\n";
				}

			}
			catch(Exception e)
			{
				saida += "- Valor\n";
			}

			finally
			{
				if(!saida.equals(""))
				{
					JOptionPane.showMessageDialog(this, "Verifique os seguintes campos:\n" + saida);
				}
				else
				{
					estoque.add(new Mercadoria(codigo, nome, quantidade, unidade, valor));
					bConsultar.setEnabled(true);
					limpar();
				}

				codigo		= 0;
				nome		= "";
				quantidade	= 0.0;
				unidade		= 0;
				valor		= 0.0;
			}
		}
		if(evento.getSource() == bCancelar)
		{
			limpar();
			desabilitar();
		}
	}

	public void desabilitar()
	{
		tCodigo			.setEditable(false);
		tNome			.setEditable(false);
		tQuantidade		.setEditable(false);
		tUnidade		.setEditable(false);
		tValorUnitario	.setEditable(false);
		bCadastrar		.setEnabled(true);
		bSalvar			.setEnabled(false);
		bCancelar		.setEnabled(false);
	}

	public void habilitar()
	{
		tCodigo			.setEditable(true);
		tNome			.setEditable(true);
		tQuantidade		.setEditable(true);
		tUnidade		.setEditable(true);
		tValorUnitario	.setEditable(true);
		bCadastrar		.setEnabled(false);
		bSalvar			.setEnabled(true);
		bCancelar		.setEnabled(true);
	}

	public void limpar()
	{
		tCodigo			.setText("");
		tNome			.setText("");
		tQuantidade		.setText("");
		tUnidade		.setText("");
		tValorUnitario	.setText("");
	}
}