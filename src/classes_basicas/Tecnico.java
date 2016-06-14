/**
 * 
 */
package classes_basicas;

import java.time.LocalDate;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class Tecnico extends Usuario{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String area;
	private String departamento;
	private String nTecnico;
	/**
	 * @param nome
	 * @param sexo
	 * @param cpf
	 * @param identidade
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param dataNascimento
	 * @param area
	 * @param departamento
	 * @param nTecnico
	 */
	public Tecnico(String nome, char sexo, String cpf, String identidade, String endereco, 
			String telefone, String email, LocalDate dataNascimento, String area, 
			String departamento, String nTecnico) {
		super(nome, sexo, cpf, identidade, endereco, telefone, email, dataNascimento);
		setArea(area);
		setDepartamento(departamento);
		setnTecnico(nTecnico);
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getnTecnico() {
		return nTecnico;
	}
	public void setnTecnico(String nTecnico) {
		this.nTecnico = nTecnico;
	}
	
	@Override
	public int compareTo(Usuario tecnico){
		return this.getCpf().compareTo(tecnico.getCpf());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + ((nTecnico == null) ? 0 : nTecnico.hashCode());
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
		Tecnico other = (Tecnico) obj;
		if (area == null) {
			if (other.area != null) {
				return false;
			}
		} else if (!area.equals(other.area)) {
			return false;
		}
		if (departamento == null) {
			if (other.departamento != null) {
				return false;
			}
		} else if (!departamento.equals(other.departamento)) {
			return false;
		}
		if (nTecnico == null) {
			if (other.nTecnico != null) {
				return false;
			}
		} else if (!nTecnico.equals(other.nTecnico)) {
			return false;
		}
		return true;
	}
	
}
