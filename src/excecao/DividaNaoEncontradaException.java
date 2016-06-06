/**
 * 
 */
package excecao;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class DividaNaoEncontradaException extends Exception{

	private static final long serialVersionUID = 1L;

	public DividaNaoEncontradaException(){
		super("Divida não encontrada");
	}
}
