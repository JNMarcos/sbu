/**
 * 
 */
package excecao;

import classes_basicas.Conta;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class ContaJaCadastradaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ContaJaCadastradaException(Conta conta){
		super("Conta já existe!");
	}
}
