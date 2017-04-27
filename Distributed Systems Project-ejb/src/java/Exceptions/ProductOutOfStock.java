/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Conor
 */
public class ProductOutOfStock extends Exception {

   public ProductOutOfStock(String message) {
        super(message);
    }

    /**
     *
     * @param message exception message
     * @param throwable exception
     */
    public ProductOutOfStock(String message, Throwable throwable) {
        super(message, throwable);
    }

}
