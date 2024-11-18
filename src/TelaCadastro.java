import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TelaCadastro implements ActionListener {
	ListaAtleta lista;
	Atleta atleta;
	int cont=0;
	JFrame tela = new JFrame("Cadastrar Atleta");
	JPanel painel = new JPanel();

	JLabel lbcod = new JLabel("Código: ");
	JLabel lbnome = new JLabel("Nome: ");
	JLabel lbfuncao = new JLabel("Função: ");
	JLabel lbtime = new JLabel("Time: ");
	JLabel lbgols = new JLabel("Gols: ");
	JLabel lbassists = new JLabel("Assists: ");
	JLabel lbnota = new JLabel("Nota: ");

	JTextField txtcod = new JTextField();
	JTextField txtnome = new JTextField();
	JTextField txtfuncao = new JTextField();
	JTextField txttime = new JTextField();
	JTextField txtgols = new JTextField();
	JTextField txtassists = new JTextField();
	JTextField txtnota = new JTextField();

	JButton jbsalvar = new JButton("Salvar");
	JButton jbatleta = new JButton("Pesquisar");
	JButton jbexcButton = new JButton("Excluir");

	TelaCadastro (ListaAtleta lista) {
		this.lista = lista;
	}

	void criarTela() {
		tela.setSize(760, 320);
		tela.setLocation(250, 250);
		painel.setLayout(null);

		lbcod.setBounds(20, 30, 70, 30);
		txtcod.setBounds(90, 30, 140, 30);
		txtcod.disable();
		jbatleta.setBounds(230, 30, 100, 30);
		jbatleta.addActionListener(this);
		jbatleta.setEnabled(true);

		lbnome.setBounds(20, 100, 70, 30);
		txtnome.setBounds(90, 100, 140, 30);

		lbfuncao.setBounds(260, 100, 70, 30);
		txtfuncao.setBounds(330, 100, 140, 30);

		lbtime.setBounds(510, 100, 70, 30);
		txttime.setBounds(580, 100, 140, 30);

		lbgols.setBounds(20, 170, 70, 30);
		txtgols.setBounds(90, 170, 140, 30);

		lbassists.setBounds(260, 170, 80, 30);
		txtassists.setBounds(330, 170, 140, 30);

		lbnota.setBounds(510, 170, 80, 30);
		txtnota.setBounds(580, 170, 140, 30);

		jbsalvar.setBounds(20, 230, 90, 30);
		jbsalvar.addActionListener(this);
		jbexcButton.setBounds(120, 230, 90, 30);
		jbexcButton.addActionListener(this);

		painel.add(lbcod);
		painel.add(txtcod);
		painel.add(jbatleta);
		painel.add(lbnome);
		painel.add(txtnome);
		painel.add(lbfuncao);
		painel.add(txtfuncao);
		painel.add(lbtime);
		painel.add(txttime);
		painel.add(txtgols);
		painel.add(lbgols);
		painel.add(txtassists);
		painel.add(lbassists);
		painel.add(lbnota);
		painel.add(txtnota);
		painel.add(jbsalvar);
		painel.add(jbexcButton);

		tela.getContentPane().add(painel);
		tela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(jbsalvar == e.getSource()) {
			if (Objects.equals(txtnome.getText(), "") || Objects.equals(txtfuncao.getText(), "") || Objects.equals(txttime.getText(), "") || Objects.equals(txtgols.getText(), "") || Objects.equals(txtassists.getText(), "") || Objects.equals(txtnota.getText(), "")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} else {
				atleta = new Atleta();

				atleta.setId(cont);
				atleta.setNome(txtnome.getText());
				atleta.setFuncao(txtfuncao.getText());
				atleta.setTime(txttime.getText());
				atleta.setGols(Integer.parseInt( txtgols.getText() ));
				atleta.setAssistencias(Integer.parseInt( txtassists.getText() ));
				atleta.setNota(Double.parseDouble( txtnota.getText() ));
				lista.inserir(atleta);

				txtcod.setText( String.valueOf(1 + atleta.getId()) );

				JOptionPane.showMessageDialog(null, "Atleta salvo com sucesso!");
				cont++;

				txtcod.setText("");
				txtnome.setText("");
				txttime.setText("");
				txtfuncao.setText("");
				txtgols.setText("");
				txtassists.setText("");
				txtnota.setText("");

				txtcod.setEnabled(true);
			}
		}

		if(jbatleta == e.getSource()) {
			int x = Integer.parseInt(txtcod.getText());

			atleta = lista.pesquisar(x);

			txtnome.setText(atleta.getNome());
			txtfuncao.setText(atleta.getFuncao());
			txttime.setText(atleta.getTime());
			txtgols.setText(String.valueOf(atleta.getGols()));
			txtassists.setText(String.valueOf(atleta.getGols()));
			txtnota.setText(String.valueOf(atleta.getNota()));
		}

		if(jbexcButton == e.getSource()) {
			int x = Integer.parseInt(txtcod.getText());

			lista.excluir(x);
			JOptionPane.showMessageDialog(null, "Atleta excluído com sucesso!");
		}

	}




}
