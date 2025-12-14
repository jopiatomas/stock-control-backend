package com.stock_control_backend.DTO.ProveedorDTO;


public record ProveedorRequestDTO (
        String nombre,
        String telefono,
        String email,
        String direccion,
        String rubro
)
{}
