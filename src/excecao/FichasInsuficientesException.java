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
		super("Infelizmente voc� n�o tem mais fichas.");
	}

}
