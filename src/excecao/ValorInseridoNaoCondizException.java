/**
 * 
 */
package excecao;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class ValorInseridoNaoCondizException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ValorInseridoNaoCondizException(){
		super("O valor inserido não condiz com o digitado!");
	}
}
