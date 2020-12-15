package com.example.demo.repository;

import com.example.demo.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    //List<Categoria> findAll();
    List<Categoria> findByCodigo(String codigo);
}
