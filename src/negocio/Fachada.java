/**
 * 
 */
package negocio;

import java.util.ArrayList;

import classes_basicas.Conta;
import classes_basicas.Divida;
import classes_basicas.Usuario;
import excecao.ContaJaCadastradaException;
import excecao.ContaNaoEncontradaException;
import excecao.CpfJaExistenteException;
import excecao.DividaJaExistenteException;
import excecao.DividaNaoEncontradaException;
import excecao.SaldoInsuficenteException;
import excecao.SenhaIncorretaException;
import excecao.UsuarioNaoEncontradoException;
import excecao.ValorInseridoNaoCondizException;
import negocio.ControladorUsuario;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class Fachada implements IFachada{
	private static Fachada instance;
	private ControladorServico ctrServico;
	private ControladorConta ctrConta;
	private ControladorUsuario ctrUsuario;
	private ControladorADMBiblioteca ctrADMBiblioteca;
	
	private Fachada(){
		ctrServico = new ControladorServico();
		ctrConta = new ControladorConta();
		ctrUsuario = new ControladorUsuario();
		ctrADMBiblioteca = new ControladorADMBiblioteca();
	}
	
	public static Fachada getInstance() {
    	if (instance == null) {
			instance = new Fachada();
		}
    	return instance;
    }

	//serviço
	
	@Override
	public void pagarDivida(Conta conta, Divida divida) throws ContaNaoEncontradaException,
	DividaNaoEncontradaException, SaldoInsuficenteException{
		ctrServico.pagarDivida(conta,divida);
	}
	
	@Override
	public void comprarFichaRU(Conta conta, boolean isAlmoco) throws SaldoInsuficenteException{
		ctrServico.comprarFichaRU(conta, isAlmoco);
	}
	
	@Override
	public void solicitarDocumento(Conta conta, boolean[] isSolicitar) throws ContaNaoEncontradaException,
	SaldoInsuficenteException{
		ctrServico.solicitarDocumento(conta, isSolicitar);
	}
	
	@Override
	public void solicitarCarteira(Conta conta) throws ContaNaoEncontradaException, SaldoInsuficenteException{
		ctrServico.solicitarCarteira(conta);
	}
	

	//Conta
	@Override
	public void cadastrarConta(Conta conta) throws ContaJaCadastradaException, 
	IllegalArgumentException{
		ctrConta.cadastrarConta(conta);
	}
	
	@Override
	public void removerConta(Conta conta) throws ContaNaoEncontradaException{
		ctrConta.removerConta(conta);
	}
	
	@Override
	public void alterarDadosConta(Conta conta) throws ContaNaoEncontradaException{
		ctrConta.alterarDadosConta(conta);
	}
	
	@Override
	public Conta exibirConta(Usuario usuario) throws ContaNaoEncontradaException{
		Conta c = ctrConta.exibirConta(usuario);
		return c;
	}
	
	@Override
	public void consultarSaldo(Conta conta) throws ContaNaoEncontradaException {
		ctrConta.consultarSaldo(conta);
	}
	
	@Override
	public void inserirCreditos(int valor, Conta conta) throws ContaNaoEncontradaException,
	ValorInseridoNaoCondizException{
		ctrConta.inserirCreditos(valor, conta); //falta implementar
	}
	
	@Override
	public void verMovimentacoes(Conta conta) throws ContaNaoEncontradaException{
		ctrConta.verMovimentacoes(conta);
	}
	
	@Override
	public Conta verificarLogin(String nome, String senha) throws ContaNaoEncontradaException,
	SenhaIncorretaException{
		Conta c = ctrConta.verificarLogin(nome, senha);
		
		//não entendi a necessidade
		if (senha.equals(c.getSenha())){
			return c;
		}
		else{
			throw new SenhaIncorretaException("Senha incorreta login:" +nome); //errado
		}
	}
	
	//Usuario
	@Override
	public void cadastrarUsuario(Usuario usuario) throws CpfJaExistenteException, 
	ContaJaCadastradaException{
		ctrUsuario.cadastrarUsuario(usuario);
	}
	
	@Override
	public void removerUsuario(Usuario usuario) throws UsuarioNaoEncontradoException{
		ctrUsuario.removerUsuario(usuario);
	}
	
	@Override
	public void alterarDadosUsuario(Usuario usuario) throws UsuarioNaoEncontradoException{
		ctrUsuario.alterarDadosUsuario(usuario);
	}
	
	@Override
	public Usuario procurarPorCpf(String cpf) throws CpfJaExistenteException{
		return ctrUsuario.procurarPorCpf(cpf);
	}
	
	//ADMBiblioteca
	
	@Override
	//verificar método
	public int pesquisar(ArrayList<Divida> repositorioLocal, Divida divida){
		return ctrADMBiblioteca.pesquisar(repositorioLocal, divida);
	}
	
	@Override
	public void adicionarDivida(Divida divida) throws DividaJaExistenteException{
		ctrADMBiblioteca.adicionarDivida(divida);
	}
	
	@Override
	public void alterarDadosDivida(Divida divida) throws DividaNaoEncontradaException{
		ctrADMBiblioteca.alterarDadosDivida(divida);
	}
		
	@Override
	public void removerDivida(Divida divida) throws DividaNaoEncontradaException{
		ctrADMBiblioteca.removerDivida(divida);
	}

	@Override
	public void verificarValorMultaBiblioteca(Conta conta) throws ContaNaoEncontradaException {
		ctrConta.verificarValorMultaBiblioteca(conta);
		
	}
}
