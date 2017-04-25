/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;



import DB_Entities.Product;
import Exceptions.ProductNotFoundException;
import Interfaces.ProductHandlerLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Conor
 */
@SessionScoped
@Named(value = "cartSession")
public class CartSession implements Serializable {

    @Inject
    SessionHandler sessionHandler;
    
    @EJB
    ProductHandlerLocal productHandler;
    
       
    private int quantity;
    private List<Cart> items = new ArrayList<>();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
    public String addToCart(Product product){
            
        if (!(sessionHandler.checkLogin())) {
            return "login";
        }
       
        boolean exists = false;
        for (Cart item : items) {
            if (Objects.equals(item.getProductId(), product.getProductId())) {
                exists = true;
                item.setQuantity(item.getQuantity() + quantity);
                break;
            }
        }
        if (!exists) {
            items.add(new Cart(product, quantity));
        }
        
       return "cart_page";
    }

    public String clearItem(int productId){
    
    if (!(sessionHandler.checkLogin())) {
            return "login";
        }
            
        for (Cart item : items) {
            if (item.getProductId() == productId) {
                
                items.remove(item);
                break;
            }
        }
        return "cart_page";
    }
    
    public List<Cart> getItems() {
        return items;
    }

    public void setItems(List<Cart> items) {
        this.items = items;
    }

    public void clearCart() {
        items.clear();
    }
    
    public String checkout(){
        /* Get all items in the cart */
        List<Cart> CheckoutItems = getItems();
        List<Cart> BoughtItems = new ArrayList();
        
        
        
        System.out.println("Checkout processing");

        for (Cart item : CheckoutItems) {
                
                    int prodID = item.getProductId();
                    int prodQuantity = item.getQuantity();
                    productHandler.removeStock(prodID, prodQuantity);
                    BoughtItems.add(item);
                }
               
            /* add item to cart*/
            
          
        
        clearCart();
        return "checkout_success";
      
    }
}
