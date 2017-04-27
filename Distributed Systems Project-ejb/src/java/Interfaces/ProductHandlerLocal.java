/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DB_Entities.Product;
import Exceptions.ProductNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Conor
 */
@Local
public interface ProductHandlerLocal {
    
    /**
     * Build a query to search Product table for a product name. Return data list associated with the 
     * entry it finds
     * 
     * @param name
     * @return List<Product>
     */
    public List<Product> searchName(String name);
    
     /**
     * Build a query to search Product table for a product ID. Return data list associated with the 
     * entry it finds
     * 
     * @param productId
     * @return List<Product>
     */
    public List<Product> searchId(int productId);
    
    /**
     * Build a query to return all entries on the Product table.
     * 
     * @return List<Product>
     */
    public List<Product> showAllProducts();

    /**
     * Add a new product entry to the Product table
     * @param newproduct
     */
    public void addProduct(Product newproduct);
    
    /**
     * Delete a product entry for the Product table.
     * @param productID
     * @throws ProductNotFoundException
     */
    public void deleteProduct(int productID) throws ProductNotFoundException;

    /**
     *
     * @param object
     */
    public void persist(Object object);
    
    /**
     * Build a query to return the data associated with a single product entry on the database. Search for specified 
     * product using product ID.
     * 
     * @param productID
     * @return product
     * @throws ProductNotFoundException
     */
    public Product getSingleProduct(int productID) throws ProductNotFoundException ;

    /**
     * Decrease the amount of available stock (quantity on hand) for a particular product. Search
     * using produc ID.
     * 
     * @param productId
     * @param quantity
     */
    public void removeStock(int productId, int quantity);

     /**
     * Change the amount of available stock (quantity on hand) for a specified product entry. Search Product 
     * table using product ID.
     * 
     * @param productId
     * @param quantity
     */
    public void updateQuantity(int productId, int quantity);
    
}
