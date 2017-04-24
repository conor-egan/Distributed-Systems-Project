/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Administrator;
import DB_Entities.Customer;
import Interfaces.AdminHandlerLocal;
import Interfaces.UserHandlerLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.*;
import javax.inject.Inject;


/**
 *
 * @author Conor
 */
@Named(value = "sessionHandler")
@SessionScoped
public class SessionHandler implements Serializable {

    @EJB
    UserHandlerLocal userHandler;
    
    @EJB
    AdminHandlerLocal adminHandler;
    
    @Inject
    CartSession cartSession;
    
    private Customer user;
    private Administrator admin;

    public Customer getUser() {
        return user;
    }
    
    public Administrator getAdmin(){
        return admin;
    }
    
   
    
    /**
     * Log into the application
     *
     * @param username username attribute
     * @param password password attribute
     * @return logged in user, null if login fails
     */
    public Customer login(String username, String password) {
        user = userHandler.login(username, password);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }
    
    public Administrator adminLogin(String username, String password) {
        admin = adminHandler.login(username, password);
        if (admin != null) {
            return admin;
        } else {
            return null;
        }
    }
    
     public boolean checkLogin() {
        return user != null;
    }
     
    public boolean checkAdmin(){
        return admin != null;
    }
     
    public String logout() {
        user = null;
        cartSession.clearCart();
        admin = null;
        return "login";
        
    }
    
   
}
