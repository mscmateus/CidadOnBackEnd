package br.ufac.cidadon.entidades;



import javax.persistence.*;

@Entity
@Table(name="denuncias") // nomeia as tabelas do banco
@NamedQueries({
	@NamedQuery(name="Denuncia.todos", query = "SELECT d FROM Denuncia d"),
	@NamedQuery(name="Denuncia.porUsuario", query = "SELECT a FROM Denuncia a WHERE a.usuario.identificador = :usercodigo"),
	@NamedQuery(name="Denuncia.porProblema", query = "SELECT a FROM Denuncia a WHERE a.problema.identificador = :problemacodigo"),
	@NamedQuery(name="Denuncia.porUsuarioEProblema", query = "SELECT d FROM Denuncia d WHERE d.usuario.identificador = :usercodigo AND d.problema.identificador = :problemacodigo "),
	@NamedQuery(name="Denuncia.porNotUsuarioEProblema", query = "SELECT d FROM Denuncia d WHERE d.usuario.identificador != :usercodigo AND d.problema.identificador = :problemacodigo "),
})
public class Denuncia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long identificador;
	private String tipo;
    private String descricao;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}