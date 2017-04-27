/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import DB_Entities.Purchases;
import Interfaces.PurchaseHandlerLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Conor
 */
@Stateless
public class PurchaseHandler implements PurchaseHandlerLocal {

   @PersistenceContext(unitName = "Distributed_Systems_Project-ejbPU")
    private EntityManager em;
   
   @Override
    public void addPurchaseOrder(Purchases purchase){
           
        em.persist(purchase);
    
    }

   @Override
    public void persist(Object object) {
        em.persist(object);
    }
}
