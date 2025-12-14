package com.stock_control_backend.DTO.ProductoDTO;

import com.stock_control_backend.Model.Enum.EstadoProducto;

public record ProductoListDTO (
        Long id,
        String nombre,
        String categoria,
        int stockActual,
        int stockMinimo,
        double precioVenta,
        double costo,
        EstadoProducto estado
)
{}
