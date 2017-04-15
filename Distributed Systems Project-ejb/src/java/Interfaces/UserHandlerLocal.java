/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DB_Entities.Customer;
import javax.ejb.Local;

/**
 *
 * @author Conor
 */
@Local
public interface UserHandlerLocal {
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public Customer login(String username, String password);
    public void addUser(Customer newuser);
    
}
