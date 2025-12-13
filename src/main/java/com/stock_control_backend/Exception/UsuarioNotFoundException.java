package com.stock_control_backend.Exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long id) {
      super("No se encontro el Usuario con ID: " + id);
    }
}
