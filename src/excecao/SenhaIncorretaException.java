/**
 * 
 */
package excecao;

/**
 * @author Aluno
 *
 */
public class SenhaIncorretaException extends Exception  {

	private static final long serialVersionUID = 1L;
	
	public SenhaIncorretaException(){
		super("Senha Incorreta!");
	}
}
