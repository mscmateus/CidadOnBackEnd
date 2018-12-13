package br.ufac.cidadon.entidades;


import javax.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="problemas")
@NamedQueries({
	@NamedQuery(name="Problema.todos", query = "SELECT p FROM Problema p"),
	@NamedQuery(name="Problema.porPeriodoCriacao", query="SELECT p FROM Problema p WHERE p.dataCriacao BETWEEN :min AND :max ORDER BY p.dataCriacao"),
	@NamedQuery(name="Problema.porDataCriacao", query="SELECT p FROM Problema p WHERE p.dataCriacao = :dataCriacao ORDER BY p.dataCriacao"),
	@NamedQuery(name="Problema.todosResolvidos", query="SELECT p FROM Problema p WHERE p.resolvido = true ORDER BY p.dataCriacao"),
	@NamedQuery(name="Problema.todosNaoResolvidos", query="SELECT p FROM Problema p WHERE p.resolvido = false ORDER BY p.dataCriacao"),
	@NamedQuery(name="Problema.porTipoDeProblema", query="SELECT p FROM Problema p WHERE p.tipoDeProblema.indentificador = :termo"),
	@NamedQuery(name="Problema.porTipoDeProblemaEId", query="SELECT p FROM Problema p WHERE p.tipoDeProblema.indentificador = :termo AND p.identificador = :codigo"),
	@NamedQuery(name="Problema.porUsuarioId", query="SELECT p FROM Problema p WHERE p.usuario.identificador = :codigo")

})
public class Problema {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long identificador;
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	private double latitude;
	private double longitude;
	private boolean resolvido;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="usuario_fk")
	private Usuario usuario;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="tipo_problema_fk")
	private TipoDeProblema tipoDeProblema;
	public long getIdentificador() {
		return identificador;
	}
	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public boolean isResolvido() {
		return resolvido;
	}
	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public TipoDeProblema getTipoDeProblema() {
		return tipoDeProblema;
	}
	public void setTipoDeProblema(TipoDeProblema tipoDeProblema) {
		this.tipoDeProblema = tipoDeProblema;
	}

}