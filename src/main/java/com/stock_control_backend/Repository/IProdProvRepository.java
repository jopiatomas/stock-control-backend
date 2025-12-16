package com.stock_control_backend.Repository;

import com.stock_control_backend.Model.ProductoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdProvRepository extends JpaRepository<ProductoProveedor, Long> {
}
