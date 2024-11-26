package com.cpifppiramide.animalitos.entrenador.application;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitosRepository;
import com.cpifppiramide.animalitos.entrenador.domain.Entrenador;
import com.cpifppiramide.animalitos.entrenador.domain.EntrenadorRepository;
import org.bson.Document;

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
        //cogemos el entrenador de mongorepository por su id
        Entrenador entrenador = this.entrenadorRepository.get(id);
        //obtenemos sus animalitos, como de los animales me hace falta el tipo, (atributo de la tabla intermedia), obtenemos el animal por el id desde mongo y le seteamos el nivel al entrenador
        for(Animalito animalito : entrenador.getAnimalitos()){
            //OBTENEMOS ANIMALITO DE MYSQL POR SU ID
            Animalito animalitoCompleto = this.animalitosRepository.get(animalito.getId());
            //seteamos el entrenador obteneido de mongo los atributos que necesitemos
            animalito.setTipo(animalitoCompleto.getTipo());
        }
        return entrenador;
    }

    public Entrenador captura(String id, Animalito animalito){
        //añado el animalito

        this.entrenadorRepository.captura(id, animalito);
        return this.get(id);
    }
}
