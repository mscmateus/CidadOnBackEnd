package br.ufac.cidadon.entidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.persistence.*;
import javax.swing.JDialog;
import javax.swing.JLabel;
@Entity
@Table(name="tiposDeProblemas")
@NamedQueries({
	@NamedQuery(name="TipoDeProblema.todos", query = "SELECT t FROM TipoDeProblema t"),//querie nomeada para buscar todos cursos})
	@NamedQuery(name="TipoDeProblema.todosPorTitulo", query = "SELECT t FROM TipoDeProblema t ORDER BY t.titulo"),
	@NamedQuery(name="TipoDeProblema.porMesesVisibilidade", query="SELECT t FROM TipoDeProblema t ORDER BY t.mesesVisibilidade "),
	@NamedQuery(name="TipoDeProblema.tituloContendo", query="SELECT t FROM TipoDeProblema t WHERE t.titulo LIKE :termo ORDER BY t.titulo")
})
public class TipoDeProblema {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int indentificador;
	private String titulo;
	private String descricao;
	private int mesesVisibilidade;
	@Lob
	private byte[] icone;
	
	public int getIndentificador() {
		return indentificador;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getMesesVisibilidade() {
		return mesesVisibilidade;
	}
	public void setMesesVisibilidade(int mesesVisibilidade) {
		this.mesesVisibilidade = mesesVisibilidade;
	}
	public byte[] getIcone() {
		return icone;
	}
	public void setIcone(byte[] icone) {
		this.icone = icone;
	}
	public void setIconeFile(File file ) throws IOException{
		System.out.println(file.isFile());
		JDialog jd = new JDialog();
		icone = new byte [(int) file.length()];
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(icone);
		fos.close();
	}
}