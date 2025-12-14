package com.stock_control_backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proveedores")
@Builder
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String telefono;

    @Column
    private String email;

    @Column
    private String direccion;

    @Column
    private String rubro;

    // lista de productos, un proveedor tiene varios productos
    // el producto que vende este proveedor, tiene menos atributos (no tiene stockMinimo, por ejemplo)
    @ManyToMany(mappedBy = "proveedores")
    private List<Producto> productos;

}
