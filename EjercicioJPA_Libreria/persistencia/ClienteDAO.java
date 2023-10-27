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
import libreria.entidades.Cliente;

/**
 *
 * @author Taddeu's
 */
public class ClienteDAO {
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
    
    public void guardarCliente(Cliente cliente) throws Exception{
        try {
            conectar();           
            em.getTransaction().begin();           
            em.persist(cliente);           
            em.getTransaction().commit();
            desconectar();            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarCliente(Cliente cliente) throws Exception{
        try {
            conectar();           
            em.getTransaction().begin();           
            em.remove(em.merge(cliente));           
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarCliente(Cliente cliente) throws Exception{
        try {
            conectar();
            em.getTransaction().begin();           
            em.merge(cliente);           
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Cliente buscarClientePorId(Integer id) throws Exception{
        try {
            conectar();
            Cliente cliente = em.find(Cliente.class, id);
            desconectar();
        
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Collection<Cliente> listarClientes(){
        try {
            conectar();
        
            List<Cliente> clientes = em.createQuery("SELECT a FROM Cliente a").getResultList();
        
            desconectar();
        
            return clientes;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Cliente buscarClientePorParametro(String parametro, String valorParametro) throws Exception{
        try {
            conectar();
            
            CriteriaBuilder cB = em.getCriteriaBuilder();
            CriteriaQuery<Cliente> query = cB.createQuery(Cliente.class);
            Root<Cliente> root = query.from(Cliente.class);
            
            ParameterExpression<String> parExp = cB.parameter(String.class);
            query.select(root).where(cB.equal(root.get(parametro), parExp));
            
            TypedQuery<Cliente> typedQuery = em.createQuery(query);
            typedQuery.setParameter(parExp, valorParametro);
            
            Cliente cliente = typedQuery.getSingleResult();
            
            return cliente;
        } catch (Exception e) {
            System.out.println("No se encontro el cliente");
            return null;
        } finally {
            desconectar();
        }
    }
}
