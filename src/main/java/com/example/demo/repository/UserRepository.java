package com.example.demo.repository;

import com.example.demo.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usuarios, Integer> {
    Usuarios findByUsername(String username);
}
