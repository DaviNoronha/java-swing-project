public class Atleta {

	private int id;
	private String nome;
	private String time;
	private String funcao;
	private int gols;
	private int assistencias;
	private Double nota;

	Atleta(){}

	Atleta(String nome, String funcao, int gols, int assistencias, Double nota) {
		this.nome = nome;
		this.nome = nome;
		this.funcao = funcao;
		this.gols = gols;
		this.assistencias = assistencias;
		this.nota = nota;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public int getAssistencias() {
		return assistencias;
	}

	public void setAssistencias(int assistencias) {
		this.assistencias = assistencias;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
}
