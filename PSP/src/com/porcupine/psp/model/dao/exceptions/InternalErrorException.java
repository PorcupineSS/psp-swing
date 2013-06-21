/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao.exceptions;

/**
 *
 * @author Zergio
 */
public class InternalErrorException extends Exception {

    public InternalErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalErrorException(String message) {
        super(message);

    }
}
