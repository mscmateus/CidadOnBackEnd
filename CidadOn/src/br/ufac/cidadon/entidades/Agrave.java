package br.ufac.cidadon.entidades;

import javax.persistence.*;
//deu certo Essa merda?
//sim
//mudei i target
@Entity
@Table(name="agraves")
@NamedQueries({
	@NamedQuery(name="Agrave.todos", query = "SELECT a FROM Agrave a"),
	@NamedQuery(name="Agrave.porUsuario", query = "SELECT a FROM Agrave a WHERE a.usuario.identificador = :usercodigo"),
	@NamedQuery(name="Agrave.porProblema", query = "SELECT a FROM Agrave a WHERE a.problema.identificador = :problemacodigo"),
	@NamedQuery(name="Agrave.porUsuarioEProblema", query = "SELECT a FROM Agrave a WHERE a.usuario.identificador = :usercodigo AND a.problema.identificador = :problemacodigo "),
	@NamedQuery(name="Agrave.porNotUsuarioEProblema", query = "SELECT a FROM Agrave a WHERE a.usuario.identificador != :usercodigo AND a.problema.identificador = :problemacodigo "),
})
public class Agrave {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long identificador;
	private String comentario;
	private int gravidade;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="usuario_fk")
	private Usuario usuario;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="problema_fk")
	private Problema problema;
	
	public long getIdentificador() {
		return identificador;
	}
	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getGravidade() {
		return gravidade;
	}
	public void setGravidade(int gravidade) {
		this.gravidade = gravidade;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Problema getProblema() {
		return problema;
	}
	public void setProblema(Problema problema) {
		this.problema = problema;
	}

}