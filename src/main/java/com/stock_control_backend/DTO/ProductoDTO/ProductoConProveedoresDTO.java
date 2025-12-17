package com.stock_control_backend.DTO.ProductoDTO;

import com.stock_control_backend.DTO.ProveedorDTO.ProveedorEnProductoDTO;

import java.util.List;

public record ProductoConProveedoresDTO(
        Long id,
        String nombre,
        double precioVenta,
        List<ProveedorEnProductoDTO> proveedores
) {}

