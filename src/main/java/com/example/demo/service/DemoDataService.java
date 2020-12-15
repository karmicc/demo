package com.example.demo.service;

import com.example.demo.entity.*;

import java.util.List;

public interface DemoDataService {
    List<Categoria> findAllCategoria();
    Categoria findByCodigo(String Codigo);
    Categoria saveCategoria(CategoriaDTO categoriaDTO);
    String deleteCategoria(Integer id);
    String updateCategoria(CategoriaDTO categoriaDTO);

    //List<CodigoBarra> findAllCodigoBarra();
    CodigoBarra saveCodigoBarra(CodigoBarraDTO codigoBarraDTO);
    List<CodigoBarra> findAllCodigoBarra();
    List<CodigoBarra> findByCodigoBarraCodigo(String codigo);
    String deleteCodigoBarra(Integer id);
    String updateCodigoBarra(CodigoBarraDTO codigoBarraDTO);

    Producto saveProducto(Producto producto);
    ProductoDTO findByProductoCodigo(String codigo);
    List<Producto> findAllProducto();
    String deleteProducto(Integer id);
    String updateProducto(Producto productoDTO);
}
