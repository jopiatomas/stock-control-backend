package com.stock_control_backend.Service;

import com.stock_control_backend.DTO.ProductoDTO.ProductoDetailDTO;
import com.stock_control_backend.DTO.ProductoDTO.ProductoListDTO;
import com.stock_control_backend.DTO.ProductoDTO.ProductoRequestDTO;
import com.stock_control_backend.Mapper.ProductoMapper;
import com.stock_control_backend.Model.Producto;
import com.stock_control_backend.Repository.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    public ProductoDetailDTO crearProducto(ProductoRequestDTO requestDTO){
        // verificar que no exista por nombre, id

        Producto producto = ProductoMapper.toEntity(requestDTO);
        Producto guardado = productoRepository.save(producto);

        return ProductoMapper.toDetail(guardado);
    }

    public List<ProductoListDTO> listarProductos(){
        return productoRepository.findAll()
                .stream()
                .map(ProductoMapper::toList)
                .toList();
    }

    public ProductoDetailDTO editarProducto(Long id, ProductoRequestDTO requestDTO){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(requestDTO.nombre());
        producto.setCategoria(requestDTO.categoria());
        producto.setStockActual(requestDTO.stockActual());
        producto.setStockMinimo(requestDTO.stockMinimo());
        producto.setPrecioVenta(requestDTO.precioVenta());
        producto.setCosto(requestDTO.costo());
        producto.setEstado(requestDTO.estado());

        Producto productoActualizado = productoRepository.save(producto);

        return ProductoMapper.toDetail(productoActualizado);

    }

    public void eliminarProducto(Long id){
        if(!productoRepository.existsById(id)){
            throw new RuntimeException("Producto no encontrado");
        }
        productoRepository.deleteById(id);
    }

    public ProductoDetailDTO obtenerPorId(Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return ProductoMapper.toDetail(producto);
    }

}
