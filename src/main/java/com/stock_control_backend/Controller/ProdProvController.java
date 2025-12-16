package com.stock_control_backend.Controller;

import com.stock_control_backend.DTO.ProductoDTO.ProductoDetailDTO;
import com.stock_control_backend.DTO.ProductoProveedorDTO.ProductoProveedorDetailDTO;
import com.stock_control_backend.DTO.ProductoProveedorDTO.ProductoProveedorRequestDTO;
import com.stock_control_backend.Service.ProdProvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prodprov")
public class ProdProvController {

    @Autowired
    private ProdProvService prodProvService;

    @PostMapping
    public ProductoProveedorDetailDTO crearProdProv(@RequestBody ProductoProveedorRequestDTO requestDTO){
        return prodProvService.crearProdProv(requestDTO);
    }

    @GetMapping
    public List<ProductoProveedorDetailDTO> listar(){
        return prodProvService.listarProductosProveedores();
    }
}
