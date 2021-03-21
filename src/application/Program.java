package application;

import java.util.Scanner;

import model.entities.Jogador;
import model.entities.JogoDaVelha;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		Jogador[] jogadores = new Jogador[2];

		int pontos = 0;
		int jogadas = 0;	
		char op = 's';

		/*
		 * Inicializa os jogadores e o tamanho do tabuleiro
		 */
		System.out.print("\n\t*** JOGO DA VELHA ***\n\n");
		System.out.println("Jogador 0 joga com 'X'");
		System.out.println("Jogador 1 joga com 'O'");
		System.out.println();
		for(int i = 0; i < jogadores.length; i++) {
			System.out.print("Informe o nome do jogador " + i + ": ");
			String jogador = sc.nextLine();
			jogadores[i] = new Jogador(jogador, pontos);
		}
		System.out.println();
		System.out.print("Informe o tamanho do tabuleiro: ");
		int tamanhoTabuleiro = sc.nextInt();
		JogoDaVelha jogo = new JogoDaVelha(tamanhoTabuleiro);	

		System.out.println();

		/*
		 * Recebe os comando do jogo e verifica ganhador
		 */
		while(op == 's') {		
			
			/*
			 * Cada vez que for a primeira jogada,
			 * vai inicializar o tabuleiro zerado.
			 */
			if(op == 's') {
				if(jogadas == 0) {
					jogo.setTamanhoTabuleiro(tamanhoTabuleiro);
					jogo.toString();
					System.out.println();
				}
				/*
				 * Recebe os comandos dos jogadores, linha e coluna das jogadas.
				 */
				for(int i = 0; i < jogadores.length; i++) {
					System.out.println("Vez do(a) " + jogadores[i].getJogador());
					System.out.print("Linha: ");
					int linha = sc.nextInt();
					System.out.print("Coluna: ");
					int coluna = sc.nextInt();
					try {
						if(i == 0) {
							jogo.realizaJogada("X", linha, coluna);
							System.out.println();
						}
						else {
							jogo.realizaJogada("O", linha, coluna);
							System.out.println();
						}
					}
					catch(DomainException e) {
						System.out.println("ERRO: " + e.getMessage());
						jogadas -= 1;
						i -= 1;
						System.out.println();
					}
					jogo.toString();
					jogadas++;
					System.out.println();

					/*
					 * Verifica se há um ganhador e se tiver, mostra os pontos.
					 * Pede se quer encerrar ou iniciar novo jogo.
					 */
					if(jogo.verificaGanhador()) {
						jogadores[i].somaPontos();
						System.out.println("TEM UM GANHADOR: ");
						System.out.println(jogadores[0].toString());
						System.out.println(jogadores[1].toString());
						System.out.println();
						System.out.println("Iniciar novo jogo? s/n");
						op = sc.next().charAt(0);
						if(op == 's') {
							jogadas = 0;
							break;
						}
						else {
							System.out.println("Jogo encerrado!");
							break;
						}
					}
					if(!jogo.verificaGanhador() && jogadas == 9) {
						System.out.println();
						System.out.println("DEU VELHA! SEM GANHADOR!");
						System.out.println("Iniciar novo jogo? s/n");
						op = sc.next().charAt(0);
						if(op == 's') {
							jogadas = 0;
							break;
						}
						else {
							System.out.println("Jogo encerrado!");
							break;
						}
					}
				}
			}
			else {
				break;
			}
			System.out.println();			
		}
		sc.close();
	}

}
