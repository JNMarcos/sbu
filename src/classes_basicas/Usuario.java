package classes_basicas;

import java.io.Serializable;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public abstract class Usuario implements Comparable<Usuario>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private char sexo;
	private String cpf;
	private String identidade;
	private String endereco;
	private String telefone;
	private String email;
	private String dataNascimento;
	
	/**
	 * @param nome
	 * @param sexo
	 * @param cpf
	 * @param identidade
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param dataNascimento
	 */
	public Usuario(String nome, char sexo, String cpf, String identidade, String endereco,
			String telefone,
			String email, String dataNascimento) {
		setNome(nome);
		setSexo(sexo);
		setCpf(cpf);
		setIdentidade(identidade);
		setEndereco(endereco);
		setTelefone(telefone);
		setEmail(email);
		setDataNascimento(dataNascimento);
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getIdentidade() {
		return identidade;
	}
	
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public int compareTo(Usuario usuario){
		return this.getNome().compareTo(usuario.getNome());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((identidade == null) ? 0 : identidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}	
		if (obj == null){
			return false;
		}	
		if (getClass() != obj.getClass()){
			return false;
		}	
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf)){
			return false;
	    }
		if (identidade == null) {
			if (other.identidade != null)
				return false;
		} else if (!identidade.equals(other.identidade)){
			return false;
		}	
		if (nome == null) {
			if (other.nome != null){
				return false;
			}	
		} else if (!nome.equals(other.nome)){
			return false;
		}	
		return true;
	}
		
}
