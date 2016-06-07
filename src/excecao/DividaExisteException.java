package excecao;
	
/*
 * @author ramices
 * 
 */

public class DividaExisteException extends Exception{
	
	public DividaExisteException()
	{
		super("A divida já existe no sistema.");
		
	}
	
}
