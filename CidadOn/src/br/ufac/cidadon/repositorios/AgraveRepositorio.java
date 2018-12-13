package br.ufac.cidadon.repositorios;

import java.util.*;
import javax.persistence.*;
import br.ufac.cidadon.entidades.*;

public class AgraveRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;	
	
	public AgraveRepositorio() {
		emf = Persistence.createEntityManagerFactory("AcademicoJPA");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Agrave agrave) {
		em.getTransaction().begin();
		em.persist(agrave);
		em.getTransaction().commit();
	}
	public Agrave recuperar(long id) {
		return em.find(Agrave.class, id);
	}
	public void atualizar (Agrave agrave) {
		em.getTransaction().begin();
		em.merge(agrave);
		em.getTransaction().commit();
	}
	public void remover(Agrave agrave) {
		em.getTransaction().begin();
		em.remove(agrave);
		em.getTransaction().commit();
	}
	public List<Agrave> recuperarTodos(){
		Query query = em.createNamedQuery("Agrave.todos");
		return query.getResultList();
	}
	public List<Agrave> recuperarTodosPorUsuarioeProblema(long userCodigo, long problemaCodigo){
		Query query = em.createNamedQuery("Agrave.porUsuarioEProblema");
		query.setParameter("usercodigo", userCodigo);
		query.setParameter("problemacodigo", problemaCodigo);
		return query.getResultList();
	}
	public List<Agrave> recuperarTodosPorNotUsuarioeProblema(long userCodigo, long problemaCodigo){
		Query query = em.createNamedQuery("Agrave.porNotUsuarioEProblema");
		query.setParameter("usercodigo", userCodigo);
		query.setParameter("problemacodigo", problemaCodigo);
		return query.getResultList();
	}
	public List<Agrave> recuperarTodosPorUsuario(long userCodigo){
		Query query = em.createNamedQuery("Agrave.porUsuario");
		query.setParameter("usercodigo", userCodigo);
		return query.getResultList();
	}
	public List<Agrave> recuperarTodosPorProblema(long problemaCodigo){
		Query query = em.createNamedQuery("Agrave.porProblema");
		query.setParameter("problemacodigo", problemaCodigo);
		return query.getResultList();
	}
	public void encerrar() {
		em.close();
		emf.close();
	}
}
