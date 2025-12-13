package com.stock_control_backend.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto-proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Proveedor proveedor;

    @Column
    private Double precioProveedor;
}
