/**
 * 
 */
package excecao;

/**
 * @author JN
 *
 */
public class FichasInsuficientesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FichasInsuficientesException (){
		super("Infelizmente você não tem mais fichas.");
	}

}
