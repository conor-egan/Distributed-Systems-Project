/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Product;
import Exceptions.ProductNotFoundException;
import Interfaces.ProductHandlerLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Conor
 */
@Named(value = "editProducts")
@RequestScoped
public class EditProducts {
    
    
    @EJB
    ProductHandlerLocal productHandler;
    
    @Inject
    SessionHandler sessionHandler;
    
    
    private String name;
    private String author;
    private int price;
    private int stock;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String authenticateAdd(){
   
    if (!(sessionHandler.checkAdmin())) {
            return "admin_login";
        }
    else{
    return "add_product";
   }
   }
    
    public String authenticateDelete(){
   
    if (!(sessionHandler.checkAdmin())) {
            return "admin_login";
        }
    else{
    return "delete_product";
   }
   }
    
    public String authenticateQuantityChange(){
   
    if (!(sessionHandler.checkAdmin())) {
            return "admin_login";
        }
    else{
    return "change_quantity";
   }
   }
    
    public String updateQuantity(int productId){
    
        productHandler.updateQuantity(productId, stock);
        
        return "all_products";
    
    }
    
public String deleteProduct(int productId){
    ProductNotFoundException productNotFoundEx = null;
    try{
        productHandler.deleteProduct(productId);
        
    }catch(ProductNotFoundException pnf){
                    productNotFoundEx = pnf;
                }
    
    return "all_products";
}
    
    
    public String addProduct(){
    
        Product newproduct = new Product();
        
        
        
        
            newproduct.setProductName(name);
            newproduct.setProductAuthor(author);
            newproduct.setProductPrice(price);
            newproduct.setProductStock(stock);
            newproduct.setProductDescription(description);
        
            productHandler.addProduct(newproduct);
        
            return "all_products";
        
    }
    
    public EditProducts() {
    }
    
}
