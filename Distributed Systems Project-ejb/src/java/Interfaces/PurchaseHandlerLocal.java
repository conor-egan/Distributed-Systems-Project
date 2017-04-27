/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DB_Entities.Purchases;
import javax.ejb.Local;

/**
 *
 * @author Conor
 */
@Local
public interface PurchaseHandlerLocal {

    public void persist(Object object);

    public void addPurchaseOrder(Purchases purchase);
    
}
