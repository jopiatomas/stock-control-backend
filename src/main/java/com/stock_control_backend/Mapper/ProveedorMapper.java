package com.stock_control_backend.Mapper;

import com.stock_control_backend.DTO.ProveedorDTO.ProveedorRequestDTO;
import com.stock_control_backend.Model.Proveedor;
import com.stock_control_backend.DTO.ProveedorDTO.ProveedorDetailDTO;
import com.stock_control_backend.DTO.ProveedorDTO.ProveedorListDTO;

public class ProveedorMapper {

    public static Proveedor toEntity(ProveedorRequestDTO requestDTO){
        return Proveedor.builder()
                .nombre(requestDTO.nombre())
                .telefono(requestDTO.telefono())
                .email(requestDTO.email())
                .direccion(requestDTO.direccion())
                .rubro(requestDTO.rubro())
                .build();
    }

    public static ProveedorDetailDTO toDetail(Proveedor proveedor){
        return new ProveedorDetailDTO(
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getTelefono(),
                proveedor.getEmail(),
                proveedor.getDireccion(),
                proveedor.getRubro()
        );
    }

    public static ProveedorListDTO toList(Proveedor proveedor){
        return new ProveedorListDTO(
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getTelefono(),
                proveedor.getEmail(),
                proveedor.getDireccion(),
                proveedor.getRubro()
        );
    }

}
