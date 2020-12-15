package com.example.demo.service.impl;

import com.example.demo.entity.Categoria;
import com.example.demo.service.DemoDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class DemoDataServiceImpl implements DemoDataService {
    @Autowired
    protected final CategoriaRepository categoriaRepository;

    public DemoDataServiceImpl(CategoriaRepository categoriaRepository) {

        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findAllCategoria() {
        return categoriaRepository.findAll();
    }
    @Override
    public List<Categoria> findByCodigo(String codigo){
        return categoriaRepository.findByCodigo(codigo);
    }
    @Override
    public void saveCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }
}
