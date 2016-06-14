/**
 * 
 */
package classes_basicas;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author JN
 *
 */
public class Movimentacao implements Comparable<Movimentacao>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeServico;
	private String descricao;
	private LocalDateTime dataHora;
	
	public Movimentacao(String nomeServico, String descricao){
		setNomeServico(nomeServico);
		setDescricao(descricao);
		setDataHora();
	}
	
	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora() {
		this.dataHora = LocalDateTime.now();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((nomeServico == null) ? 0 : nomeServico.hashCode());
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
		if (!(obj instanceof Movimentacao)) {
			return false;
		}
		Movimentacao other = (Movimentacao) obj;
		if (dataHora == null) {
			if (other.dataHora != null) {
				return false;
			}
		} else if (!dataHora.equals(other.dataHora)) {
			return false;
		}
		if (nomeServico == null) {
			if (other.nomeServico != null) {
				return false;
			}
		} else if (!nomeServico.equals(other.nomeServico)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Movimentacao movimentacao) {
		return this.getNomeServico().compareTo(movimentacao.getNomeServico()) + 
				this.getDataHora().compareTo(movimentacao.getDataHora());
	}
}
