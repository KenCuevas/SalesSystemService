package com.example.proyectoopensource.Controllers;

import com.example.proyectoopensource.Exceptions.UnidadesMedidasNotFoundException;
import com.example.proyectoopensource.Models.UnidadesMedidas;
import com.example.proyectoopensource.Repositories.MeasurementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UnidadesMedidasController {
    @Autowired
    private MeasurementRepository repository;

    @GetMapping("/unidades/all")
    List<UnidadesMedidas>all(){
        return repository.findAll();
    }

    @PostMapping("/unidades/add")
    public UnidadesMedidas createUnidades(@RequestBody final UnidadesMedidas unidadesMedidas){
        return repository.save(unidadesMedidas);
    }

    @GetMapping(path = "/unidades/search/{id}")
    public UnidadesMedidas getUnidades(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new UnidadesMedidasNotFoundException(id));
    }

    @PutMapping("/unidades/update/{id}")
    public UnidadesMedidas updateUnidades(@PathVariable Long id, @RequestBody UnidadesMedidas unidadesMedidas){
        UnidadesMedidas existingUnidades = repository.getById(id);
        BeanUtils.copyProperties(unidadesMedidas, existingUnidades, "id");
        return repository.saveAndFlush(existingUnidades);
    }

    @DeleteMapping("/unidades/delete/{id}")
    void deleteUnits(@PathVariable Long id){
        repository.deleteById(id);
    }
}
