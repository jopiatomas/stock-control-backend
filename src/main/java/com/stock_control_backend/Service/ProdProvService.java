package com.stock_control_backend.Service;

import com.stock_control_backend.DTO.ProductoProveedorDTO.ProductoProveedorDetailDTO;
import com.stock_control_backend.DTO.ProductoProveedorDTO.ProductoProveedorRequestDTO;
import com.stock_control_backend.Mapper.ProdProvMapper;
import com.stock_control_backend.Model.Producto;
import com.stock_control_backend.Model.ProductoProveedor;
import com.stock_control_backend.Model.Proveedor;
import com.stock_control_backend.Repository.IProdProvRepository;
import com.stock_control_backend.Repository.IProductoRepository;
import com.stock_control_backend.Repository.IProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdProvService {

    @Autowired
    private IProdProvRepository prodProvRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IProveedorRepository proveedorRepository;

    public ProductoProveedorDetailDTO crearProdProv(ProductoProveedorRequestDTO requestDTO){


        Producto producto = productoRepository.findById(requestDTO.productoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Proveedor proveedor = proveedorRepository.findById(requestDTO.proveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        ProductoProveedor productoProveedor = new ProductoProveedor();
        productoProveedor.setProducto(producto);
        productoProveedor.setProveedor(proveedor);
        productoProveedor.setPrecioProveedor(requestDTO.precioProveedor());

        ProductoProveedor guardado = prodProvRepository.save(productoProveedor);

        return ProdProvMapper.toDetail(guardado);
    }

    public List<ProductoProveedorDetailDTO> listarProductosProveedores(){
        return prodProvRepository.findAll()
                .stream()
                .map(ProdProvMapper::toDetail)
                .toList();
    }

    // faltar listar por porductos y por proveedor
    // además de eliminar, editar, obtener por id
    // se va a necesitar agregar en el repositorio


}
