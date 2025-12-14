package com.stock_control_backend.Mapper;

import com.stock_control_backend.DTO.ProductoDTO.ProductoDetailDTO;
import com.stock_control_backend.DTO.ProductoDTO.ProductoListDTO;
import com.stock_control_backend.DTO.ProductoDTO.ProductoRequestDTO;
import com.stock_control_backend.Model.Producto;

public class ProductoMapper {

    public static Producto toEntity(ProductoRequestDTO requestDTO){
        return Producto.builder()
                .nombre(requestDTO.nombre())
                .categoria(requestDTO.categoria())
                .stockActual(requestDTO.stockActual())
                .stockMinimo(requestDTO.stockMinimo())
                .precioVenta(requestDTO.precioVenta())
                .costo(requestDTO.costo())
                .estado(requestDTO.estado())
                .build();
    }

    public static ProductoListDTO toList(Producto producto){
        return new ProductoListDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getStockActual(),
                producto.getStockMinimo(),
                producto.getPrecioVenta(),
                producto.getCosto(),
                producto.getEstado()
                );
    }

    public static ProductoDetailDTO toDetail(Producto producto){
        return new ProductoDetailDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getStockActual(),
                producto.getStockMinimo(),
                producto.getPrecioVenta(),
                producto.getCosto(),
                producto.getEstado()
        );
    }


}
