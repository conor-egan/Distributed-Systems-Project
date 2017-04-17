/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import DB_Entities.Product;
import Interfaces.ProductHandlerLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Conor
 */
@Stateless
public class ProductHandler implements ProductHandlerLocal {
    
    @PersistenceContext(unitName = "Distributed_Systems_Project-ejbPU")
    private EntityManager em;

    /**
     *
     * @param name
     * @return
     */
    @Override
    public List<Product> searchName(String name) {
        
        
       Query query = em.createNamedQuery("Product.findByProductName")
                .setParameter("productName", name);
        
        return query.getResultList();
    }
    
    @Override
    public List<Product> searchId(int productId) {
        
        
       Query query = em.createNamedQuery("Product.findByProductId")
                .setParameter("productId", productId);
        
        return query.getResultList();
    }
    
    @Override
    public List<Product> showAllProducts() {
        
        
       Query query = em.createNamedQuery("Product.findAll");
        
        return query.getResultList();
    }
   
    
}
