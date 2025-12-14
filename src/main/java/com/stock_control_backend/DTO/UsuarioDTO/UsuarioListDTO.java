package com.stock_control_backend.DTO.UsuarioDTO;

import com.stock_control_backend.Model.Enum.Rol;

public record UsuarioListDTO (
        Long id,
        String username,
        String email,
        Rol rol
){}
