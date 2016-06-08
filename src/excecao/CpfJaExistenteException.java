/**
 * 
 */
package excecao;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class CpfJaExistenteException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CpfJaExistenteException(){
		super("CPF já existe!");
	}
}
