package com.stock_control_backend.DTO.ProductoProveedorDTO;

public record ProductoProveedorRequestDTO (
        Long productoId,
        Long proveedorId,
        double precioProveedor
)
{}
