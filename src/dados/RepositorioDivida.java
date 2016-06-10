package dados;

/*
 * @author ramicesmoises
 * 
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import classes_basicas.Conta;
import classes_basicas.Divida;

public class RepositorioDivida implements IRepositorioDivida, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Divida> dividas;
	private static RepositorioDivida instanciaRepositorio;
	
	public RepositorioDivida()
	{
		
		dividas = new ArrayList<Divida>();
		
		
	}
	
	
	public static RepositorioDivida getInstancia()
	{
		
		if(instanciaRepositorio == null)
		{
			
			instanciaRepositorio = lerArquivo();
			
		}
		
		return instanciaRepositorio;
		
	}
	
	
	public static RepositorioDivida lerArquivo()
	{	
		
		RepositorioDivida instanciaLocal = null;
		
		File f;
		FileInputStream fis;
		ObjectInputStream ois = null;
		
		try
		{
			
			f = new File("RepositorioDivida.dat");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			
			Object o = ois.readObject();
			instanciaLocal = (RepositorioDivida) o;
			
		}
		catch(Exception e)
		{
			
			instanciaLocal = new RepositorioDivida();
			
		}
		finally
		{
			
			if(ois != null)
			{
				
				try
				{
					
					ois.close();
					
				}
				catch(Exception e)
				{
					
				}
				
			}
			
		}
		
		return instanciaLocal;
		
	}
	
	
	public static void gravarArquivo()
	{	
		
		if(instanciaRepositorio == null)
		{
		
			return;
		
		}
	
		
		File f;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try
		{
			
			f = new File("RepositorioDivida.dat");
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(instanciaRepositorio);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			
			if (oos != null) 
			{
				
				try 
				{
				   oos.close();
				
				} 
				catch (IOException e)
				{
				
				}
			}
			
			
		}
		
		
	}

	
	public void cadastrarDivida(Divida divida)
	{
		
		dividas.add(divida);
		gravarArquivo();
		
	}
	
	
	public void removerDivida(Divida divida)
	{
	
		dividas.remove(divida);
		gravarArquivo();
		
	}
	
	
	public void alterarDadosDivida(Divida divida)
	{
		
		int index = dividas.indexOf(divida);
		dividas.set(index, divida);
		gravarArquivo();
		
		
	}
	
	
	public Divida exibirDivida(Conta nome, LocalDate data, LocalTime hora)
	{	
		
		int index;
		Divida divida = null;
		
		for(index = 0; index < dividas.size(); index++)
		{
			
			if(dividas.get(index).getConta().equals(nome) && 
			   dividas.get(index).getDataEmissao().equals(data) &&
			   dividas.get(index).getHoraEmissao().equals(hora))
			{
				
				divida = dividas.get(index);
				break;
				
			}
				
			
		}
			
		
		return divida;
		
	}
	
	public boolean procurarDivida (Divida divida){
		boolean dividaExiste = false;
		for (Divida d : dividas){
			if (d.equals(divida)){
				dividaExiste = true;
				break;
			}
		}
		return dividaExiste;
	}
	
	public List<Divida> listarDividas()
	{
		
		return dividas;
		
	}	
}
