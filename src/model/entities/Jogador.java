package model.entities;

public class Jogador { 
	
	private String jogador;
	private Integer pontos; 
	
	public Jogador() {}

	public Jogador(String jogador, Integer pontos) {
		this.jogador = jogador;
		this.pontos = pontos;
	}

	public String getJogador() {
		return jogador;
	}

	public void setJogador(String jogador) {
		this.jogador = jogador;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	
	/*
	 * Soma um ponto a mais para o jogador ganhador da rodada.
	 */
	public Integer somaPontos() {
		return pontos += 1;
	}
	
	public String toString() {
		return getJogador() + " tem " + getPontos() + " pontos.";
	}

}
