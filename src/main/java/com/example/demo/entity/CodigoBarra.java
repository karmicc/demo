package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "codigobarra")
public class CodigoBarra {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) // automatically generated primary key.
    @Column(name = "idcodigobarra")
    private Integer idcodigobarra;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "activo")
    private Boolean activo;

}
