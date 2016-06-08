package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import classes_basicas.Conta;
import classes_basicas.Usuario;


public class RepositorioConta implements IRepositorioConta, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Conta> listaContas;
	private static RepositorioConta instancia;
	
	
    public RepositorioConta() {
        this.listaContas = new ArrayList<>();
    }
    
    public static RepositorioConta getInstancia(){
    	if(instancia == null){
    		instancia = lerArquivo();
    	}
    	return instancia;
    }
    
    private static RepositorioConta lerArquivo() {
		RepositorioConta instanciaLocal = null;

		File in = new File("repositorioConta.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioConta) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioConta();
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
    
    private static void gravarArquivo() {
		if (instancia == null) {
			return;
		}
		File out = new File("repositorioConta.dat");
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

    public ArrayList<Conta> getListaContas() {
        return listaContas;
    }
    
    
	public void cadastrarConta(Conta conta){        
        listaContas.add(conta);
        gravarArquivo();
	}
	
	
	public void removerConta(Conta conta){		
		listaContas.remove(conta);
		gravarArquivo();
	
    }
	
	
	public void alterarDadosConta(Conta conta){
		int i = listaContas.indexOf(conta);
		listaContas.set(i, conta);
		gravarArquivo();
	}	
	
	public Conta exibirConta(Usuario usuario){
		Conta encontra = null;
		for(int i = 0; i < listaContas.size(); i++){
			if(listaContas.get(i).getUsuario().equals(usuario)){
				encontra = listaContas.get(i);
				break;
				
			}
		}
		return encontra;
	}	
	
	public void consultarSaldo(Conta conta){	
		for(int i = 0; i < listaContas.size(); i++){
			if(listaContas.get(i).getUsuario().equals(conta.getUsuario())){
				listaContas.get(i).getSaldo();
				
			}
		}
		
	}
	
	public void verMovimentacoes(Conta conta){
		for(int i = 0; i < listaContas.size(); i++){
			if(listaContas.get(i).getUsuario().equals(conta.getUsuario())){
				listaContas.get(i).getHistorico();
			}
		}
				
}
	public ArrayList<Conta> listarContas(){		
		return listaContas;		
	}
	
	public boolean verificarNomeUsuarioJaExiste(String nomeUsuario) {
		boolean nomeUsuarioJaExiste = false;
		if (nomeUsuario != null){
			if (listaContas.size() > 0){
				for (int i = 0; i < listaContas.size(); i++){
					if (listaContas.get(i).getUsuario().getNome().equals(nomeUsuario)){
						nomeUsuarioJaExiste = true;
						break;
					}
				}
			}
		} else nomeUsuarioJaExiste = true;
		return nomeUsuarioJaExiste;
	}

	public boolean verificarSenhaJaExiste(String senha) {
		boolean senhaJaExiste = false;
		if (senha != null){
			for (int i = 0; i < listaContas.size(); i++){
				if (listaContas.get(i).getSenha().equals(senha)){
					senhaJaExiste = true;
					break;
				}
			}
		} else senhaJaExiste = true;
		return senhaJaExiste;
	}

	
	public Conta verificarLogin(String nome, String senha) {
		Conta conta = null;
		for (int i = 0; i < listaContas.size(); i++){
			if (listaContas.get(i).getUsuario().getNome().equals(nome) && listaContas.get(i).getSenha().equals(senha)){
				conta = listaContas.get(i);
				break;
			}
		}

		return conta;
	}
	
}
