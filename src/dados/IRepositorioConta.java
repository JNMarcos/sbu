package dados;

import classes_basicas.Conta;
import classes_basicas.Usuario;

public interface IRepositorioConta {
	public boolean cadastrarConta(Conta conta) throws ContaJaCadastradaException;
	public boolean removerConta(Conta conta) throws ContaNaoEncontradaException;
	public boolean alterarDadosConta(Conta conta) throws ContaNaoEncontradaException;
	public Conta exibirConta(Usuario usuario) throws ContaNaoEncontradaException;	
	public void consultarSaldo(Conta conta) throws ContaNaoEncontradaException;	
	public void verMovimentacoes(Conta conta) throws ContaNaoEncontradaException;		
	public void listarContas();

}
