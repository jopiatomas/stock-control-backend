package com.stock_control_backend.Mapper;

import com.stock_control_backend.DTO.UsuarioDTO.UsuarioDetailDTO;
import com.stock_control_backend.DTO.UsuarioDTO.UsuarioListDTO;
import com.stock_control_backend.DTO.UsuarioDTO.UsuarioRequestDTO;
import com.stock_control_backend.Model.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequestDTO requestDTO){
        return Usuario.builder()
                .username(requestDTO.username())
                .email(requestDTO.email())
                .password(requestDTO.password())
                .rol(requestDTO.rol())
                .build();
    }

    public static UsuarioListDTO toList(Usuario usuario) {
        return new UsuarioListDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getRol()
        );
    }

    public static UsuarioDetailDTO toDetail(Usuario usuario) {
        return new UsuarioDetailDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getRol()
        );
    }
}
