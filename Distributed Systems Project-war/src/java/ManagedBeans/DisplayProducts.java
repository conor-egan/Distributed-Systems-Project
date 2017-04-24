/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Product;
import Interfaces.ProductHandlerLocal;
import java.io.Serializable;
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
    private int productId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public List<Product> searchName() {
      
        return productHandler.searchName(name);
    }
    
    public List<Product> searchId() {
      
        return productHandler.searchId(productId);
    }
    
    public List<Product> showAllProducts(){
    
        return productHandler.showAllProducts();
    }
    /**
     * Creates a new instance of DisplayProducts
     */
    public DisplayProducts() {
    }
    
}
