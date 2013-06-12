/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.controller.exceptions;

/**
 *
 * @author Jeisson Andrés Vergara
 */
public class DataBaseException extends Exception {
    
    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataBaseException(String message) {
        super(message);
    }
    
}
