/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import libreria.entidades.Libro;

/**
 *
 * @author Taddeu's
 */
public class LibroDAO {
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
    
    public void guardarLibro(Libro libro) throws Exception{
        try {
            conectar();           
            em.getTransaction().begin();           
            em.persist(libro);           
            em.getTransaction().commit();
            desconectar();            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarLibro(Libro libro) throws Exception{
        try {
            conectar();           
            em.getTransaction().begin();           
            em.remove(em.merge(libro));           
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarLibro(Libro libro) throws Exception{
        try {
            conectar();
            em.getTransaction().begin();           
            em.merge(libro);           
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Libro buscarLibroPorISBN(Long isbn) throws Exception{
        try {
            conectar();
            Libro libro = em.find(Libro.class, isbn);
            desconectar();
        
            return libro;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Collection<Libro> listarLibros(){
        try {
            conectar();
        
            List<Libro> libros = em.createQuery("SELECT a FROM Libro a").getResultList();
        
            desconectar();
        
            return libros;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Libro buscarLibroPorParametro(String parametro, String valorParametro) throws Exception{
        try {
            conectar();
            
            CriteriaBuilder cB = em.getCriteriaBuilder();
            CriteriaQuery<Libro> query = cB.createQuery(Libro.class);
            Root<Libro> root = query.from(Libro.class);
                                    
            ParameterExpression<String> parExp = cB.parameter(String.class);         
            query.select(root).where(cB.equal(root.get(parametro), parExp));
            
            TypedQuery<Libro> typedQuery = em.createQuery(query);
            typedQuery.setParameter(parExp, valorParametro);
            
            Libro libro = typedQuery.getSingleResult();
            
            return libro;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    
    public Libro buscarLibroPorObjeto(String tipoObjeto, String parametro, String valorParametro) throws Exception {
        try {
            conectar();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Libro> query = cb.createQuery(Libro.class);
            Root<Libro> root = query.from(Libro.class);

            // Relación con el atributo "autor" en la entidad Libro
            query.select(root).where(cb.equal(root.get(tipoObjeto).get(parametro), valorParametro));

            TypedQuery<Libro> typedQuery = em.createQuery(query);
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
