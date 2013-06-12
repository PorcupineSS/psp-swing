package com.porcupine.psp.model.dao.exceptions;

/**
 *
 * @author Zergio
 */
public class RequiredAttributeException extends Exception {

    public RequiredAttributeException(String msg) {
        super(msg);
    }
    
    public RequiredAttributeException(String message, Throwable cause) {
        super(message, cause);
    }
}
