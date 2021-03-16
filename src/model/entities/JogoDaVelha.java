package model.entities;

import java.util.Arrays;

public class JogoDaVelha extends Jogador{
	
	private Integer tamanhoTabuleiro;
	String[][] tabuleiro = new String[3][3];
	
	public JogoDaVelha() {}

	public JogoDaVelha(Integer tamanhoTabuleiro) {
		this.tamanhoTabuleiro = tamanhoTabuleiro;
	}

	public Integer getTamanhoTabuleiro() {
		return tamanhoTabuleiro;
	}

	public void setTamanhoTabuleiro(Integer tamanhoTabuleiro) {
		//Preenche os campos do array para não ficar nulos
		this.tamanhoTabuleiro = tamanhoTabuleiro;
			for (int i = 0; i < tabuleiro.length ; i++) {
	            for (int j = 0; j < tabuleiro.length; j++) {
	                tabuleiro[i][j] = "-";
	            }
			}	
	}
	
	public void realizaJogada(String caractere, Integer linha, Integer coluna) {			
		if(tabuleiro[linha][coluna] != "X" && tabuleiro[linha][coluna] != "O") {
			tabuleiro[linha][coluna] = caractere;	
			if(verificaGanhador() == true) {
				System.out.println(verificaGanhador());		
			}
		}
		else {
			System.out.println();
			System.out.println("*ATENÇÃO: posição inválida, escolha outra*");
		}
	}
	
	public boolean verificaGanhador() {
		if(tabuleiro[0][0] == "X" && tabuleiro[0][1] == "X" && tabuleiro[0][2] == "X" ||
				tabuleiro[0][0] == "O" && tabuleiro[0][1] == "O" && tabuleiro[0][2] == "O") {
			return true;
		}
		if(tabuleiro[1][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[1][2] == "X" ||
				tabuleiro[1][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[1][2] == "O") {
			return true;
		}
		if(tabuleiro[2][0] == "X" && tabuleiro[2][1] == "X" && tabuleiro[2][2] == "X" ||
				tabuleiro[2][0] == "O" && tabuleiro[2][1] == "O" && tabuleiro[2][2] == "O") {
			return true;
		}
		if(tabuleiro[0][0] == "X" && tabuleiro[1][0] == "X" && tabuleiro[2][0] == "X" ||
				tabuleiro[0][0] == "O" && tabuleiro[1][0] == "O" && tabuleiro[2][0] == "O") {
			return true;
		}
		if(tabuleiro[0][1] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][1] == "X" ||
				tabuleiro[0][1] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][1] == "O") {
			return true;
		}
		if(tabuleiro[0][2] == "X" && tabuleiro[1][2] == "X" && tabuleiro[2][2] == "X" ||
				tabuleiro[0][2] == "O" && tabuleiro[1][2] == "O" && tabuleiro[2][2] == "O") {
			return true;
		}
		if(tabuleiro[0][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][2] == "X" ||
				tabuleiro[0][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][2] == "O") {
			return true;
		}
		if(tabuleiro[0][2] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][0] == "X" ||
				tabuleiro[0][2] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][0] == "O") {
			return true;
		}
		return false;
	}

	public String toString() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				System.out.print(tabuleiro[i][j] + " ");
			}
			System.out.println();
		}
		return Arrays.toString(tabuleiro);
	}

}
