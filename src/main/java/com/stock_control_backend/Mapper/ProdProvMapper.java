package com.stock_control_backend.Mapper;

import com.stock_control_backend.DTO.ProductoProveedorDTO.ProductoProveedorDetailDTO;
import com.stock_control_backend.Model.ProductoProveedor;

public class ProdProvMapper {

    public static ProductoProveedorDetailDTO toDetail(ProductoProveedor productoProveedor){
        return new ProductoProveedorDetailDTO(
                productoProveedor.getId(),
                productoProveedor.getProducto().getId(),
                productoProveedor.getProducto().getNombre(),
                productoProveedor.getProveedor().getId(),
                productoProveedor.getProveedor().getNombre(),
                productoProveedor.getPrecioProveedor()
        );
    }
}
