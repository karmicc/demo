package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
public class CodigoBarra {
    @Id
    @GeneratedValue
    @Column(name = "idcodigobarra")
    private Integer idcodigobarra;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "activo")
    private Boolean activo;

}
