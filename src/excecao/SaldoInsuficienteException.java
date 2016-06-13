/**
 * 
 */
package excecao;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class SaldoInsuficienteException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public SaldoInsuficienteException(){
		super("Saldo insuficiente!");
	}
	
}
