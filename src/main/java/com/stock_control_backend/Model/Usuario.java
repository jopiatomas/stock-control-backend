package com.stock_control_backend.Model;

import com.stock_control_backend.Model.Enum.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String email;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private Rol rol;
}

