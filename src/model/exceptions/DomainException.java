package model.exceptions;

/*
 * M�todo para retorar uma excess�o personalizada
 * Retorna a mensagem escolhida.
 */
public class DomainException extends RuntimeException{
	private static final long setialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg);
	}
}
