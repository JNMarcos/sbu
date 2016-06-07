package negocio;

import java.util.ArrayList;

import classes_basicas.Divida;
import dados.IRepositorioDivida;
import dados.RepositorioDivida;
import excecao.DividaNaoEncontradaException;
import excecao.DividaExisteException;

/*
 * 
 * @author ramices
 * 
 */

public class ControladorADMBiblioteca {
	
	IRepositorioDivida interfaceRepositorio;
	
	public ControladorADMBiblioteca()
	{
		
		interfaceRepositorio = RepositorioDivida.getInstancia();
		
	}
	
	public int pesquisar(ArrayList<Divida> repositorioLocal, Divida divida)
	{
		
		int index = 0;
		int i;
		
		for(i = 0; i < repositorioLocal.size(); i++)
		{
			if(repositorioLocal.get(i).equals(divida) &&
			   repositorioLocal.get(i).getDataEmissao().equals(divida.getDataEmissao()) &&
			   repositorioLocal.get(i).getHoraEmissao().equals(divida.getHoraEmissao()))
			{
				
				index = i;
				break;
				
			}
			
			
		}
		
		
		return i;
		
	}
	
	
	public void adicionarDivida(Divida divida) throws DividaExisteException
	{
		
		
		ArrayList<Divida> repositorioLocal = (ArrayList<Divida>) RepositorioDivida.getInstancia().listarDividas();
		
		int i = pesquisar(repositorioLocal, divida);
		
		
		if(i == 0)
			interfaceRepositorio.cadastrarDivida(divida);
		else
			throw new DividaExisteException();
		
		
	}
	
	
	
	public void alterarDadosDivida(Divida divida) throws DividaNaoEncontradaException
	{
		
		ArrayList<Divida> repositorioLocal = (ArrayList<Divida>) interfaceRepositorio.listarDividas();
		
		int index = pesquisar(repositorioLocal, divida);
		
		if(index == 0)
			throw new DividaNaoEncontradaException();
		else
			interfaceRepositorio.alterarDadosDivida(divida);
			
		
	}
	
	public void removerDivida(Divida divida) throws DividaNaoEncontradaException
	{
		
		ArrayList<Divida> repositorioLocal = (ArrayList<Divida>) interfaceRepositorio.listarDividas();
		
		int index = pesquisar(repositorioLocal, divida);
		
		if(index == 0)
			throw new DividaNaoEncontradaException();
		else
			interfaceRepositorio.removerDivida(divida);
			
		
		
		
	}	
}
