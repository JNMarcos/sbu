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
import excecao.DividaExisteException;
import excecao.DividaNaoEncontradaException;
import excecao.SaldoInsuficenteException;
import excecao.SenhaIncorretaException;
import excecao.UsuarioNaoEncontradoException;
import excecao.ValorInseridoNaoCondizException;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public interface IFachada {
	
	//serviço
	void pagarDivida(Conta conta, Divida divida) throws ContaNaoEncontradaException,
	DividaNaoEncontradaException, SaldoInsuficenteException;
	void comprarFichaRU(Conta conta) throws SaldoInsuficenteException;
	void solicitarDocumento(Conta conta) throws ContaNaoEncontradaException;
	void solicitarCarteiraEstudante(Conta conta) throws ContaNaoEncontradaException;
	void solicitarCarteira(Conta conta) throws ContaNaoEncontradaException;
	
	//Conta
	void cadastrarConta(Conta conta) throws ContaJaCadastradaException, 
	IllegalArgumentException;
	void removerConta(Conta conta) throws ContaNaoEncontradaException;
	void alterarDadosConta(Conta conta) throws ContaNaoEncontradaException;
	Conta exibirConta(Usuario usuario) throws ContaNaoEncontradaException;
	void consultarSaldo(Conta conta) throws ContaNaoEncontradaException;
	void inserirCreditos(int valor, Conta conta) throws ContaNaoEncontradaException,
	ValorInseridoNaoCondizException;
	void verMovimentacoes(Conta conta) throws ContaNaoEncontradaException;
	Conta verificarLogin(String nome, String senha) throws ContaNaoEncontradaException,
	SenhaIncorretaException;
	
	//Usuario
	void cadastrarUsuario(Usuario usuario) throws CpfJaExistenteException, 
	ContaJaCadastradaException;
	void removerUsuario(Usuario usuario) throws UsuarioNaoEncontradoException;
	void alterarDadosUsuario(Usuario usuario) throws UsuarioNaoEncontradoException;
	Usuario procurarPorCpf(String cpf) throws CpfJaExistenteException;
	
	//ADMBiblioteca
	int pesquisar(ArrayList<Divida> repositorioLocal, Divida divida);
	void adicionarDivida(Divida divida) throws DividaExisteException;
	void alterarDadosDivida(Divida divida) throws DividaNaoEncontradaException;
	void removerDivida(Divida divida) throws DividaNaoEncontradaException;
}
