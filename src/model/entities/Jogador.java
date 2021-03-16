package model.entities;

public class Jogador {
	
	private String jogador;
	private Integer pontos; 
	
	public Jogador() {}

	public Jogador(String jogador, Integer pontos) {
		this.jogador = jogador;
		this.pontos = pontos;
	}

	public String getJogador1() {
		return jogador;
	}

	public void setJogador1(String jogador1) {
		this.jogador = jogador1;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	
	@Override
	public String toString() {
		return "";				
	}
}
