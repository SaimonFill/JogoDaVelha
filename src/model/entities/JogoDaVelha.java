package model.entities;

import java.util.Arrays;

import model.exceptions.DomainException;

public class JogoDaVelha {

	private int tamanhoTabuleiro;

	String[][] tabuleiro;

	public JogoDaVelha() {}

	public JogoDaVelha(int tamanhoTabuleiro) {
		this.tamanhoTabuleiro = tamanhoTabuleiro;
	}
	
	public int getTamanhoTabuleiro() {
		return tamanhoTabuleiro;
	}

	/*
	 * Vai formatar o tabuleiro zerado de acordo com o tamanho
	 * escolhido pelo usuário
	 */
	public void setTamanhoTabuleiro(int tamanhoTabuleiro) {
		this.tamanhoTabuleiro = tamanhoTabuleiro;
		tabuleiro = new String[tamanhoTabuleiro][tamanhoTabuleiro];
		for (int i = 0; i < tabuleiro.length ; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				tabuleiro[i][j] = "-";
			}
		}	
	}

	/*
	 * Recebe os comando de linha e coluna
	 * realiza as jogadas.
	 */
	public void realizaJogada(String caractere, int linha, int coluna) {			
		if(tabuleiro[linha][coluna] != "X" && tabuleiro[linha][coluna] != "O") {
			tabuleiro[linha][coluna] = caractere;
		}
		else {
			System.out.println();
			throw new DomainException("Posição inválida, tente novamente: ");
		}
	}

	/*
	 * A cada rodada o método é chamado e vai verificar se há um ganhador.
	 */
	public boolean verificaGanhador() {
		int acertos = 0;
		int y = tamanhoTabuleiro;
		int z = tamanhoTabuleiro;

		/*
		 * Testa todas as linhas horizontalmente
		 */
		for(int i = 0; i < tabuleiro.length; i ++) {
			for(int j = 0; j <tabuleiro.length; j++) {
				if(tabuleiro[i][j] == "X") {
					acertos++;
				}
			}
			if(acertos == tabuleiro.length) {
				return true;
			}else {
				acertos = 0;
			}			
		}		
		for(int i = 0; i < tabuleiro.length; i ++) {
			for(int j = 0; j <tabuleiro.length; j++) {
				if(tabuleiro[i][j] == "O") {
					acertos++;
				}
			}
			if(acertos == tabuleiro.length) {
				return true;
			}else {
				acertos = 0;
			}			
		}		
		/*
		 * Testa todas as linhas verticalmente
		 */
		for(int i = 0; i < tabuleiro.length; i ++) {
			for(int j = 0; j <tabuleiro.length; j++) {
				if(tabuleiro[j][i] == "X") {
					acertos++;
				}
			}
			if(acertos == tabuleiro.length) {
				return true;
			}else {
				acertos = 0;
			}			
		}		
		for(int i = 0; i < tabuleiro.length; i ++) {
			for(int j = 0; j <tabuleiro.length; j++) {
				if(tabuleiro[j][i] == "O") {
					acertos++;
				}
			}
			if(acertos == tabuleiro.length) {
				return true;
			}else {
				acertos = 0;
			}			
		}	
		/*
		 * Testa as diagonais
		 */
		for(int i = 0; i < tabuleiro.length; i ++) {
			if(tabuleiro[i][i] == "X") {
				acertos++;
			}
		}
		if(acertos == tabuleiro.length) {
			return true;
		}else {
			acertos = 0;
		}	
		for(int i = 0; i < tabuleiro.length; i ++) {
			if(tabuleiro[i][i] == "O") {
				acertos++;
			}
		}
		if(acertos == tabuleiro.length) {
			return true;
		}else {
			acertos = 0;
		}	
		for(int i = 0; i < tabuleiro.length; i++) {
			y -= 1;
			if(tabuleiro[y][i] == "X") {
				acertos++;
			}
		}
		if(acertos == tabuleiro.length) {
			return true;
		}else {
			acertos = 0;
		}
		for(int i = 0; i < tabuleiro.length; i++) {
			z -= 1;
			if(tabuleiro[z][i] == "O") {
				acertos++;
			}
		}
		if(acertos == tabuleiro.length) {
			return true;
		}else {
			acertos = 0;
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
