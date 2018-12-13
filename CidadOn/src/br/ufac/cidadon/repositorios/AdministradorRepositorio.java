package br.ufac.cidadon.repositorios;

import java.util.*;
import javax.persistence.*;
import br.ufac.cidadon.entidades.*;

public class AdministradorRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;	
	
	public AdministradorRepositorio() {
		emf = Persistence.createEntityManagerFactory("AcademicoJPA");
		em = emf.createEntityManager();
	}
	public void adicionar(Administrador administrador) {
		em.getTransaction().begin();
		em.persist(administrador);
		em.getTransaction().commit();
	}
	public Administrador recuperar(long id) {
		return em.find(Administrador.class, id);
	}
	public void atualizar (Administrador administrador) {
		em.getTransaction().begin();
		em.merge(administrador);
		em.getTransaction().commit();
	}
	public void remover(Administrador administrador) {
		em.getTransaction().begin();
		em.remove(administrador);
		em.getTransaction().commit();
	}
	public List<Administrador> recuperarPorEmail(String email) {
		Query query = em.createNamedQuery("Administrador.porEmail").setParameter("termo", email);
		return query.getResultList();
	}
	public List<Administrador> recuperarPorNomeAdministrador(String nomeAdministrador) {
		Query query = em.createNamedQuery("Administrador.porNomeAdministrador").setParameter("termo", nomeAdministrador);
		return query.getResultList();
	}
	public List<Administrador> recuperarTodos(){
		Query query = em.createNamedQuery("Administrador.todos");
		return query.getResultList();
	}
	public void encerrar() {
		em.close();
		emf.close();
	}
}
