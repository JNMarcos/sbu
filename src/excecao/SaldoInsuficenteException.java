/**
 * 
 */
package excecao;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class SaldoInsuficenteException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public SaldoInsuficenteException(){
		super("Saldo insuficiente!");
	}
	
}
