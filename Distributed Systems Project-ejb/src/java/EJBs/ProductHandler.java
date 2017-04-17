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
        // create named query and set parameter
        Query query = em.createNamedQuery("Product.findByProductName")
                .setParameter("productName", "%" + name + "%");
        // return query result
        return query.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
