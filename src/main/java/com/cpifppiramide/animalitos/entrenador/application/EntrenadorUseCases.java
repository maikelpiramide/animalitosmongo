package com.cpifppiramide.animalitos.entrenador.application;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitosRepository;
import com.cpifppiramide.animalitos.entrenador.domain.Entrenador;
import com.cpifppiramide.animalitos.entrenador.domain.EntrenadorRepository;

import java.util.ArrayList;
import java.util.List;

public class EntrenadorUseCases {

    private EntrenadorRepository entrenadorRepository;
    private AnimalitosRepository animalitosRepository;

    public EntrenadorUseCases(EntrenadorRepository entrenadorRepository, AnimalitosRepository animalitosRepository) {
        this.entrenadorRepository = entrenadorRepository;
        this.animalitosRepository = animalitosRepository;
    }

    public Entrenador save(Entrenador entrenador){
        String id = this.entrenadorRepository.save(entrenador);
        return this.get(id);
    }

    public Entrenador get(String id){
        Entrenador entrenador = this.entrenadorRepository.get(id);
        List<Animalito> animalitosCompletos = new ArrayList<>();
        for(Animalito animalito : entrenador.getAnimalitos()){
            animalito = this.animalitosRepository.get(animalito.getId());
            animalitosCompletos.add(animalito);
        }
        entrenador.reemplaza(animalitosCompletos);
        return entrenador;
    }

    public Entrenador captura(String id, Animalito animalito){
        //añado el animalito
        this.entrenadorRepository.captura(id, animalito);
        return this.get(id);
    }
}
