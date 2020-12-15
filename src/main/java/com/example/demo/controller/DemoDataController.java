package com.example.demo.controller;

import com.example.demo.entity.Categoria;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping(path="/categoria/add", consumes = "application/json") // Map ONLY POST Requests
    public ResponseEntity<String> addNewCat(@RequestBody Categoria c )
            /*(@RequestParam(name = "codigo") String codigo
            , @RequestParam(name = "descripcion") String descripcion
            , @RequestParam(name = "activo") String activo)*/ {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        //Categoria c = new Categoria();
        //c.setCodigo(codigo);
        //c.setDescripcion(descripcion);
        //c.setActivo(Boolean.parseBoolean(activo));
        demoDataService.saveCategoria(c);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/cat/add")
    public Categoria addCategoria(@RequestBody Categoria categoria) {
        demoDataService.saveCategoria(categoria);
        return categoria;
    }

    @GetMapping(value = "/categoria/all")
    public List<Categoria> getAll(){
        return demoDataService.findAllCategoria();
    }
    @GetMapping(value = "/categoria/byCodigo/{codigo}")
    public List<Categoria> getBycodigo(@PathVariable(name = "codigo") String codigo){
        return demoDataService.findByCodigo(codigo);
    }

}