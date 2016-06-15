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
import excecao.FichasInsuficientesException;
import excecao.SaldoInsuficienteException;
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

	//servi�o

	@Override
	public void pagarDivida(Conta conta, Divida divida) throws SaldoInsuficienteException, DividaNaoEncontradaException, ContaNaoEncontradaException{
		ctrServico.pagarDivida(conta,divida);
	}

	@Override
	public void comprarFichaRU(Conta conta, boolean isAlmoco, short quantidadeFichas) throws SaldoInsuficienteException, ContaNaoEncontradaException{
		ctrServico.comprarFichaRU(conta, isAlmoco, quantidadeFichas);
	}

	@Override
	public void solicitarDocumento(Conta conta, boolean[] isSolicitar) throws SaldoInsuficienteException, ContaNaoEncontradaException{
		ctrServico.solicitarDocumento(conta, isSolicitar);
	}

	@Override
	public void solicitarCarteira(Conta conta) throws SaldoInsuficienteException, ContaNaoEncontradaException{
		ctrServico.solicitarCarteira(conta);
	}
	
	@Override
	public void simularRU(Conta conta, boolean isAlmoco)
			throws ContaNaoEncontradaException, FichasInsuficientesException {
		ctrServico.simularRU(conta, isAlmoco);
	}

	//Conta
	@Override
	public void cadastrarConta(Conta conta) throws ContaJaCadastradaException{
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
	ValorInseridoNaoCondizException, SaldoInsuficienteException{
		ctrConta.inserirCreditos(valor, conta);
	}

	@Override
	public void verMovimentacoes(Conta conta) throws ContaNaoEncontradaException{
		ctrConta.verMovimentacoes(conta);
	}

	@Override
	public Conta verificarLogin(String nome, String senha) throws SenhaIncorretaException, 
	UsuarioNaoEncontradoException{
		Conta c = ctrConta.verificarLogin(nome, senha);
		return c;

	}

	//Usuario
	@Override
	public void cadastrarUsuario(Usuario usuario) throws CpfJaExistenteException{
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

	public int pesquisar(ArrayList<Usuario> user, Usuario usuario){
		return ctrUsuario.pesquisar(user, usuario);
	}

	public ArrayList<Usuario> listarUsuarios()
	{

		return ctrUsuario.listarUsuarios();

	}

	//ADMBiblioteca
	@Override
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

	@Override
	public boolean procurarConta(Conta conta) {
		return ctrConta.procurarConta(conta);
	}

	@Override
	public Conta procurarConta(String CPF) {
		return ctrConta.procurarConta(CPF);
	}

	@Override
	public int retornarIndice(Conta conta) {
		return ctrConta.retornarIndice(conta);
	}
}
