package com.cpifppiramide.animalitos.entrenador.infrastructure.rest;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.infrastructure.db.AnimalitosRepositoryMySQL;
import com.cpifppiramide.animalitos.entrenador.application.EntrenadorUseCases;
import com.cpifppiramide.animalitos.entrenador.domain.Entrenador;
import com.cpifppiramide.animalitos.entrenador.infrastructure.db.EntrenadorRepositoryMongoDB;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntrenadorRestController {

    private EntrenadorUseCases entrenadorUseCases;

    public EntrenadorRestController(){
        this.entrenadorUseCases = new EntrenadorUseCases(new EntrenadorRepositoryMongoDB(), new AnimalitosRepositoryMySQL());
    }

    @GetMapping("/api/entrenador/{id}")
    public Entrenador get(@PathVariable String id){
        return this.entrenadorUseCases.get(id);
    }

    @PostMapping("/api/entrenador")
    public Entrenador save(@RequestBody Entrenador entrenador){
        return this.entrenadorUseCases.save(entrenador);
    }

    @PutMapping("/api/entrenador/{id}")
    public Entrenador captura(@PathVariable String id, @RequestBody Animalito animalito){
        return this.entrenadorUseCases.captura(id, animalito);
    }

}
