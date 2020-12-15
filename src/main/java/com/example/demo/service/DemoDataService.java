package com.example.demo.service;

import com.example.demo.entity.Categoria;

import java.util.List;

public interface DemoDataService {
    List<Categoria> findAllCategoria();
    List<Categoria> findByCodigo(String Codigo);
    void saveCategoria(Categoria categoria);
}
