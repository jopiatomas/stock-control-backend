package com.stock_control_backend.Repository;

import com.stock_control_backend.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
