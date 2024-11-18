import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

import javax.swing.*;


public class TelaPrincipal extends JFrame implements ActionListener{
	ListaAtleta lista = new ListaAtleta();
	TelaCadastro telaCadastro = new TelaCadastro(lista);
	TelaTabela telaTabela = new TelaTabela(lista);
	TelaComparativo telaComparativo = new TelaComparativo(lista);
	JMenuBar M1;
	JMenu menuOpcoes, menuListagem, menuNota;
	JMenuItem miCadastro, miListar, miNota, miSair;

	public static void main(String[] args) {
		JFrame janela = new TelaPrincipal();
		janela.setTitle("Notas de Futebol");
		janela.setBounds(100,100,800,600);

		ImageIcon iconImage = new ImageIcon(Objects.requireNonNull(TelaPrincipal.class.getResource("/Resources/Assets/ballicon.png")));
		Image icon = iconImage.getImage().getScaledInstance(1800, 1800, Image.SCALE_SMOOTH);
		janela.setIconImage(icon);
		ImageIcon imagem = new ImageIcon(Objects.requireNonNull(TelaPrincipal.class.getResource("/Resources/Assets/wallpaper.png")));
		Image redimensionadora = imagem.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		imagem = new ImageIcon(redimensionadora);

		JLabel lab = new JLabel();

		lab.setIcon(imagem);
		lab.setBounds(0,0,800,600);
		janela.add(lab);
		janela.setExtendedState(JFrame.MAXIMIZED_VERT);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
	}

	TelaPrincipal() {
		lista.criarLista();

		M1 = new JMenuBar();

		ImageIcon cogIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Resources/Assets/cog.png")));
		ImageIcon listIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Resources/Assets/barra-de-menu.png")));
		ImageIcon starIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Resources/Assets/star.png")));
		ImageIcon addIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Resources/Assets/add.png")));
		ImageIcon offIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Resources/Assets/off.png")));
		ImageIcon listaIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Resources/Assets/atleta.png")));
		ImageIcon vsIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Resources/Assets/vs.png")));

		menuOpcoes = new JMenu("Opções");
		menuOpcoes.setIcon(cogIcon);
		menuListagem = new JMenu("Listagem");
		menuListagem.setIcon(listIcon);
		menuNota = new JMenu("Comparativo");
		menuNota.setIcon(starIcon);

		miCadastro = new JMenuItem("Cadastrar Atleta");
		miCadastro.addActionListener(this);
		miCadastro.setIcon(addIcon);
		miListar = new JMenuItem("Listar Atletas");
		miListar.addActionListener(this);
		miListar.setIcon(listaIcon);
		miNota = new JMenuItem("Comparar Atletas");
		miNota.addActionListener(this);
		miNota.setIcon(vsIcon);

		miSair = new JMenuItem("Sair do sistema");
		miSair.addActionListener(this);
		miSair.setIcon(offIcon);

		menuOpcoes.add(miCadastro);
		menuOpcoes.add(miSair);

		menuListagem.add(miListar);

		menuNota.add(miNota);

		M1.add(menuOpcoes);
		M1.add(menuListagem);
		M1.add(menuNota);

		setJMenuBar(M1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == miCadastro){
			telaCadastro.criarTela();
			
		}
		if (e.getSource() == miListar){
			telaTabela.criarTela();
		}
		if (e.getSource() == miNota){
			telaComparativo.criarTela();
		}
		if (e.getSource() == miSair){
			System.exit(0);
		}

    }

}
