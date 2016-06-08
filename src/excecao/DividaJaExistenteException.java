package excecao;
	
/*
 * @author ramices
 * 
 */

public class DividaJaExistenteException extends Exception{
	
	public DividaJaExistenteException()
	{
		super("A divida já existe no sistema.");
		
	}
	
}
