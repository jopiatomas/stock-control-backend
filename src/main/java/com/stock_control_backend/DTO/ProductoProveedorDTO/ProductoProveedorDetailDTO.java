package com.stock_control_backend.DTO.ProductoProveedorDTO;

public record ProductoProveedorDetailDTO (
        Long id,
        Long productoId,
        String nombreProducto,
        Long proveedorId,
        String nombreProveedor,
        double precioProveedor
){}
