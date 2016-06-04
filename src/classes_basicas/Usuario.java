package classes_basicas;

import java.io.Serializable;

/**
 * @author Marcos Inacio de Paula Lima
 *
 */
public abstract class Usuario implements Serializable {
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
	
	
}
