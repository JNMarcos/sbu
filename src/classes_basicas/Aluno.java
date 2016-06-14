package classes_basicas;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */

import java.time.LocalDate;

public class Aluno extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nMatricula;
	private String curso;
	private String periodoAdmissao;
	private int periodoAtual;
	/**
	 * @param nome
	 * @param sexo
	 * @param cpf
	 * @param identidade
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param dataNascimento
	 * @param nMatricula
	 * @param curso
	 * @param periodoAdmissao
	 * @param periodoAtual
	 */
	public Aluno(String nome, char sexo, String cpf, String identidade, String endereco, 
			String telefone, String email, LocalDate dataNascimento, String nMatricula, 
			String curso, String periodoAdmissao, int periodoAtual) {
		super(nome, sexo, cpf, identidade, endereco, telefone, email, dataNascimento);
		setnMatricula(nMatricula);
		setCurso(curso);
		setPeriodoAdmissao(periodoAdmissao);
		setPeriodoAtual(periodoAtual);
	}
	public String getnMatricula() {
		return nMatricula;
	}
	public void setnMatricula(String nMatricula) {
		this.nMatricula = nMatricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getPeriodoAdmissao() {
		return periodoAdmissao;
	}
	public void setPeriodoAdmissao(String periodoAdmissao) {
		this.periodoAdmissao = periodoAdmissao;
	}
	public int getPeriodoAtual() {
		return periodoAtual;
	}
	public void setPeriodoAtual(int periodoAtual) {
		this.periodoAtual = periodoAtual;
	}
	
	@Override
	public int compareTo(Usuario aluno){
		return this.getCpf().compareTo(aluno.getCpf());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nMatricula == null) ? 0 : nMatricula.hashCode());
		result = prime * result + periodoAtual;
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
		Aluno other = (Aluno) obj;
		if (nMatricula == null) {
			if (other.nMatricula != null) {
				return false;
			}
		} else if (!nMatricula.equals(other.nMatricula)) {
			return false;
		}
		if (periodoAtual != other.periodoAtual) {
			return false;
		}
		return true;
	}
	
	
	
}
