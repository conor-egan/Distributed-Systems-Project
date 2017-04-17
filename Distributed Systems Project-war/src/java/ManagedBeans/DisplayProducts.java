/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Product;
import Interfaces.ProductHandlerLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Conor
 */
@Named(value = "displayProducts")
@SessionScoped
public class DisplayProducts implements Serializable{
    
    @EJB
    ProductHandlerLocal productHandler;

    @Inject
    SessionHandler sessionHandler;
    
    private String name;

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public List<Product> searchName() {
      
        return productHandler.searchName(name);
    }
    /**
     * Creates a new instance of DisplayProducts
     */
    public DisplayProducts() {
    }
    
}
