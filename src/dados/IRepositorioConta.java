package dados;

import java.util.ArrayList;

import classes_basicas.Conta;
import classes_basicas.Usuario;

public interface IRepositorioConta {
	public void cadastrarConta(Conta conta);
	public void removerConta(Conta conta);
	public void alterarDadosConta(Conta conta) ;
	public Conta exibirConta(Usuario usuario);	
	public void consultarSaldo(Conta conta);	
	public void verMovimentacoes(Conta conta);		
	public ArrayList<Conta> listarContas();
	public boolean procurarConta (Conta conta);
	public Conta procurarConta(String CPF);
	public int retornarIndice(Conta conta);
	public boolean verificarNomeUsuarioJaExiste(String nomeUsuario);
	public boolean verificarSenhaJaExiste(String senha);
	public Conta verificarLogin(String nome, String senha);
}
