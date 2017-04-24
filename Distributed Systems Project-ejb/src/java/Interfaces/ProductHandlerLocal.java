/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DB_Entities.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Conor
 */
@Local
public interface ProductHandlerLocal {
    
    public List<Product> searchName(String name);
    public List<Product> searchId(int productId);

    public List<Product> showAllProducts();

    public void addProduct(Product newproduct);
    
}
