/**
 * 
 */
package classes_basicas;

import java.time.LocalDate;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class ADMGeral extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idADMGeral;

	/**
	 * @param nome
	 * @param sexo
	 * @param cpf
	 * @param identidade
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param dataNascimento
	 * @param idADMGeral
	 */
	public ADMGeral(String nome, char sexo, String cpf, String identidade, String endereco,
			String telefone, String email, LocalDate dataNascimento, String idADMGeral) {
		super(nome, sexo, cpf, identidade, endereco, telefone, email, dataNascimento);
		setIdADMGeral(idADMGeral);
	}

	public String getIdADMGeral() {
		return idADMGeral;
	}

	public void setIdADMGeral(String idADMGeral) {
		this.idADMGeral = idADMGeral;
	}
	
	@Override
	public int compareTo(Usuario admGeral){
		return this.getCpf().compareTo(admGeral.getCpf());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((idADMGeral == null) ? 0 : idADMGeral.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ADMGeral other = (ADMGeral) obj;
		if (idADMGeral == null) {
			if (other.idADMGeral != null) {
				return false;
			}
		} else if (!idADMGeral.equals(other.idADMGeral)) {
			return false;
		}
		return true;
	}
	
	
	
}
