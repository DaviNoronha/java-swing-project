import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TelaComparativo implements ItemListener {
	ListaAtleta lista;
	Atleta a1, a2;
	Item ci;
	String nome;
	JFrame tela = new JFrame("Notas dos Atletas");
	JPanel painel = new JPanel();
	JComboBox<Item> cbatleta1 = new JComboBox();
	JComboBox<Item> cbatleta2 = new JComboBox();
	JLabel lbatleta1 = new JLabel("Selecione o Jogador");
	JLabel lbatleta2 = new JLabel("Selecione o Jogador");
	JLabel lb1Nome = new JLabel();
	JLabel lb1Gols = new JLabel();
	JLabel lb1Assists = new JLabel();
	JLabel lb1Nota = new JLabel();
	JLabel lb2Nome = new JLabel();
	JLabel lb2Gols = new JLabel();
	JLabel lb2Assists = new JLabel();
	JLabel lb2Nota = new JLabel();

	TelaComparativo(ListaAtleta lista) {
		this.lista = lista;
	}

	void criarTela() {
		if (lista.dados().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum Atleta Cadastrado!");
		} else {
			tela.setSize(500, 300);
			tela.setLocation(250, 250);
			painel.setLayout(null);

			cbatleta1.addItemListener(this);
			cbatleta2.addItemListener(this);

			cbatleta1.removeAllItems();
			cbatleta2.removeAllItems();

			for (int i = 0; i < lista.dados().size(); i++) {
				nome = lista.pesquisar(i+1).getNome();
				ci = new Item(i, nome);

				cbatleta1.addItem(ci);
				cbatleta2.addItem(ci);
			}

			lbatleta1.setBounds(80, 20, 120, 30);
			cbatleta1.setBounds(80, 60, 120, 30);
			lbatleta2.setBounds(280, 20, 120, 30);
			cbatleta2.setBounds(280, 60, 120, 30);

			lb1Nome.setBounds(80, 100, 120, 30);
			lb1Gols.setBounds(80, 120, 120, 30);
			lb1Assists.setBounds(80, 140, 120, 30);
			lb1Nota.setBounds(80, 160, 120, 30);

			lb2Nome.setBounds(280, 100, 120, 30);
			lb2Gols.setBounds(280, 120, 120, 30);
			lb2Assists.setBounds(280, 140, 120, 30);
			lb2Nota.setBounds(280, 160, 120, 30);

			painel.add(lbatleta1);
			painel.add(cbatleta1);
			painel.add(lbatleta2);
			painel.add(cbatleta2);
			tela.add(painel);
			tela.setVisible(true);
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cbatleta1 || e.getSource() == cbatleta2) {
			if (cbatleta1.getSelectedItem() != null && cbatleta2.getSelectedItem() != null) {
				Item item1 = (Item)cbatleta1.getSelectedItem();
				Item item2 = (Item)cbatleta2.getSelectedItem();

				a1 = lista.pesquisar(item1.getValue() + 1);
				a2 = lista.pesquisar(item2.getValue() + 1);

				lb1Nome.setText("Atleta: " + a1.getNome());
				lb1Gols.setText("Gols: " + a1.getGols());
				lb1Assists.setText("Assists: " + a1.getAssistencias());
				lb1Nota.setText("Nota: " + a1.getNota());

				lb2Nome.setText("Atleta: " + a2.getNome());
				lb2Gols.setText("Gols: " + a2.getGols());
				lb2Assists.setText("Assists: " + a2.getAssistencias());
				lb2Nota.setText("Nota: " + a2.getNota());

				if (a1.getGols() > a2.getGols()) {
					lb1Gols.setForeground(Color.green);
					lb2Gols.setForeground(Color.red);
				} else if (a2.getGols() > a1.getGols()) {
					lb1Gols.setForeground(Color.red);
					lb2Gols.setForeground(Color.green);
				} else {
					lb1Gols.setForeground(Color.black);
					lb2Gols.setForeground(Color.black);
				}

				if (a1.getAssistencias() > a2.getAssistencias()) {
					lb1Assists.setForeground(Color.green);
					lb2Assists.setForeground(Color.red);
				} else if (a2.getAssistencias() > a1.getAssistencias()) {
					lb1Assists.setForeground(Color.red);
					lb2Assists.setForeground(Color.green);
				} else {
					lb1Assists.setForeground(Color.black);
					lb2Assists.setForeground(Color.black);
				}

				if (a1.getNota() > a2.getNota()) {
					lb1Nota.setForeground(Color.green);
					lb2Nota.setForeground(Color.red);
				} else if (a2.getNota() > a1.getNota()) {
					lb1Nota.setForeground(Color.red);
					lb2Nota.setForeground(Color.green);
				} else {
					lb1Nota.setForeground(Color.black);
					lb2Nota.setForeground(Color.black);
				}

				painel.add(lb1Nome);
				painel.add(lb1Gols);
				painel.add(lb1Assists);
				painel.add(lb1Nota);
				painel.add(lb2Nome);
				painel.add(lb2Gols);
				painel.add(lb2Assists);
				painel.add(lb2Nota);
			}
		}
	}

	public class Item {
		private int value;
		private String label;

		public Item(int value, String label) {
			this.value = value;
			this.label = label;
		}

		public int getValue() {
			return this.value;
		}

		public String getLabel() {
			return this.label;
		}

		@Override
		public String toString() {
			return label;
		}
	}
}