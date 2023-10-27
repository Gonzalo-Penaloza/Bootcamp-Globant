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
import libreria.entidades.Editorial;

/**
 *
 * @author Taddeu's
 */
public class EditorialDAO {
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
    
    public void guardarEditorial(Editorial editorial) throws Exception{
        try {
            conectar();           
            em.getTransaction().begin();           
            em.persist(editorial);           
            em.getTransaction().commit();
            desconectar();            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarEditorial(Editorial editorial) throws Exception{
        try {
            conectar();           
            em.getTransaction().begin();           
            em.remove(em.merge(editorial));           
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarEditorial(Editorial editorial) throws Exception{
        try {
            conectar();
            em.getTransaction().begin();           
            em.merge(editorial);           
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Editorial buscarEditorialPorId(Integer id) throws Exception{
        try {
            conectar();
            Editorial editorial = em.find(Editorial.class, id);
            desconectar();
        
            return editorial;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Collection<Editorial> listarEditoriales(){
        try {
            conectar();
        
            List<Editorial> editoriales = em.createQuery("SELECT a FROM Editorial a").getResultList();
        
            desconectar();
        
            return editoriales;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public Editorial buscarEditorialPorParametro(String parametro, String valorParametro) throws Exception{
        try {
            conectar();
            
            CriteriaBuilder cB = em.getCriteriaBuilder();
            CriteriaQuery<Editorial> query = cB.createQuery(Editorial.class);
            Root<Editorial> root = query.from(Editorial.class);
            
            ParameterExpression<String> parExp = cB.parameter(String.class);
            query.select(root).where(cB.equal(root.get(parametro), parExp));
            
            TypedQuery<Editorial> typedQuery = em.createQuery(query);
            typedQuery.setParameter(parExp, valorParametro);
            
            Editorial editorial = typedQuery.getSingleResult();
            
            return editorial;
        } catch (Exception e) {
            System.out.println("No se encontro el editorial");
            return null;
        } finally {
            desconectar();
        }
    }
    
}
