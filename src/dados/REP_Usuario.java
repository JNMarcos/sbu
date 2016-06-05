package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import classes_basicas.Usuario;


public class REP_Usuario implements IREP_Usuario {
	ArrayList<Usuario> usuarios =  new ArrayList<Usuario>();
	public static ControladorUsuario controladorUsuario = new ControladorUsuario();
	private static REP_Usuario instancia;

	public static REP_Usuario getInstancia() {
		if (instancia == null) {
			instancia = lerDoArquivo();
		}
		return instancia;
	}
	public boolean cadastrarUsuário(Usuario usuario) throws CpfJaExistenteException{
		if (this.usuarios.contains(usuario)) {
			return false;
		} 
		else {
			this.usuarios.add(usuario);
			this.gravarArquivo();

			return true;
		}
	}

	public void removerUsuario(Usuario usuario) throws UsuarioNaoEncontradoException{
		this.usuarios.remove(usuario);
		this.gravarArquivo();
	}

	public void alterarDadosUsuario(Usuario usuario) throws UsuarioNaoEncontradoException{
		if (arrayUsuario(this.arquivoUsuario).isEmpty()) {
			this.lerArquivo();
		}
		Usuario alterar = this.procurarPorCpf(usuario.getCpf());
		this.usuarios.remove(alterar);
		this.gravarArquivo();
		return alterar;
	}

	private static REP_Usuario lerDoArquivo() {
		REP_Usuario instanciaLocal = null;

		File in = new File("repositorioUsuario.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (REP_Usuario) o;
		} catch (Exception e) {
			instanciaLocal = new REP_Usuario();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}

		return instanciaLocal;
	}
	public void gravarArquivo()   {
		if (instancia == null) {
			return;
		}
		File out = new File("repositorioUsuario.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instancia);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
		}
	}

	private Usuario procurarPorCpf(String cpf) throws CpfNaoExisteException{
		if(usuarios.isEmpty()){
			this.lerArquivo();
		}
		Usuario buscado = null;
		for(Usuario busca : this.usuarios){
			if(busca.getCpf().equals(cpf)){
				buscado = busca;
			}
		}
		if (buscado == null) 
			throw new CpfNaoEncontradoException();
		return buscado;


	}
	
	public ArrayList<Usuario> listarUsuarios(){
		if(this.usuarios!=null){
			Collections.sort(usuarios);
		}
		return usuarios;
	}
	
	

}
