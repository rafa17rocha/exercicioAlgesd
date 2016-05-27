import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")

public class EstoqueGui extends JDialog
{
	private JTable		tabelaMercadorias;
	private EstoqueTableModel tableModel;

	public EstoqueGui(JFrame frame, ArrayList<Mercadoria> arrayMercadorias)
	{
		super(frame, "Lista de Mercadorias");

		tabelaMercadorias	= new JTable();
		tableModel			= new EstoqueTableModel(arrayMercadorias);
		tabelaMercadorias.setModel(tableModel);

		add(new JScrollPane(tabelaMercadorias));

		setSize(480, 220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}