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
import javax.persistence.criteria.Root;
import libreria.entidades.Prestamo;

/**
 *
 * @author Taddeu's
 */
public class PrestamoDAO {
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
    
    public void guardarPrestamo(Prestamo prestamo) throws Exception{
        try {
            conectar();           
            em.getTransaction().begin();           
            em.persist(prestamo);           
            em.getTransaction().commit();
            desconectar();            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarPrestamo(Prestamo prestamo) throws Exception{
        try {
            conectar();   
            
            em.getTransaction().begin();           
            em.remove(em.merge(prestamo));           
            em.getTransaction().commit();
            
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarPrestamo(Prestamo prestamo) throws Exception{
        try {
            conectar();
            em.getTransaction().begin();           
            em.merge(prestamo);           
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Prestamo buscarPrestamoPorId(Integer id) throws Exception{
        try {
            conectar();
            Prestamo prestamo = em.find(Prestamo.class, id);
            desconectar();
        
            return prestamo;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Collection<Prestamo> listarPrestamos(){
        try {
            conectar();
        
            List<Prestamo> prestamos = em.createQuery("SELECT a FROM Prestamo a").getResultList();
        
            desconectar();
        
            return prestamos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Prestamo buscarPrestamoPorObjeto(String tipoObjeto, String parametro, String valorParametro) {
        try {
            conectar();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Prestamo> query = cb.createQuery(Prestamo.class);
            Root<Prestamo> root = query.from(Prestamo.class);

            query.select(root).where(cb.equal(root.get(tipoObjeto).get(parametro), valorParametro));

            TypedQuery<Prestamo> typedQuery = em.createQuery(query);
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
  
}
