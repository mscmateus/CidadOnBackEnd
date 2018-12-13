package br.ufac.cidadon.entidades;

import javax.persistence.*;
@Entity
@Table(name="administrador") // nomeia as tabelas do banco
@NamedQueries({
	@NamedQuery(name="Administrador.todos", query = "SELECT u FROM Administrador u"),//querie nomeada para buscar todos cursos})
	@NamedQuery(name="Administrador.porEmail", query="SELECT u FROM Administrador u WHERE u.email = :termo"),
	@NamedQuery(name="Administrador.porNomeAdministrador", query="SELECT u FROM Administrador u WHERE u.nomeAdministrador = :termo")
})
public class Administrador {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long identificador;
	private String nome;
	private String sobrenome;
	private String nomeAdministrador;
	private String senha;
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getNomeAdministrador() {
		return nomeAdministrador;
	}
	public void setNomeAdministrador(String nomeAdministrador) {
		this.nomeAdministrador = nomeAdministrador;
	}
	public long getIdentificador() {
		return identificador;
	}
	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}