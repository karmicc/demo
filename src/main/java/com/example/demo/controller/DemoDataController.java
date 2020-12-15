package com.example.demo.controller;

import com.example.demo.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.DemoDataService;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/demo")
public class DemoDataController {
    @Autowired
    private final DemoDataService demoDataService;

    @RequestMapping(value="/categoria/add", method = RequestMethod.POST) // Map ONLY POST Requests
    public ResponseEntity<?> saveCategoria(@RequestBody CategoriaDTO c ) throws Exception {
        return ResponseEntity.ok(demoDataService.saveCategoria(c));
    }
    @GetMapping(value = "/categoria/all")
    public List<Categoria> getAllCategoria(){
        return demoDataService.findAllCategoria();
    }
    @GetMapping(value = "/categoria/byCodigo/{codigo}")
    public Categoria getBycodigo(@PathVariable(name = "codigo") String codigo){
        return demoDataService.findByCodigo(codigo);
    }
    @RequestMapping(value = "/categoria/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteCategoria(@PathVariable Integer id){
        return demoDataService.deleteCategoria(id);
    }
    @RequestMapping(value = "/categoria/update", method = RequestMethod.PUT, produces = "application/json")
    public String updateCategoria(CategoriaDTO categoriaDTO) {
        return demoDataService.updateCategoria(categoriaDTO);
    }
    @RequestMapping(value="/codigo_barra/add", method = RequestMethod.POST) // Map ONLY POST Requests
    public ResponseEntity<?> saveCodigoBarra(@RequestBody CodigoBarraDTO c ) throws Exception {
        return ResponseEntity.ok(demoDataService.saveCodigoBarra(c));
    }
    @GetMapping(value = "/codigo_barra/all")
    public List<CodigoBarra> getAllCodigoBarra(){
        return demoDataService.findAllCodigoBarra();
    }
    @GetMapping(value = "/codigo_barra/byCodigo/{codigo}")
    public List<CodigoBarra> getCodigoBarraBycodigo(@PathVariable(name = "codigo") String codigo){
        return demoDataService.findByCodigoBarraCodigo(codigo);
    }
    @RequestMapping(value = "/codigo_barra/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteCodigoBarra(@PathVariable Integer id){
        return demoDataService.deleteCodigoBarra(id);
    }
    @RequestMapping(value = "/codigo_barra/update", method = RequestMethod.PUT, produces = "application/json")
    public String updateCodigoBarra(CodigoBarraDTO codigoBarraDTO) {
        return demoDataService.updateCodigoBarra(codigoBarraDTO);
    }
    @RequestMapping(value="/producto/add", method = RequestMethod.POST) // Map ONLY POST Requests
    public ResponseEntity<?> saveProducto(@RequestBody Producto producto ) throws Exception {
        return ResponseEntity.ok(demoDataService.saveProducto(producto));
    }
    @GetMapping(value = "/producto/byCodigo/{codigo}")
    public ProductoDTO getByProductoCodigo(@PathVariable(name = "codigo") String codigo){
        return demoDataService.findByProductoCodigo(codigo);
    }
    @GetMapping(value = "/producto/all")
    public List<Producto> getAllProducto(){
        return demoDataService.findAllProducto();
    }
    @RequestMapping(value = "/producto/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteProducto(@PathVariable Integer id){
        return demoDataService.deleteProducto(id);
    }
    @RequestMapping(value = "/producto/update", method = RequestMethod.PUT, produces = "application/json")
    public String updateProducto(Producto producto) {
        return demoDataService.updateProducto(producto);
    }

}