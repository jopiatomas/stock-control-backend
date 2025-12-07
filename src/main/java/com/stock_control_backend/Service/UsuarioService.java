package com.stock_control_backend.Service;

import com.stock_control_backend.DTO.UsuarioDTO.UsuarioDetailDTO;
import com.stock_control_backend.DTO.UsuarioDTO.UsuarioRequestDTO;
import com.stock_control_backend.Model.Usuario;
import com.stock_control_backend.Repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<UsuarioDetailDTO> guardarUsuario(List<UsuarioRequestDTO> request){
        List<Usuario> usuarioToSave = new ArrayList<>();

        // deberían estar las verificaciones




    }

}
