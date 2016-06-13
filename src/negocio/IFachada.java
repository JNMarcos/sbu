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
import excecao.SaldoInsuficienteException;
import excecao.SenhaIncorretaException;
import excecao.UsuarioNaoEncontradoException;
import excecao.ValorInseridoNaoCondizException;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public interface IFachada {
	
	//serviços
	void pagarDivida(Conta conta, Divida divida) throws DividaNaoEncontradaException, SaldoInsuficienteException;
	void comprarFichaRU(Conta conta, boolean isAlmoco) throws SaldoInsuficienteException;
	void solicitarDocumento(Conta conta, boolean[] isSolicitado) throws SaldoInsuficienteException;
	void solicitarCarteira(Conta conta) throws SaldoInsuficienteException;
	
	//Conta
	void cadastrarConta(Conta conta) throws ContaJaCadastradaException;
	void removerConta(Conta conta) throws ContaNaoEncontradaException;
	void alterarDadosConta(Conta conta) throws ContaNaoEncontradaException;
	Conta exibirConta(Usuario usuario) throws ContaNaoEncontradaException;
	void consultarSaldo(Conta conta) throws ContaNaoEncontradaException;
	void inserirCreditos(int valor, Conta conta) throws ContaNaoEncontradaException,
	ValorInseridoNaoCondizException;
	void verMovimentacoes(Conta conta) throws ContaNaoEncontradaException;
	Conta verificarLogin(String nome, String senha) throws SenhaIncorretaException, 
	UsuarioNaoEncontradoException;
	void verificarValorMultaBiblioteca(Conta conta) throws ContaNaoEncontradaException;
	
	//Usuario
	void cadastrarUsuario(Usuario usuario) throws CpfJaExistenteException;
	void removerUsuario(Usuario usuario) throws UsuarioNaoEncontradoException;
	void alterarDadosUsuario(Usuario usuario) throws UsuarioNaoEncontradoException;
	Usuario procurarPorCpf(String cpf) throws CpfJaExistenteException;
	int pesquisar(ArrayList<Usuario> user, Usuario usuario);
	ArrayList<Usuario>  listarUsuarios();
	
	//ADMBiblioteca
	int pesquisar(ArrayList<Divida> repositorioLocal, Divida divida);
	void adicionarDivida(Divida divida) throws DividaJaExistenteException;
	void alterarDadosDivida(Divida divida) throws DividaNaoEncontradaException;
	void removerDivida(Divida divida) throws DividaNaoEncontradaException;
}
