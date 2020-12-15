package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.CodigoBarraRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.DemoDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DemoDataServiceImpl implements DemoDataService {
    @Autowired
    protected final CategoriaRepository categoriaRepository;

    @Autowired
    protected final CodigoBarraRepository codigoBarraRepository;

    @Autowired
    protected final ProductoRepository productoRepository;

    public DemoDataServiceImpl(CategoriaRepository categoriaRepository, CodigoBarraRepository codigoBarraRepository, ProductoRepository productoRepository) {

        this.categoriaRepository = categoriaRepository;
        this.codigoBarraRepository = codigoBarraRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Categoria> findAllCategoria() {
        return categoriaRepository.findAll();
    }
    @Override
    public Categoria findByCodigo(String codigo){
        return categoriaRepository.findByCodigo(codigo);
    }

    @Override
    public Categoria saveCategoria(CategoriaDTO categoriaDTO) {
        Categoria c = new Categoria();
        c.setCodigo(categoriaDTO.getCodigo());
        c.setDescripcion(categoriaDTO.getDescripcion());
        c.setActivo(categoriaDTO.getActivo());
        return categoriaRepository.save(c);
    }

    @Override
    public String deleteCategoria(Integer id) {
        if (categoriaRepository.findById(id).isPresent()) {
            categoriaRepository.deleteById(id);
            return "Categoria eliminada correctamente.";
        }
        return "Error! La Categoria no existe";
    }

    @Override
    public String updateCategoria(CategoriaDTO categoriaDTO) {
        Integer num = categoriaDTO.getIdcategoria();
        if (categoriaRepository.findById(num).isPresent()) {
            Categoria categoriaToUpdate = new Categoria();
            categoriaToUpdate.setIdcategoria(categoriaDTO.getIdcategoria());
            categoriaToUpdate.setCodigo(categoriaDTO.getCodigo());
            categoriaToUpdate.setDescripcion(categoriaDTO.getDescripcion());
            categoriaToUpdate.setActivo(categoriaDTO.getActivo());
            categoriaRepository.save(categoriaToUpdate);
            return "Categoria modificada";
        }
        return "Error al modificar la categoria";
    }

    @Override
    public CodigoBarra saveCodigoBarra(CodigoBarraDTO codigoBarraDTO) {
        CodigoBarra cb = new CodigoBarra();
        cb.setCodigo(codigoBarraDTO.getCodigo());
        cb.setActivo(codigoBarraDTO.getActivo());
        return codigoBarraRepository.save(cb);
    }

    @Override
    public List<CodigoBarra> findAllCodigoBarra() {
        return codigoBarraRepository.findAll();
    }

    @Override
    public List<CodigoBarra> findByCodigoBarraCodigo(String codigo) {

        return codigoBarraRepository.findByCodigo(codigo);
    }

    @Override
    public String deleteCodigoBarra(Integer id) {
        if (codigoBarraRepository.findById(id).isPresent()) {
            codigoBarraRepository.deleteById(id);
            return "Codigo de Barras eliminado correctamente.";
        }
        return "Error! El codigo de barras no existe";
    }

    @Override
    public String updateCodigoBarra(CodigoBarraDTO codigoBarraDTO) {
        Integer num = codigoBarraDTO.getIdcodigobarra();
        if (codigoBarraRepository.findById(num).isPresent()) {
            CodigoBarra codigoBarraToUpdate = new CodigoBarra();
            codigoBarraToUpdate.setIdcodigobarra(codigoBarraDTO.getIdcodigobarra());
            codigoBarraToUpdate.setCodigo(codigoBarraDTO.getCodigo());
            codigoBarraToUpdate.setActivo(codigoBarraDTO.getActivo());
            codigoBarraRepository.save(codigoBarraToUpdate);
            return "Codigo de barras modificado";
        }
        return "Error al modificar el codigo de barras";
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public ProductoDTO findByProductoCodigo(String codigo) {
        ProductoDTO productoDTO = new ProductoDTO();
        CategoriaDTO categoriaDTO = new CategoriaDTO();

        Producto producto = productoRepository.findProductoByCodigo(codigo);
        Categoria categoria = categoriaRepository.findById(producto.getCategoria()).get();//findByCodigo());

        categoriaDTO.setIdcategoria(categoria.getIdcategoria());
        categoriaDTO.setCodigo(categoria.getCodigo());
        categoriaDTO.setDescripcion(categoria.getDescripcion());
        categoriaDTO.setActivo(categoria.getActivo());

        productoDTO.setIdproducto(producto.getIdproducto());
        productoDTO.setCodigo(producto.getCodigo());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setCategoria(categoriaDTO);
        productoDTO.setActivo(producto.getActivo());
        return productoDTO;
    }

    @Override
    public List<Producto> findAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public String deleteProducto(Integer id) {
        if (productoRepository.findById(id).isPresent()) {
            productoRepository.deleteById(id);
            return "Producto eliminado correctamente.";
        }
        return "Error! El producto no existe";
    }

    @Override
    public String updateProducto(Producto productoDTO) {
        Integer num = productoDTO.getIdproducto();
        if (productoRepository.findById(num).isPresent()) {
            Producto productoToUpdate = new Producto();
            productoToUpdate.setIdproducto(productoDTO.getIdproducto());
            productoToUpdate.setCodigo(productoDTO.getCodigo());
            productoToUpdate.setDescripcion(productoDTO.getDescripcion());
            productoToUpdate.setCategoria(productoDTO.getCategoria());
            productoToUpdate.setActivo(productoDTO.getActivo());
            productoRepository.save(productoToUpdate);
            return "Producto modificado";
        }
        return "Error al modificar el producto";
    }
}
