package com.stock_control_backend.DTO.UsuarioDTO;

import com.stock_control_backend.Model.Enum.Rol;

public record UsuarioRequestDTO (
        String username,
        String email,
        String password,
        Rol rol)
{}

