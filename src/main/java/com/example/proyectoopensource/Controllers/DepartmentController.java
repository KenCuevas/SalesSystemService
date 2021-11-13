package com.example.proyectoopensource.Controllers;

import com.example.proyectoopensource.Exceptions.DepartamentosNotFoundException;
import com.example.proyectoopensource.Models.Departamentos;
import com.example.proyectoopensource.Repositories.DepartamentosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class DepartmentController {
    @Autowired
    private DepartamentosRepository repository;

    @GetMapping("/departamentos/all")
    List<Departamentos>getAll(){
        return repository.findAll();
    }


    @PostMapping("/departamentos/add")
    public Departamentos createDepartment(@RequestBody final Departamentos departamentos){
        return repository.save(departamentos);
    }
    @GetMapping(path = "/departamentos/search/{id}")
    public Departamentos getDepartment(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow( () -> new DepartamentosNotFoundException(id));
    }

    @PutMapping("/departamentos/update/{id}")
    public Departamentos updateDepartment(@PathVariable Long id, @RequestBody Departamentos departamentos){
        Departamentos existingDepartment = repository.getById(id);
        BeanUtils.copyProperties(departamentos, existingDepartment, "id");
        return  repository.saveAndFlush(existingDepartment);
    }

    @DeleteMapping("/departamentos/delete/{id}")
    void deleteDepartment(@PathVariable Long id){
        repository.deleteById(id);
    }
}
