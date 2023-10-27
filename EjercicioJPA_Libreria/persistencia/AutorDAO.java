/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import libreria.entidades.Autor;

/**
 *
 * @author Taddeu's
 */
public class AutorDAO {
    
    private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibreriaPU");
    private EntityManager em = EMF.createEntityManager();
  
    public void conectar(){
        if(!em.isOpen()){
            em = EMF.createEntityManager();
        }
    }
    
    public void desconectar(){
        if(em.isOpen()){
            em.close();
        }
    }
    
    public void guardarAutor(Autor autor) throws Exception{
        try {
            conectar();           
            em.getTransaction().begin();           
            em.persist(autor);           
            em.getTransaction().commit();
            desconectar();            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarAutor(Autor autor) throws Exception{
        try {
            conectar();           
            em.getTransaction().begin();           
            em.remove(em.merge(autor));           
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarAutor(Autor autor) throws Exception{
        try {
            conectar();
            em.getTransaction().begin();           
            em.merge(autor);           
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Autor buscarAutorPorId(Integer id) throws Exception{
        try {
            conectar();
            Autor autor = em.find(Autor.class, id);
            desconectar();
        
            return autor;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Collection<Autor> listarAutores(){
        try {
            conectar();
        
            List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        
            desconectar();
        
            return autores;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Autor buscarAutorPorParametro(String parametro, String valorParametro) throws Exception{
        try{
            conectar();
            
            CriteriaBuilder cB = em.getCriteriaBuilder();
            CriteriaQuery<Autor> query = cB.createQuery(Autor.class);
            Root<Autor> root = query.from(Autor.class);
            
            ParameterExpression<String> parExp = cB.parameter(String.class);
            query.select(root).where(cB.equal(root.get(parametro), parExp));
            
            TypedQuery<Autor> typedQuery = em.createQuery(query);
            typedQuery.setParameter(parExp, valorParametro);
            
            Autor autor = typedQuery.getSingleResult();
            
            desconectar();
            
            return autor;
        } catch (Exception e) {
            return null;
        }
    }
}
