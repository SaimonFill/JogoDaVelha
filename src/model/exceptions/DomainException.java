package model.exceptions;

/*
 * Método para retorar uma excessão personalizada
 * Retorna a mensagem escolhida.
 */
public class DomainException extends RuntimeException{
	private static final long setialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg);
	}
}
