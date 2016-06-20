package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import classes_basicas.Conta;
import classes_basicas.Usuario;


public class RepositorioConta implements IRepositorioConta, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Conta> contas;
	private static RepositorioConta instancia;


	public RepositorioConta() {
		this.contas = new ArrayList<>();
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

	public static void gravarArquivo() {
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

	public boolean cadastrarConta(Conta conta){ 

		if (this.contas.contains(conta)) {
			return false;
		} 
		else {
			contas.add(conta);
			gravarArquivo();

			return true;
		}
	}


	public void removerConta(Conta conta){		
		contas.remove(conta);
		gravarArquivo();

	}


	public void alterarDadosConta(Conta conta){
		int i = contas.indexOf(conta);
		contas.set(i, conta);
		gravarArquivo();
	}	

	public Conta exibirConta(Usuario usuario){
		Conta encontra = null;
		for(int i = 0; i < contas.size(); i++){
			if(contas.get(i).getUsuario().equals(usuario)){
				encontra = contas.get(i);
				break;		
			}
		}
		return encontra;
	}	

	public boolean procurarConta (Conta conta){
		boolean contaExiste = false;
		for (Conta c : contas){
			if (c.equals(conta)){
				contaExiste = true;
				break;
			}
		}
		return contaExiste;
	}

	public void consultarSaldo(Conta conta){	
		for(int i = 0; i < contas.size(); i++){
			if(contas.get(i).getUsuario().equals(conta.getUsuario())){
				contas.get(i).getSaldo();			
			}
		}
	}

	public void verMovimentacoes(Conta conta){
		for(int i = 0; i < contas.size(); i++){
			if(contas.get(i).getUsuario().equals(conta.getUsuario())){
				contas.get(i).getHistorico();
			}
		}			
	}
	public ArrayList<Conta> listarContas(){	
		if(contas!=null){
			Collections.sort(contas);

		}
		return contas;	
	}

	public boolean verificarNomeUsuarioJaExiste(String nomeUsuario) {
		boolean nomeUsuarioJaExiste = false;
		if (nomeUsuario != null){
			if (contas.size() > 0){
				for (int i = 0; i < contas.size(); i++){
					if (contas.get(i).getLogin().equals(nomeUsuario)){
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
			for (int i = 0; i < contas.size(); i++){
				if (contas.get(i).getSenha().equals(senha)){
					senhaJaExiste = true;
					break;
				}
			}
		} else senhaJaExiste = true;
		return senhaJaExiste;
	}


	public Conta verificarLogin(String login, String senha) {
		Conta conta = null;
		for (int i = 0; i < contas.size(); i++){
			if (contas.get(i).getLogin().equals(login) && contas.get(i).getSenha().equals(senha)){
				conta = contas.get(i);
				break;
			}
		}
		return conta;
	}

	@Override
	public Conta procurarConta(String CPF) {
		Conta conta = null;
		for(int i = 0; i < contas.size(); i++){
			if(contas.get(i).getUsuario().getCpf().equals(CPF)){
				conta = contas.get(i);	
				break;
			}
		}
		return conta;
	}

	@Override
	public int retornarIndice(Conta conta) {
		int posicao = -1;
		for(int i = 0; i < contas.size(); i++){
			if(contas.get(i).equals(conta)){
				posicao = i;
				break;
			}
		}
		return posicao;
	}
}
