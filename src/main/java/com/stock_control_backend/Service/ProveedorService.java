package com.stock_control_backend.Service;

import com.stock_control_backend.DTO.ProveedorDTO.ProveedorDetailDTO;
import com.stock_control_backend.DTO.ProveedorDTO.ProveedorListDTO;
import com.stock_control_backend.DTO.ProveedorDTO.ProveedorRequestDTO;
import com.stock_control_backend.Mapper.ProveedorMapper;
import com.stock_control_backend.Model.Proveedor;
import com.stock_control_backend.Repository.IProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    @Autowired
    private IProveedorRepository proveedorRepository;

    public ProveedorDetailDTO crearProveedor(ProveedorRequestDTO requestDTO){
        // verificar nombre

        Proveedor proveedor = ProveedorMapper.toEntity(requestDTO);
        Proveedor guardado = proveedorRepository.save(proveedor);

        return ProveedorMapper.toDetail(guardado);
    }

    public List<ProveedorListDTO> listarProveedores(){
        return proveedorRepository.findAll()
                .stream()
                .map(ProveedorMapper::toList)
                .toList();
    }

    public ProveedorDetailDTO editarProveedor(Long id, ProveedorRequestDTO requestDTO){
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        proveedor.setNombre(requestDTO.nombre());
        proveedor.setTelefono(requestDTO.telefono());
        proveedor.setEmail(requestDTO.email());
        proveedor.setDireccion(requestDTO.direccion());
        proveedor.setRubro(requestDTO.rubro());

        Proveedor proveedorActualizado = proveedorRepository.save(proveedor);

        return ProveedorMapper.toDetail(proveedorActualizado);
    }

    public void eliminarProveedor(Long id){
        if(!proveedorRepository.existsById(id)){
            throw new RuntimeException("Proveedor no encontrado");
        }

        proveedorRepository.deleteById(id);
    }

    public ProveedorDetailDTO obtenerPorId(Long id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        return ProveedorMapper.toDetail(proveedor);
    }

}
