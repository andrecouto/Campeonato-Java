package entities;

public class Time {
	private int pontos;
	private int posicao;
	private String nome;
	private int inscricao;
	private int gols_pro;
	private int gols_contra;
	
	public Time() {
	}
	
	public Time(int pontos, int posicao, String nome) {
		setPontos(pontos);
		setPosicao(posicao);
		setNome(nome);
	}

	public int getPosicao() {
		return posicao;
	}
	
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public void setPontos(int qtd_pontos) {
		this.pontos = qtd_pontos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getInscricao() {
		return inscricao;
	}

	public void setInscricao(int inscricao) {
		this.inscricao = inscricao;
	}

	public int getGols_pro() {
		return gols_pro;
	}

	public void setGols_pro(int gols_pro) {
		this.gols_pro = gols_pro;
	}

	public int getGols_contra() {
		return gols_contra;
	}

	public void setGols_contra(int gols_contra) {
		this.gols_contra = gols_contra;
	}
	
}
