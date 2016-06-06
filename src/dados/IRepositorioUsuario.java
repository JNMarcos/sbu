package dados;

import java.util.ArrayList;

import classes_basicas.Usuario;

public interface IRepositorioUsuario {
	public boolean cadastrarUsuário(Usuario usuario) throws CpfJaExistenteException;
	
	public void removerUsuario(Usuario usuario) throws UsuarioNaoEncontradoException;
	
	public void alterarDadosUsuario(Usuario usuario) throws UsuarioNaoEncontradoException;
		
	public ArrayList<Usuario> listarUsuarios();
	
	public RepositorioUsuario lerDoArquivo();
	
	public void gravarArquivo();
	
	public Usuario procurarPorCpf(String cpf) throws CpfNaoExisteException;
	
	
	
}
