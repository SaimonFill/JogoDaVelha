package application;

import java.util.Scanner;

import model.entities.JogoDaVelha;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		int pontos = 0;
		int jogadas = 0;		
		
		System.out.println("JOGO DA VELHA!");
		System.out.print("Informe o nome do jogador 1: ");
		String jogador1 = sc.nextLine();		
		System.out.print("Informe o nome do jogador 2: ");
		String jogador2 = sc.nextLine();
		System.out.print("Informe o tamanho do tabuleiro: ");
		int tamanhoTabuleiro = sc.nextInt();
		JogoDaVelha jogo = new JogoDaVelha(tamanhoTabuleiro);			
				
		System.out.println();
		while(jogadas < 9 || jogo.verificaGanhador() == false) {			
			
			if(jogadas == 0) {
				jogo.setTamanhoTabuleiro(tamanhoTabuleiro);
			}
			
			System.out.println("Vez do 'X':");
			System.out.print("Linha: ");
			int linha = sc.nextInt();
			System.out.print("Coluna: ");
			int coluna = sc.nextInt();					
			jogo.realizaJogada("X", linha, coluna);
			jogo.toString();
			System.out.println();
			
			System.out.println("Vez do 'Y':");
			System.out.print("Linha: ");
			linha = sc.nextInt();
			System.out.print("Coluna: ");
			coluna = sc.nextInt();			
			jogo.realizaJogada("O", linha, coluna);
			jogo.toString();
			System.out.println();			
			
			jogadas++;
		}
		
		
		sc.close();
	}

}
