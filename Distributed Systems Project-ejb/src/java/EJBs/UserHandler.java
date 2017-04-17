/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import DB_Entities.Customer;
import DB_Entities.Product;
import Interfaces.UserHandlerLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Conor
 */
@Stateless
public class UserHandler implements UserHandlerLocal {

    @PersistenceContext(unitName = "Distributed_Systems_Project-ejbPU")
    private EntityManager em;

    
    @Override
    public Customer login(String username, String password) {
        Customer user;
        Query query = em.createNamedQuery("Customer.findByCustomerName")
                .setParameter("customerName", username);
        try {
            user = (Customer) query.getSingleResult();
        } catch (NoResultException nre) {
            /* If user is not found return null */
            user = null;
        }
        if (user == null) {
            return null;
        } else if (user.getCustomerPassword().equals(password)) {
            /* Valid login, return user */
            return user;
        } else {
            /* Invalid login, return null */
            return null;
        }
    }
    
    @Override
    public void addUser(Customer newuser){
           
        em.persist(newuser);
    
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
     @Override
    public List<Customer> searchName(String name) {
        
        Query query = em.createNamedQuery("Customer.findByCustomerName")
                .setParameter("customerName", name);
        
        return query.getResultList();
    }
}
