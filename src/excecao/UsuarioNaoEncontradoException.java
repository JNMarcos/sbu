/**
 * 
 */
package excecao;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class UsuarioNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException(){
		super("Usuario não encontrado!");
	}
}
