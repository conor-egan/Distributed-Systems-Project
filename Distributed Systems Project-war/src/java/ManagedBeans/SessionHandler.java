/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Customer;
import Interfaces.UserHandlerLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.*;
import javax.inject.Inject;
import javax.jms.JMSException;

/**
 *
 * @author Conor
 */
@Named(value = "sessionHandler")
@SessionScoped
public class SessionHandler implements Serializable {

    @EJB
    UserHandlerLocal userHandler;

    public Customer getUser() {
        return user;
    }
    
    private Customer user;
    
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
    
     public boolean checkLogin() {
        return user != null;
    }
    
   
}
