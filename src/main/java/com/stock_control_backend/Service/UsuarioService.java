package com.stock_control_backend.Service;

import com.stock_control_backend.DTO.UsuarioDTO.UsuarioDetailDTO;
import com.stock_control_backend.DTO.UsuarioDTO.UsuarioListDTO;
import com.stock_control_backend.DTO.UsuarioDTO.UsuarioRequestDTO;
import com.stock_control_backend.Exception.EmailAlreadyExistsException;
import com.stock_control_backend.Mapper.UsuarioMapper;
import com.stock_control_backend.Model.Usuario;
import com.stock_control_backend.Repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public UsuarioDetailDTO crearUsuario(UsuarioRequestDTO requestDTO){

        // verificar que no exista por username
        if(usuarioRepository.existsByUsername(requestDTO.username())){
            throw new RuntimeException("El usuario ya existe.");
        }
        if (usuarioRepository.findByEmail(requestDTO.email()).isPresent()) {
            throw new EmailAlreadyExistsException(requestDTO.email());
        }

        Usuario usuario = UsuarioMapper.toEntity(requestDTO);
        Usuario guardado = usuarioRepository.save(usuario);

        return UsuarioMapper.toDetail(guardado);

    }

    public List<UsuarioListDTO> listar(){
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toList)
                .toList();
    }

    public UsuarioDetailDTO editarUsuario(Long id, UsuarioRequestDTO requestDTO){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setUsername(requestDTO.username());
        usuario.setEmail(requestDTO.email());
        usuario.setPassword(requestDTO.password());
        usuario.setRol(requestDTO.rol());

        Usuario usuarioActualizado = usuarioRepository.save(usuario);

        return UsuarioMapper.toDetail(usuarioActualizado);
    }

    public void eliminarUsuario(Long id){
        if(!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    public UsuarioDetailDTO obtenerPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return UsuarioMapper.toDetail(usuario);
    }

}
