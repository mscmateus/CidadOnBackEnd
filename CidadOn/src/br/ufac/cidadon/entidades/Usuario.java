package br.ufac.cidadon.entidades;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="usuarios") // nomeia as tabelas do banco
@NamedQueries({
	@NamedQuery(name="Usuario.todos", query = "SELECT u FROM Usuario u"),//querie nomeada para buscar todos cursos})
	@NamedQuery(name="Usuario.todosPorNome", query = "SELECT u FROM Usuario u ORDER BY u.nome"),
	@NamedQuery(name="Usuario.usrCpf", query="SELECT u FROM Usuario u WHERE u.cpf = :valorCpf"),
	@NamedQuery(name="Usuario.nomeContendo", query="SELECT u FROM Usuario u WHERE u.nome LIKE :termo ORDER BY u.nome"),
	@NamedQuery(name="Usuario.porEmail", query="SELECT u FROM Usuario u WHERE u.email = :termo"),
	@NamedQuery(name="Usuario.porNomeUsuario", query="SELECT u FROM Usuario u WHERE u.nomeUsuario = :termo")
})
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long identificador;
	private String cpf;
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private String sobrenome;
	private String nomeUsuario;
	private String senha;
	private double latitudeResidencia;
	private double longitudeResidencia;
	private String email;

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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
	public double getLatitudeResidencia() {
		return latitudeResidencia;
	}
	public void setLatitudeResidencia(double latitudeResidencia) {
		this.latitudeResidencia = latitudeResidencia;
	}
	public double getLongitudeResidencia() {
		return longitudeResidencia;
	}
	public void setLongitudeResidencia(double longitudeResidencia) {
		this.longitudeResidencia = longitudeResidencia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}