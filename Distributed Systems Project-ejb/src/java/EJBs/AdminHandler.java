/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import DB_Entities.Administrator;
import Interfaces.AdminHandlerLocal;
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
public class AdminHandler implements AdminHandlerLocal {

    
    @PersistenceContext(unitName = "Distributed_Systems_Project-ejbPU")
    private EntityManager em;
    
   @Override
    public Administrator login(String username, String password) {
        Administrator admin;
        Query query = em.createNamedQuery("Administrator.findByAdminName")
                .setParameter("adminName", username);
        try {
            admin = (Administrator) query.getSingleResult();
        } catch (NoResultException nre) {
            /* If user is not found return null */
            admin = null;
        }
        if (admin == null) {
            return null;
        } else if (admin.getAdminPassword().equals(password)) {
            /* Valid login, return user */
            return admin;
        } else {
            /* Invalid login, return null */
            return null;
        }
    }
    
    @Override
    public void addAdmin(Administrator newadmin){
           
        em.persist(newadmin);
    
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
     @Override
    public List<Administrator> searchName(String name) {
        
        Query query = em.createNamedQuery("Customer.findByAdminName")
                .setParameter("adminName", name);
        
        return query.getResultList();
    }
    
    @Override
    public void replaceAdmin(Administrator admin) {
        em.merge(admin);
    }
}
