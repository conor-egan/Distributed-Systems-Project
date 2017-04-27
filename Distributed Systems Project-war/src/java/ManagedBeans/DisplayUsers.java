/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Customer;
import Interfaces.UserHandlerLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Conor
 */
@Named(value = "displayUsers")
@SessionScoped
public class DisplayUsers implements Serializable {

    @EJB
    UserHandlerLocal userHandler;
    
    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public List<Customer> searchName() {
      
        return userHandler.searchName(name);
    }  
     
    public List<Customer> searchId() {
      
        return userHandler.searchId(id);
    }  
    public DisplayUsers() {
    }
    
}
