package dados;

import java.util.ArrayList;
import java.util.List;

import classes_basicas.Conta;
import classes_basicas.Movimentacao;
import classes_basicas.Usuario;

public interface IRepositorioConta {
	public void cadastrarConta(Conta conta) throws ContaJaCadastradaException;
	public void removerConta(Conta conta) throws ContaNaoEncontradaException;
	public void alterarDadosConta(Conta conta) throws ContaNaoEncontradaException;
	public Conta exibirConta(Usuario usuario) throws ContaNaoEncontradaException;	
	public Double consultarSaldo(Conta conta) throws ContaNaoEncontradaException;	
	public List<Movimentacao> verMovimentacoes(Conta conta) throws ContaNaoEncontradaException;		
	public ArrayList<Conta> listarContas();

}
