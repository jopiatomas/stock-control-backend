package com.stock_control_backend.Model;

import com.stock_control_backend.Model.Enum.EstadoProducto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String categoria;

    @Column
    private int stockActual;

    @Column
    private int stockMinimo;

    @Column
    private double precioVenta;

    @Column
    private double costo;

    @Enumerated(EnumType.STRING)
    @Column
    private EstadoProducto estado;

    // un producto puede tener varios proveedores, one to many
    @ManyToMany
    @JoinTable(
            name = "producto_proveedor",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "proveedor_id")
    )
    private List<Proveedor> proveedores;


}
