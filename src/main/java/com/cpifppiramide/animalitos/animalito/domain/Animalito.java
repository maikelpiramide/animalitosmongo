package com.cpifppiramide.animalitos.animalito.domain;

public class Animalito {

    private final Integer id;
    private final String nombre;

    public Animalito(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
