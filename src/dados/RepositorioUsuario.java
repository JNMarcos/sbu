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


public class RepositorioUsuario implements IRepositorioUsuario {
	ArrayList<Usuario> usuarios =  new ArrayList<Usuario>();
	public static ControladorUsuario controladorUsuario = new ControladorUsuario();
	private static RepositorioUsuario instancia;

	public static RepositorioUsuario getInstancia() {
		if (instancia == null) {
			instancia = lerDoArquivo();
		}
		return instancia;
	}
	public boolean cadastrarUsuário(Usuario usuario) {
		if (this.usuarios.contains(usuario)) {
			return false;
		} 
		else {
			this.usuarios.add(usuario);
			this.gravarArquivo();

			return true;
		}
	}

	public void removerUsuario(Usuario usuario) {
		this.usuarios.remove(usuario);
		this.gravarArquivo();
	}

	public void alterarDadosUsuario(Usuario usuario) {
		if (arrayUsuario(this.arquivoUsuario).isEmpty()) {
			this.lerDoArquivo();
		}
		Usuario alterar = this.procurarPorCpf(usuario.getCpf());
		this.usuarios.remove(alterar);
		this.gravarArquivo();
		return alterar;
	}

	public RepositorioUsuario lerDoArquivo() {
		RepositorioUsuario instanciaLocal = null;

		File in = new File("repositorioUsuario.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioUsuario) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioUsuario();
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


	
	public ArrayList<Usuario> listarUsuarios(){
		if(this.usuarios!=null){
			Collections.sort(usuarios);
		}
		return usuarios;
	}
	
	

}
