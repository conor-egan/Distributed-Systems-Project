/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Product;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Conor
 */
@Named (value = "individualProduct")
@SessionScoped
public class IndividualProduct implements Serializable {
    
   private Product product;
    

    public Product getProduct() {
        return product;
    }

    public String setProduct(Product product) {
        this.product = product;
        return "product_page";
    }
    
    public int getID(){
        return product.getProductId();
    }
    public String getName(){
        return product.getProductName();
    }    

    public String getAuthor(){
        return product.getProductAuthor();
    }

    public String getDescription(){
        return product.getProductDescription();
    }
    
    public int getPrice(){
        return product.getProductPrice();
    }
    
    public int getStock(){
        return product.getProductStock();
    }
    
    public String getImage(){
        return product.getProductImage();
    }


    
   
    
}
