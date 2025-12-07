package com.stock_control_backend.DTO.UsuarioDTO;

import com.stock_control_backend.Model.Enum.Rol;

public record UsuarioDetailDTO (
        Long id,
        String username,
        Rol rol
) {}
