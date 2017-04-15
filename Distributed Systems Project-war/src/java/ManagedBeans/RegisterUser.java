/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Customer;
import Interfaces.UserHandlerLocal;
import java.util.Random;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSException;

/**
 *
 * @author Conor
 */
@Named(value = "registerUser")
@RequestScoped
public class RegisterUser {
    
    @Inject
    SessionHandler sessionHandler;
    
    @EJB
    UserHandlerLocal userHandler;
        
      
    private String name;
    private String password;
    private String email;
    private String address;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String addUser(){
    
        
        Customer newuser = new Customer();
       
        newuser.setCustomerName(name);
        newuser.setCustomerPassword(password);
        newuser.setCustomerEmail(email);
        newuser.setCustomerAddress(address);
        newuser.setCustomerDescription(description);
        
        userHandler.addUser(newuser);
        
        Customer user = sessionHandler.login(name, password);
        if (user != null) {
            return "customer_home";
        } else {
            return "login_failed";
        }
    }
        
        
    

    /**
     * Creates a new instance of RegisterUser
     */
    public RegisterUser() {
    }
    
}
