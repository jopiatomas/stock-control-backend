package com.stock_control_backend.DTO.ProveedorDTO;


public record ProveedorDetailDTO (
        Long id,
        String nombre,
        String telefono,
        String email,
        String direccion,
        String rubro
)
{}
