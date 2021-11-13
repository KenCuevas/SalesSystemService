package com.example.proyectoopensource.Controllers;

import com.example.proyectoopensource.Exceptions.ProveedoresNotFoundException;
import com.example.proyectoopensource.Models.Proveedores;
import com.example.proyectoopensource.Repositories.ProveedoresRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class ProveedoresController {
    @Autowired
    private ProveedoresRepository repository;

    @GetMapping("/proveedores/all")
    List<Proveedores> getAll(){
        return repository.findAll();
    }

    @GetMapping(path = "/proveedores/search/{id}")
    public Proveedores getProveedores(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ProveedoresNotFoundException(id));
    }

    @PostMapping("/proveedores/add")
    public Proveedores createProveedores(@RequestBody final Proveedores proveedores){
        return repository.save(proveedores);
    }

    @PutMapping("/proveedores/update/{id}")
    public Proveedores updateProveedor(@PathVariable Long id, @RequestBody Proveedores proveedores){
        Proveedores existingProveedor = repository.getById(id);
        BeanUtils.copyProperties(proveedores, existingProveedor, "id");
        return repository.saveAndFlush(existingProveedor);
    }

    @DeleteMapping("/proveedores/delete/{id}")
    void deleteProveedor(@PathVariable Long id){
        repository.deleteById(id);
    }
}
