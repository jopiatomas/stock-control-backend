package com.stock_control_backend.Controller;


import com.stock_control_backend.DTO.ProveedorDTO.ProveedorDetailDTO;
import com.stock_control_backend.DTO.ProveedorDTO.ProveedorListDTO;
import com.stock_control_backend.DTO.ProveedorDTO.ProveedorRequestDTO;
import com.stock_control_backend.Service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public ProveedorDetailDTO crearProveedor(@RequestBody ProveedorRequestDTO requestDTO){
        return proveedorService.crearProveedor(requestDTO);
    }

    @GetMapping
    public List<ProveedorListDTO> listarProveedores(){
        return proveedorService.listarProveedores();
    }

    @GetMapping("/{id}")
    public ProveedorDetailDTO obtenerPorId(@PathVariable Long id){
        return proveedorService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDetailDTO> editarProveedor(@PathVariable Long id, @RequestBody ProveedorRequestDTO requestDTO){

        ProveedorDetailDTO proveedorActualizado = proveedorService.editarProveedor(id, requestDTO);

        return ResponseEntity.ok(proveedorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id){
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }
}
