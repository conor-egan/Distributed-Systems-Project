/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DB_Entities.Administrator;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Conor
 */
@Local
public interface AdminHandlerLocal {
    
    public Administrator login(String username, String password);
    public void addAdmin(Administrator admin);
    public List<Administrator> searchName(String name);

    public void replaceAdmin(Administrator admin);
}
