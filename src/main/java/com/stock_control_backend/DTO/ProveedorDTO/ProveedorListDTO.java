package com.stock_control_backend.DTO.ProveedorDTO;


public record ProveedorListDTO (
        Long id,
        String nombre,
        String telefono,
        String email,
        String direccion,
        String rubro
)
{}
