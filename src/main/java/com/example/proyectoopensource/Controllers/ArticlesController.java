package com.example.proyectoopensource.Controllers;

import com.example.proyectoopensource.Exceptions.ArticlesNotFoundException;
import com.example.proyectoopensource.Models.Articles;
import com.example.proyectoopensource.Repositories.ArticlesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class ArticlesController {
    @Autowired
    private ArticlesRepository repository;

    @GetMapping("/articles/all")
    List<Articles>all(){
        return repository.findAll();
    }
    @PostMapping("/articles/add")
    public Articles createArticle(@RequestBody Articles articles){
        return repository.save(articles);
    }
    @GetMapping(path = "/articles/search/{id}")
    public Articles getArticle(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ArticlesNotFoundException(id));
    }
    @PutMapping("/articles/update/{id}")
    public Articles updateArticles(@PathVariable Long id, @RequestBody Articles articles){
        Articles existingArticles = repository.getById(id);
        BeanUtils.copyProperties(articles, existingArticles, "id");
        return repository.saveAndFlush(existingArticles);
    }
    @DeleteMapping("/articles/delete/{id}")
    void deleteArticles(@PathVariable Long id){
        repository.deleteById(id);
    }

}
