package com.stock_control_backend.Controller;


import com.stock_control_backend.DTO.ProductoDTO.ProductoConProveedoresDTO;
import com.stock_control_backend.DTO.ProductoDTO.ProductoDetailDTO;
import com.stock_control_backend.DTO.ProductoDTO.ProductoListDTO;
import com.stock_control_backend.DTO.ProductoDTO.ProductoRequestDTO;
import com.stock_control_backend.Service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ProductoDetailDTO crearProducto(@RequestBody ProductoRequestDTO requestDTO){
        return productoService.crearProducto(requestDTO);
    }

    @GetMapping
    public List<ProductoListDTO> listarProductos(){
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public ProductoDetailDTO obtenerPorId(@PathVariable Long id){
        return productoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDetailDTO> editarProducto(@PathVariable Long id, @RequestBody ProductoRequestDTO requestDTO){

        ProductoDetailDTO productoActualizado = productoService.editarProducto(id, requestDTO);

        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/proveedores")
    public ProductoConProveedoresDTO obtenerConProveedores(@PathVariable Long id) {
        return productoService.obtenerConProveedores(id);
    }


}
