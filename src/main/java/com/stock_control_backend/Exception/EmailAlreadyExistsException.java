package com.stock_control_backend.Exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("Ya existe el usuario con el email: " + email);
    }
}
