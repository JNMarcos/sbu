package dados;

import java.util.ArrayList;
import java.util.List;

import classes_basicas.Conta;
import classes_basicas.Movimentacao;
import classes_basicas.Usuario;

public interface IRepositorioConta {
	public void cadastrarConta(Conta conta);
	public void removerConta(Conta conta);
	public void alterarDadosConta(Conta conta) ;
	public Conta exibirConta(Usuario usuario);	
	public void consultarSaldo(Conta conta);	
	public void verMovimentacoes(Conta conta);		
	public ArrayList<Conta> listarContas();

}
