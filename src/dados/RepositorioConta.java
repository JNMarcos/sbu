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
    
    
	public boolean cadastrarConta(Conta conta) throws ContaJaCadastradaException{
        int x = 0;
        if (listaContas.isEmpty()) {
        	listaContas.add(conta);
        	gravarArquivo();
            x++;
            return true;
        } else {
            for (int i = 0; i < listaContas.size(); i++) {
                if (listaContas.get(i).getUsuario().equals(conta.getUsuario())) {
                    x++;
                }
            }
        }
        if (x == 0) {
            listaContas.add(conta);
            gravarArquivo();
            return true;
   
        }else
        	return false;
   

    }
	
	
	public boolean removerConta(Conta conta) throws ContaNaoEncontradaException {
		for(int i = 0; i < listaContas.size(); i++){
			if(listaContas.get(i).getUsuario().equals(conta.getUsuario())){
				listaContas.remove(conta);
				gravarArquivo();
				}
		}
		return true;
		
    }
	
	
	public boolean alterarDadosConta(Conta conta) throws ContaNaoEncontradaException {
	     for (int i = 0; i < listaContas.size(); i++) {
	         if (listaContas.get(i).getUsuario().equals(conta.getUsuario())) {
	            listaContas.set(i, conta);
	            gravarArquivo();
	                break;
	            }
	        }
	    return true;
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
	
	
	public void consultarSaldo(Conta conta) throws ContaNaoEncontradaException{		
		for(int i = 0; i < listaContas.size(); i++){
			if(listaContas.get(i).getUsuario().equals(conta.getUsuario())){
				System.out.println(listaContas.get(i).getSaldo());
			}
		}
		
	}
	
	public void verMovimentacoes(Conta conta) throws ContaNaoEncontradaException{
		for(int i = 0; i < listaContas.size(); i++){
			if(listaContas.get(i).getUsuario().equals(conta.getUsuario())){
				System.out.println(listaContas.get(i).getHistorico());
			}
		}
		
}
	public void listarContas(){
		for(int i = 0;i <listaContas.size();i++){ 
		     System.out.println(listaContas.get(i));    
		}  
	}


}
