package com.cpifppiramide.animalitos.entrenador.domain;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {

    private String id;
    private String nombre;
    private List<Animalito> animalitos;

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador(String id, String nombre, List<Animalito> animalitos) {
        this.id = id;
        this.nombre = nombre;
        this.animalitos = animalitos;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Animalito> getAnimalitos() {
        return animalitos;
    }

    public void reemplaza(List<Animalito> animalitos){
        this.animalitos = animalitos;
    }


}
