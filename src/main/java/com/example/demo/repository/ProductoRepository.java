package com.example.demo.repository;

import com.example.demo.entity.Producto;
import com.example.demo.entity.ProductoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Producto findProductoByCodigo(String codigo);
}
