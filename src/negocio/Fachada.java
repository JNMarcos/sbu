/**
 * 
 */
package negocio;

import classes_basicas.Conta;
import classes_basicas.Divida;
import classes_basicas.Usuario;
import excecao.ContaJaCadastradaException;
import excecao.ContaNaoEncontradaException;
import excecao.DividaNaoEncontradaException;
import excecao.SaldoInsuficenteException;
import excecao.SenhaIncorretaException;
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
	public void comprarFichaRU(Conta conta) throws SaldoInsuficenteException{
		ctrServico.comprarFichaRU(conta);
	}
	
	@Override
	public void solicitarDocumento(Conta conta) throws ContaNaoEncontradaException{
		ctrServico.solicitarDocumento(conta);
	}
	
	@Override
	public void solicitarCarteiraEstudante(Conta conta) throws ContaNaoEncontradaException{
		ctrServico.solicitarCarteiraEstudante(conta);
	}
	
	@Override
	public void solicitarCarteira(Conta conta) throws ContaNaoEncontradaException{
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
		ctrConta.inserirCreditos(valor, conta);
	}
	
	@Override
	public void verMovimentacoes(Conta conta) throws ContaNaoEncontradaException{
		ctrConta.verMovimentacoes(conta);
	}
	
	@Override
	public Conta verificarLogin(String nome, String senha) throws ContaNaoEncontradaException,
	SenhaIncorretaException{
		Conta c = ctrConta.verificarLogin(nome, senha);
		if senha.equals(c.getSenha()){
			return c;
		}
		else{
			throw new SenhaIncorretaException("Senha incorreta login:" +nome);
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
}
