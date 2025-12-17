package com.stock_control_backend.Mapper;

import com.stock_control_backend.DTO.ProductoDTO.ProductoConProveedoresDTO;
import com.stock_control_backend.DTO.ProductoDTO.ProductoDetailDTO;
import com.stock_control_backend.DTO.ProductoDTO.ProductoListDTO;
import com.stock_control_backend.DTO.ProductoDTO.ProductoRequestDTO;
import com.stock_control_backend.DTO.ProveedorDTO.ProveedorEnProductoDTO;
import com.stock_control_backend.Model.Producto;
import com.stock_control_backend.Model.ProductoProveedor;

import java.util.List;

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

    public static ProductoConProveedoresDTO toConProveedores(Producto producto, List<ProductoProveedor> productoProveedores){
        List<ProveedorEnProductoDTO> proveedores =
                productoProveedores.stream()
                .map(pp -> new ProveedorEnProductoDTO(
                        pp.getProveedor().getId(),
                        pp.getProveedor().getNombre(),
                        pp.getPrecioProveedor()
                ))
                .toList();

        return new ProductoConProveedoresDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecioVenta(),
                proveedores
        );
    }

}
