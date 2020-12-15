package com.example.demo.repository;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.CodigoBarra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodigoBarraRepository extends JpaRepository<CodigoBarra, Integer> {
    List<CodigoBarra> findByCodigo(String codigo);
}
