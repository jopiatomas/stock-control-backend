package com.stock_control_backend.Controller;

import com.stock_control_backend.DTO.UsuarioDTO.UsuarioDetailDTO;
import com.stock_control_backend.DTO.UsuarioDTO.UsuarioListDTO;
import com.stock_control_backend.DTO.UsuarioDTO.UsuarioRequestDTO;
import com.stock_control_backend.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioDetailDTO crearUsuario(@RequestBody UsuarioRequestDTO requestDTO){
        return usuarioService.crearUsuario(requestDTO);
    }
    
    @GetMapping
    public List<UsuarioListDTO> listar(){
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public UsuarioDetailDTO obtenerPorId(@PathVariable Long id){
        return usuarioService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDetailDTO> editarUsuario(@PathVariable Long id, @RequestBody UsuarioRequestDTO requestDTO){

        UsuarioDetailDTO userActualizado = usuarioService.editarUsuario(id, requestDTO);
        return ResponseEntity.ok(userActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
