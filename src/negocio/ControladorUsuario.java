package negocio;

import java.util.ArrayList;

import classes_basicas.Usuario;
import dados.IRepositorioUsuario;
import dados.RepositorioUsuario;
import excecao.CpfJaExistenteException;
import excecao.UsuarioNaoEncontradoException;

/**
 * 
 * @author ramices
 *
 */




public class ControladorUsuario {

	IRepositorioUsuario repositorioUsuario;

	public ControladorUsuario()
	{

		repositorioUsuario = RepositorioUsuario.getInstancia();


	}

	
	public ArrayList<Usuario> listarUsuarios()
	{
		
		return repositorioUsuario.listarUsuarios();
		
	}
	
	public void cadastrarUsuario(Usuario usuario) throws CpfJaExistenteException
	{

		int index;

		ArrayList<Usuario> repositorioUsuarioLocal = repositorioUsuario.listarUsuarios();
		
		index = pesquisar(repositorioUsuarioLocal, usuario);
		
		if(index < 0)
		repositorioUsuario.cadastrarUsuario(usuario);
		
		else
			throw new CpfJaExistenteException();
		
	}

	public int pesquisar(ArrayList<Usuario> user, Usuario usuario)
	{

		int index = -1;

		for(int i = 0; i < user.size(); i++)
		{

			if(user.get(i).getCpf().equals(usuario.getCpf()))
			{
				index = i;
				break;
			}


		}

		return index;

	}

	public void removerUsuario(Usuario usuario) throws UsuarioNaoEncontradoException
	{

		ArrayList<Usuario> repositorioUsuarioLocal = repositorioUsuario.listarUsuarios();
		int index = pesquisar(repositorioUsuarioLocal, usuario);

		if(index < 0)
			throw new UsuarioNaoEncontradoException();

		else
			repositorioUsuario.removerUsuario(usuario);


	}


	public void alterarDadosUsuario(Usuario usuario) throws UsuarioNaoEncontradoException
	{

		ArrayList<Usuario> repositorioUsuarioLocal = repositorioUsuario.listarUsuarios();
		int index = pesquisar(repositorioUsuarioLocal, usuario);

		if(index < 0)
			throw new UsuarioNaoEncontradoException();

		else
			repositorioUsuario.alterarDadosUsuario(usuario);

		return;

	}


	public Usuario procurarPorCpf(String cpf) throws CpfJaExistenteException
	{

		int index;
		ArrayList<Usuario> user = repositorioUsuario.listarUsuarios();

		for(index = 0; index < user.size(); index++)
		{
			if(user.get(index).getCpf().equals(cpf))
				return user.get(index);

		}

		throw new CpfJaExistenteException();

	}



}
