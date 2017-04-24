/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Administrator;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Conor
 */
@Named(value = "adminLogin")
@RequestScoped
public class AdminLogin {

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
        Administrator admin = sessionHandler.adminLogin(name, password);
        if (admin != null) {
            return "admin_home";
        } else {
            return "login_failed";
        }
    }
    
}
