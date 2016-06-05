/**
 * 
 */
package classes_basicas;

import java.time.LocalDate;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class ADMBiblioteca extends Usuario{
	private String idADMBiblioteca;

	/**
	 * @param nome
	 * @param sexo
	 * @param cpf
	 * @param identidade
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param dataNascimento
	 * @param idADMBiblioteca
	 */
	public ADMBiblioteca(String nome, char sexo, String cpf, String identidade, String endereco,
			String telefone, String email, LocalDate dataNascimento, String idADMBiblioteca) {
		super(nome, sexo, cpf, identidade, endereco, telefone, email, dataNascimento);
		setIdADMBiblioteca(idADMBiblioteca);
	}

	public String getIdADMBiblioteca() {
		return idADMBiblioteca;
	}

	public void setIdADMBiblioteca(String idADMBiblioteca) {
		this.idADMBiblioteca = idADMBiblioteca;
	}
	
	@Override
	public int compareTo(Usuario admBiblioteca){
		return this.getCpf().compareTo(admBiblioteca.getCpf());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((idADMBiblioteca == null) ? 0 : idADMBiblioteca.hashCode());
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
		ADMBiblioteca other = (ADMBiblioteca) obj;
		if (idADMBiblioteca == null) {
			if (other.idADMBiblioteca != null) {
				return false;
			}
		} else if (!idADMBiblioteca.equals(other.idADMBiblioteca)) {
			return false;
		}
		return true;
	}
	
	
	
}
