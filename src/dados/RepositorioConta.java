package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import classes_basicas.Conta;
import classes_basicas.Divida;
import classes_basicas.Movimentacao;
import classes_basicas.Usuario;


public class RepositorioConta implements IRepositorioConta, Serializable {
	private ArrayList<Conta> listaContas;
	private static RepositorioConta instancia;
	public static ControladorConta controladorConta = new ControladorConta();
	
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
    
    
	public void cadastrarConta(Conta conta) throws ContaJaCadastradaException{        
        listaContas.add(conta);
        gravarArquivo();
	}
	
	
	public void removerConta(Conta conta) throws ContaNaoEncontradaException {		
		listaContas.remove(conta);
		gravarArquivo();
	
    }
	
	
	public void alterarDadosConta(Conta conta) throws ContaNaoEncontradaException {
		int i = listaContas.indexOf(conta);
		listaContas.set(i, conta);
		gravarArquivo();
	}	
	
	public Conta exibirConta(Usuario usuario) throws ContaNaoEncontradaException{
		Conta encontra = null;
		for(int i = 0; i < listaContas.size(); i++){
			if(listaContas.get(i).getUsuario().equals(usuario)){
				encontra = listaContas.get(i);
				break;
				
			}
		}
		return encontra;
	}
	
	
	public Double consultarSaldo(Conta conta) throws ContaNaoEncontradaException{		
		for(int i = 0; i < listaContas.size(); i++){
			if(listaContas.get(i).getUsuario().equals(conta.getUsuario())){
				return listaContas.get(i).getSaldo();
			}
		}
		
	}
	
	public List<Movimentacao> verMovimentacoes(Conta conta) throws ContaNaoEncontradaException{
		for(int i = 0; i < listaContas.size(); i++){
			if(listaContas.get(i).getUsuario().equals(conta.getUsuario())){
				return listaContas.get(i).getHistorico();
			}
		}
		
}
	public ArrayList<Conta> listarContas(){		
		return listaContas;		
	}
	
}
