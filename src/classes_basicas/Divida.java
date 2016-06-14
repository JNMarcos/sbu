/**
 * 
 */
package classes_basicas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author JN
 *
 */
public class Divida implements Comparable<Divida>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Conta conta;
	private double valor;
	private String descricao;
	private boolean estaPago; //se dívida está paga ou não
	private LocalDate dataEmissao;
	private LocalTime horaEmissao;
	
	public Divida (Conta conta, double valor, String descricao){
		setConta(conta);
		setValor(valor);
		setDescricao(descricao);
		setEstaPago(false);
		setDataEmissao();
		setHoraEmissao();
	}
	
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean estaPago() {
		return estaPago;
	}
	public void setEstaPago(boolean estaPago) {
		this.estaPago = estaPago;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao() {
		this.dataEmissao = LocalDate.now();
	}

	public LocalTime getHoraEmissao() {
		return horaEmissao;
	}

	public void setHoraEmissao() {
		LocalDateTime dt = LocalDateTime.now();
		this.horaEmissao = LocalTime.of(dt.getHour(), dt.getMinute());
	}

	@Override
	public int compareTo(Divida divida) {
		return this.getConta().compareTo(divida.getConta()) +
				this.getDataEmissao().compareTo(divida.getDataEmissao()) +
				this.getHoraEmissao().compareTo(divida.getHoraEmissao());
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((dataEmissao == null) ? 0 : dataEmissao.hashCode());
		result = prime * result + ((horaEmissao == null) ? 0 : horaEmissao.hashCode());
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
		if (!(obj instanceof Divida)) {
			return false;
		}
		Divida other = (Divida) obj;
		if (conta == null) {
			if (other.conta != null) {
				return false;
			}
		} else if (!conta.equals(other.conta)) {
			return false;
		}
		if (dataEmissao == null) {
			if (other.dataEmissao != null) {
				return false;
			}
		} else if (!dataEmissao.equals(other.dataEmissao)) {
			return false;
		}
		if (horaEmissao == null) {
			if (other.horaEmissao != null) {
				return false;
			}
		} else if (!horaEmissao.equals(other.horaEmissao)) {
			return false;
		}
		return true;
	}
	
	
}
