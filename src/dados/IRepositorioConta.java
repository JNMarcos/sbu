package dados;

import classes_basicas.Conta;
import classes_basicas.Usuario;

public interface IRepositorioConta {
	public boolean cadastrarConta(Conta conta);
	public boolean removerConta(Conta conta);
	public boolean alterarDadosConta(Conta conta);
	public Conta exibirConta(Usuario usuario);	
	public void consultarSaldo(Conta conta);	
	public void verMovimentacoes(Conta conta);		
	public void listarContas();

}
