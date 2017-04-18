/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Customer;
import Interfaces.UserHandlerLocal;
import java.io.Serializable;
import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Conor
 */
@Named(value = "editProfile")
@SessionScoped
public class EditProfile implements Serializable {
    
     @EJB
    UserHandlerLocal userHandler;

    @Inject
    SessionHandler sessionHandler;

    private Customer user;

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

 

   
    public String editUser(Customer user) {
        /* Only allow users to edit their own profile */
        if (sessionHandler.getUser().equals(user)) {
            this.user = user;
            return "update_profile";
        }
        return "login_failed";
    }

    public String updateUser() {
        if (sessionHandler.getUser().equals(user)) {
            this.user = user;
            userHandler.replaceUser(user);
            return "customer_home";
        }

        return "login_failed";
    }
}
