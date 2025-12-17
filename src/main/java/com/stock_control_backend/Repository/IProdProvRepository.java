package com.stock_control_backend.Repository;

import com.stock_control_backend.Model.ProductoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProdProvRepository extends JpaRepository<ProductoProveedor, Long> {

    List<ProductoProveedor> findByProductoId(Long productoId);

    List<ProductoProveedor> findByProveedorId(Long proveedorId);
}
