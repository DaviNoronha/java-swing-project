import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaTabela {
	Atleta atleta;
	String [] colunas = {"Cód", "Nome", "Função", "Time", "Gols", "Assists", "Nota"};
	int cont=0;
	JFrame tela = new JFrame("Listar Atletas");
	JPanel painel = new JPanel();
	DefaultTableModel tabela = new DefaultTableModel(colunas, 0);
	JTable tabelaAtletas = new JTable(tabela);
	JScrollPane barraRolagem = new JScrollPane(tabelaAtletas);
	ListaAtleta lista;

	TelaTabela (ListaAtleta lista) {
		this.lista = lista;
	}

	void criarTela() {
		tabela.setRowCount(0);

		if (lista.dados().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum Atleta Cadastrado!");
		} else {
			for (int i = 0; i < lista.dados().size(); i++) {
				int cod = lista.dados().get(i).getId();
				String nome = lista.dados().get(i).getNome();
				String funcao = lista.dados().get(i).getFuncao();
				String time = lista.dados().get(i).getTime();
				int gols = lista.dados().get(i).getGols();
				int assits = lista.dados().get(i).getAssistencias();
				Double nota = lista.dados().get(i).getNota();

				Object[] data = {cod + 1, nome, funcao, time, gols, assits,
						nota};
				tabela.addRow(data);
			}

			tela.setSize(800, 600);
			tela.setLocation(250, 250);
			painel.setLayout(new GridLayout(1, 1));
			painel.add(barraRolagem);
			tela.getContentPane().add(painel);
			tela.setVisible(true);
		}
	}
}
