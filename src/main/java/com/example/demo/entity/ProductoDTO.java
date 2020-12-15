package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Integer idproducto;
    private String codigo;
    private String descripcion;
    private Boolean activo;
    private CategoriaDTO categoria;
    private Set<String> codigobarras;
}
