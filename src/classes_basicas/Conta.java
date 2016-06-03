/**
 * 
 */
package classes_basicas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author JN
 *
 */
public class Conta implements Comparable<Conta>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private String login;
	private String senha;
	private double saldo;
	private List<Movimentacao> historico;
	private List<Divida> dividas;
	
	// indica se um serviço pode ser usado pela usuário da conta ou não
	private Hashtable<String, Boolean> permissoesServico;
	private int[] nPorcoes;
	
	public Conta (Usuario usuario, String login, String senha){
		setUsuario(usuario);
		//login e senha são criados aleatoriamente, depois o usuário pode mudar
		// pelo sistema
		setLogin(login); 
		setSenha(senha);
		setSaldo(0.0); //saldo da conta inicia em zero
		setHistorico();
		setDividas();
		setPermissoesServico();
		setnPorcoes();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public List<Movimentacao> getHistorico() {
		return historico;
	}
	public void setHistorico() {
		this.historico = new ArrayList<Movimentacao>();
	}
	public List<Divida> getDividas() {
		return dividas;
	}

	public void setDividas() {
		this.dividas = new ArrayList<Divida>();
	}

	public Hashtable<String, Boolean> getPermissoesServico() {
		return permissoesServico;
	}
	public void setPermissoesServico() {
		this.permissoesServico = new Hashtable<String, Boolean>();
		// considera-se que todos os usuários começam com permissão de uso de
		// todos os serviços
		this.permissoesServico.put("RU", true);
		this.permissoesServico.put("Biblioteca", true);
	}
	public int[] getnPorcoes() {
		return nPorcoes;
	}
	public void setnPorcoes() {
		this.nPorcoes = new int[2];
		nPorcoes[0] = 0; // n° de porções almoço
		nPorcoes[1] = 0; // nº de porções jantar
	}

	@Override
	public int compareTo(Conta conta) {
		return this.getUsuario().compareTo(conta.getUsuario());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dividas == null) ? 0 : dividas.hashCode());
		result = prime * result + ((historico == null) ? 0 : historico.hashCode());
		result = prime * result + ((permissoesServico == null) ? 0 : permissoesServico.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Conta)) {
			return false;
		}
		Conta other = (Conta) obj;
		if (dividas == null) {
			if (other.dividas != null) {
				return false;
			}
		} else if (!dividas.equals(other.dividas)) {
			return false;
		}
		if (historico == null) {
			if (other.historico != null) {
				return false;
			}
		} else if (!historico.equals(other.historico)) {
			return false;
		}
		if (permissoesServico == null) {
			if (other.permissoesServico != null) {
				return false;
			}
		} else if (!permissoesServico.equals(other.permissoesServico)) {
			return false;
		}
		if (usuario == null) {
			if (other.usuario != null) {
				return false;
			}
		} else if (!usuario.equals(other.usuario)) {
			return false;
		}
		return true;
	}		
}
