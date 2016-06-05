/**
 * 
 */
package classes_basicas;

import java.time.LocalDate;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class Professor extends Usuario{
	private String departamento;
	private String nProfessor;
	/**
	 * @param nome
	 * @param sexo
	 * @param cpf
	 * @param identidade
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param dataNascimento
	 * @param departamento
	 * @param nProfessor
	 */
	public Professor(String nome, char sexo, String cpf, String identidade, String endereco,
			String telefone, String email, LocalDate dataNascimento, String departamento, 
			String nProfessor) {
		super(nome, sexo, cpf, identidade, endereco, telefone, email, dataNascimento);
		setDepartamento(departamento);
		setnProfessor(nProfessor);
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getnProfessor() {
		return nProfessor;
	}
	public void setnProfessor(String nProfessor) {
		this.nProfessor = nProfessor;
	}
	
	@Override
	public int compareTo(Usuario professor){
		return this.getCpf().compareTo(professor.getCpf());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + ((nProfessor == null) ? 0 : nProfessor.hashCode());
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
		Professor other = (Professor) obj;
		if (departamento == null) {
			if (other.departamento != null) {
				return false;
			}
		} else if (!departamento.equals(other.departamento)) {
			return false;
		}
		if (nProfessor == null) {
			if (other.nProfessor != null) {
				return false;
			}
		} else if (!nProfessor.equals(other.nProfessor)) {
			return false;
		}
		return true;
	}
	
	
}
