package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodigoBarraDTO {
    private Integer idcodigobarra;
    private String codigo;
    private Boolean activo;
}
