package com.example.demo.entity;

import com.example.demo.util.JsonToMapConverted;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class

public class Producto {
    @Id
    @GeneratedValue
    @Column(name = "idproducto")
    private Integer idproducto;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "categoria")
    private Integer categoria;
    @Column(name = "codigobarras", columnDefinition = "json")
    private String codigobarras;

}
