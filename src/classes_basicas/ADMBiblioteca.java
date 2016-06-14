/**
 * 
 */
package classes_basicas;

import java.time.LocalDate;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public class ADMBiblioteca extends Tecnico{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public ADMBiblioteca(String nome, char sexo, String cpf, String identidade, String endereco, String telefone,
			String email, LocalDate dataNascimento, String area, String departamento, String nTecnico) {
		super(nome, sexo, cpf, identidade, endereco, telefone, email, dataNascimento, area, departamento, nTecnico);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compareTo(Usuario admBiblioteca){
		return this.getCpf().compareTo(admBiblioteca.getCpf());
	}

	
}
