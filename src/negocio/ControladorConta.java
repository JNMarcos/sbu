/**
 * 
 */
package negocio;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import classes_basicas.Conta;
import classes_basicas.Divida;
import classes_basicas.Servico;
import classes_basicas.Usuario;
import dados.IRepositorioConta;
import dados.RepositorioConta;
import excecao.ContaJaCadastradaException;
import excecao.ContaNaoEncontradaException;
import excecao.SenhaIncorretaException;
import excecao.UsuarioNaoEncontradoException;


/**
 * @author Tamires Pereira
 *
 */
public class ControladorConta {
	public IRepositorioConta repositorioConta;
	private final static int QUANTIDADE_DIAS_NO_ANO = 365;
	private final static int QUANTIDADE_DIAS_NO_MES = 30;
	
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
	
	public double verificarValorMultaBiblioteca(Conta conta){
		double valorDivida = 0.0;
		int diasTotal;
		Period p;
		for(Divida d: conta.getDividas()){
			if (d.estaPago() == false){ // se conta não foi paga
				//verifica a diferença entre as datas
				p = Period.between(d.getDataEmissao(), LocalDate.now());
				//transforma a diferença entre as datas apenas para dias 
				diasTotal = p.getYears() * QUANTIDADE_DIAS_NO_ANO
				+ p.getMonths() * QUANTIDADE_DIAS_NO_MES + p.getDays();
				d.setValor(diasTotal * Servico.getPrecos().get("multaDiáriaBiblioteca"));
				//põe o valor da dívida atualizado
				valorDivida = valorDivida + d.getValor();
			}
		}
		return valorDivida;
	}

}



	