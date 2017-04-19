/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Product;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author Conor
 */
@Stateful
@LocalBean
public class Cart {

    private int quantity;
    private Product product;

    public Cart() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Cart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    
   
    public void setProduct(Product product) {
        this.product = product;
    }
    
   
    public Integer getProductId() {
        return product.getProductId();
    }

    /**
     * Set the product id
     *
     * @param productid the product id
     */
    public void setProductId(Integer productid) {
        product.setProductId(productid);
    }

    
    public String getName() {
        return product.getProductName();
    }

    public void setName(String name) {
        product.setProductName(name);
    }

   
    public String getDescription() {
        return product.getProductDescription();
    }

    
    public void setDescription(String description) {
        product.setProductDescription(description);
    }

    
    public Integer getStock() {
        return product.getProductStock();
    }

    
    public void setStock(Integer quantity) {
        product.setProductStock(quantity);
    }

    
    public int getPrice() {
        return product.getProductPrice();
    }

    
    public void setPrice(int productPrice) {
        product.setProductPrice(productPrice);
    }
    
   
   
   
}
