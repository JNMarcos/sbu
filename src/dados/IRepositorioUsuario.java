package dados;

import java.util.ArrayList;

import classes_basicas.Usuario;

public interface IRepositorioUsuario {
	public boolean cadastrarUsuario(Usuario usuario) ;
	public void removerUsuario(Usuario usuario);
	public void alterarDadosUsuario(Usuario usuario);
	public ArrayList<Usuario> listarUsuarios();
}
