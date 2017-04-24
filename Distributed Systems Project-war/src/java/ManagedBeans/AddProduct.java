/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Product;
import Interfaces.ProductHandlerLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Conor
 */
@Named(value = "addProduct")
@RequestScoped
public class AddProduct {
    
    
    @EJB
    ProductHandlerLocal productHandler;
    
    private int id;
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
    
    

    
    
    public String addProduct(){
    
        Product newproduct = new Product();
        
        id = 33;
        
        newproduct.setProductId(id);
        
       
        newproduct.setProductName(name);
        newproduct.setProductAuthor(author);
        newproduct.setProductPrice(price);
        newproduct.setProductStock(stock);
        newproduct.setProductDescription(description);
        
        productHandler.addProduct(newproduct);
        
        return "all_products";
    }
    public AddProduct() {
    }
    
}
