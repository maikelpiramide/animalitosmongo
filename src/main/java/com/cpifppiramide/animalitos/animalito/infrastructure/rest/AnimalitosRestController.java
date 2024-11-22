package com.cpifppiramide.animalitos.animalito.infrastructure.rest;

import com.cpifppiramide.animalitos.animalito.application.AnimalitosUseCases;
import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.infrastructure.db.AnimalitosRepositoryMySQL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalitosRestController {

    private AnimalitosUseCases animalitosUseCases;

    public AnimalitosRestController(){
        this.animalitosUseCases = new AnimalitosUseCases(new AnimalitosRepositoryMySQL());
    }

    @GetMapping("/api/animalitos")
    public List<Animalito> getAll(){
        return this.animalitosUseCases.getAll();
    }

}
