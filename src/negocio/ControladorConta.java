/**
 * 
 */
package negocio;

import java.util.ArrayList;
import java.util.List;

import classes_basicas.Conta;
import classes_basicas.Movimentacao;
import classes_basicas.Usuario;
import dados.IRepositorioConta;
import dados.RepositorioConta;
import excecao.ContaJaCadastradaException;
import excecao.ContaNaoEncontradaException;
import excecao.SenhaIncorretaException;


/**
 * @author Tamires Pereira
 *
 */
public class ControladorConta {
	public IRepositorioConta repositorioConta;
	
	public ControladorConta(){
		this.repositorioConta = RepositorioConta.getInstancia();
	}
	
	public void cadastrarConta(Conta conta) throws ContaJaCadastradaException{
		ArrayList<Conta> repositorio = repositorioConta.listarContas();
		for(int i = 0; i < repositorio.size(); i++){
			if(repositorio.get(i).getUsuario().equals(conta.getUsuario())){
				throw new ContaJaCadastradaException(conta);
				
				
			}
		}
		repositorioConta.cadastrarConta(conta);
		
	}
	
	public void removerConta(Conta conta) throws ContaNaoEncontradaException{
		ArrayList<Conta> repositorio = repositorioConta.listarContas();
		for(int i = 0; i < repositorio.size(); i++){
			if(repositorio.get(i).getUsuario().equals(conta.getUsuario())){
				repositorioConta.removerConta(conta);
				return;
			}
		}
		throw new ContaNaoEncontradaException();
				
	}
	
	public void alterarDadosConta(Conta conta) throws ContaNaoEncontradaException{
		ArrayList<Conta> repositorio = repositorioConta.listarContas();
		for(int i = 0; i < repositorio.size(); i++){
			if(repositorio.get(i).getUsuario().equals(conta.getUsuario())){
				repositorioConta.alterarDadosConta(conta);
				return;
			}
		}
		throw new ContaNaoEncontradaException();
		
	}
	
	public Conta exibirConta(Usuario usuario) throws ContaNaoEncontradaException{
		ArrayList<Conta> repositorio = repositorioConta.listarContas();
		for(int i = 0; i < repositorio.size(); i++){
			if(repositorio.get(i).getUsuario().equals(usuario)){
				return repositorio.get(i);
			}							
			
		}		
		throw new ContaNaoEncontradaException();
		
	}
	
	
	public void consultarSaldo(Conta conta) throws ContaNaoEncontradaException{
		ArrayList<Conta> repositorio = repositorioConta.listarContas();
		for(int i = 0; i < repositorio.size(); i++){
			if(repositorio.get(i).getUsuario().equals(conta.getUsuario())){
				repositorioConta.consultarSaldo(conta);
				return;
			}
		}	
		throw new ContaNaoEncontradaException();
				
	}
	
	public void verMovimentacoes(Conta conta) throws ContaNaoEncontradaException{
		ArrayList<Conta> repositorio = repositorioConta.listarContas();
		for(int i = 0; i < repositorio.size(); i++){
			if(repositorio.get(i).getUsuario().equals(conta.getUsuario())){
				repositorioConta.verMovimentacoes(conta);
				return;
			}
		}	
		throw new ContaNaoEncontradaException();
	}
	
	public ArrayList<Conta> listarContas(){	
		return repositorioConta.listarContas();
	}

	public Conta verificarLogin(String nome, String senha) throws SenhaIncorretaException, UsuarioNaoEncontradoException{
		Conta conta = null;
		boolean senhaU = false;
		boolean nomeU = false;
		
		if (!senha.equals("")) senhaU = repositorioConta.verificarSenhaJaExiste(senha);
		if (!nome.equals("")) nomeU = repositorioConta.verificarNomeUsuarioJaExiste(nome);

		if (senhaU && nomeU){
			conta = repositorioConta.verificarLogin(nome, senha);
		} else if (nomeU == false && senhaU){
			throw new UsuarioNaoEncontradoException();
		} else if (nomeU && senhaU == false){
			throw new SenhaIncorretaException();
		} else {
			throw new UsuarioNaoEncontradoException();
		}

		if (nomeU && conta == null) throw new SenhaIncorretaException();
		return conta;
	
		
	}
	

}



	