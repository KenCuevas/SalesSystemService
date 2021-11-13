package com.example.proyectoopensource.Controllers;

import com.example.proyectoopensource.Exceptions.OrdenCompraNotFoundException;
import com.example.proyectoopensource.Models.OrdenCompra;
import com.example.proyectoopensource.Repositories.OrdenCompraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrdeCompraController {
    @Autowired
    private OrdenCompraRepository repository;

    @GetMapping("/compras/all")
    public @ResponseBody Iterable<OrdenCompra>list(){
        return repository.findAll();
    }

    @PostMapping("/compras/add")
    public OrdenCompra createOrden(@RequestBody final  OrdenCompra ordenCompra){
        return repository.save(ordenCompra);
    }
    @GetMapping(path = "/compra/search/{id}")
    public OrdenCompra getOrden(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new OrdenCompraNotFoundException(id));
    }
    @PutMapping("/orden/update/{id}")
    public OrdenCompra updateCompra(@PathVariable Long id, @RequestBody OrdenCompra ordenCompra){
        OrdenCompra existingOrden = repository.getById(id);
        BeanUtils.copyProperties(ordenCompra, existingOrden, "id");
        return repository.saveAndFlush(existingOrden);
    }
    @DeleteMapping("/orden/delete/{id}")
    void deleteOrden(@PathVariable Long id){
        repository.deleteById(id);
    }
}
