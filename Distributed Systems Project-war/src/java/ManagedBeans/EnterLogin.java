/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Customer;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Conor
 */
@Named(value = "enterLogin")
@RequestScoped
public class EnterLogin {
    
    private String name;
    private String password;
    
    @Inject
    SessionHandler sessionHandler;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
   public String login() {
        Customer user = sessionHandler.login(name, password);
        if (user != null) {
            return "customer_home";
        } else {
            return "login_failed";
        }
    }
    
    
    /**
     * Creates a new instance of EnterLogin
     */
    public EnterLogin() {
        
    }
    
}
