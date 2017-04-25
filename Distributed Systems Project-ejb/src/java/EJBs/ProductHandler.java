/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import DB_Entities.Product;
import Exceptions.ProductNotFoundException;
import Interfaces.ProductHandlerLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Conor
 */
@Stateless
public class ProductHandler implements ProductHandlerLocal {
    
    @PersistenceContext(unitName = "Distributed_Systems_Project-ejbPU")
    private EntityManager em;

    /**
     *
     * @param name
     * @return
     */
    @Override
    public List<Product> searchName(String name) {
        
        
       Query query = em.createNamedQuery("Product.findByProductName")
                .setParameter("productName", name);
        
        return query.getResultList();
    }
    
    @Override
    public List<Product> searchId(int productId) {
        
        
       Query query = em.createNamedQuery("Product.findByProductId")
                .setParameter("productId", productId);
        
        return query.getResultList();
    }
    
    @Override
    public List<Product> showAllProducts() {
        
        
       Query query = em.createNamedQuery("Product.findAll");
        
        return query.getResultList();
    }
    
    @Override
    public void addProduct(Product newproduct){
           
        em.persist(newproduct);
    
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    public void deleteProduct(int productID) throws ProductNotFoundException{
        em.remove(getSingleProduct(productID));
    }
   
    /**
     *
     * @param productID
     * @return
     * @throws ProductNotFoundException
     */
    @Override
    public Product getSingleProduct(int productID) throws ProductNotFoundException {
        Product product;
        Query query = em.createNamedQuery("Product.findByProductId")
                .setParameter("productId", productID);
       
        try{
            product = (Product) query.getSingleResult();
        }catch (NoResultException nre) {
            /*
             * if product is not found throw exception
             */
            product = null;
            throw new ProductNotFoundException("Product ID " + productID
                    + " not found.", nre);
        }
        
        return product;
    }
    
                   
    @Override
    public void updateQuantity(int productId, int quantity){
        
        ProductNotFoundException productNotFoundEx = null;
        Product product = null;
        try{
            product = getSingleProduct(productId);
        }catch(ProductNotFoundException pnf){
                    productNotFoundEx = pnf;
        }
        
        product.setProductStock(quantity);
    
    
    }
   
    
    @Override
    public void removeStock(int productId, int quantity){
        ProductNotFoundException productNotFoundEx = null;
        Product product = null;
        try{
            product = getSingleProduct(productId);
        }catch(ProductNotFoundException pnf){
                    productNotFoundEx = pnf;
        }
        
        product.removeStock(quantity);
        
    }
    
}
