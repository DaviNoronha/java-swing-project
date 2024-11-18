import javax.swing.*;
import java.util.ArrayList;

public class ListaAtleta {

	ArrayList<Atleta> lista;
	
	void criarLista() {
		lista = new ArrayList<Atleta>();
	}

	ArrayList<Atleta> dados() {
		return this.lista;
	}
	
	void inserir(Atleta p) {
		lista.add(p);
	}

	Atleta pesquisar(int cod) {
		cod --;
		return lista.get(cod);
	}
	
	void atualizar(int cod, Atleta p) {
		cod--;
		lista.set(cod, p);
	}
	
	void excluir(int cod) {
		cod--;
		lista.remove(cod);
	}
}
