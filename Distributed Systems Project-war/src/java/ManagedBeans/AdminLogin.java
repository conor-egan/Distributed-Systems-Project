/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DB_Entities.Administrator;
import EJBs.AdminHandler;
import Interfaces.AdminHandlerLocal;
import java.util.List;
import javax.ejb.EJB;
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
    
    @EJB
    AdminHandlerLocal adminHandler;
    
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
   
    public String addAdmin(){
   
        if (!(sessionHandler.checkAdmin())) {
            return "admin_login";
        }
        else{
            return "add_admin";
        }
   }
   
    public String registerAdmin(){       
            
            Administrator newadmin = new Administrator();
       
            newadmin.setAdminName(name);
            newadmin.setAdminPassword(password);
        
        
            adminHandler.addAdmin(newadmin);
            
            return "admin_list";
            
    }
    
    public List<Administrator> showAllAdmins(){
    
        return adminHandler.showAllAdmins();
    }
   
    
}
