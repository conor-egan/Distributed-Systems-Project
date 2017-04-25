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
public class ProductNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>ProductNotFoundException</code> without
     * detail message.
     * @param message
     */
    public ProductNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs an instance of <code>ProductNotFoundException</code> with the
     * specified detail message.
     *
     * @param message
     * @param throwable
     */
    public ProductNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
