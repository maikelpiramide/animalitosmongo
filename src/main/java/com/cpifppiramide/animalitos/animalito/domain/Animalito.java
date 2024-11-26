package com.cpifppiramide.animalitos.animalito.domain;

public class Animalito {

    private final Integer id;
    private final String nombre;
    private String tipo;
    private Integer nivel;

    public Animalito(Integer id, String nombre, String tipo,Integer nivel) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Animalito setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public String toString() {
        return "Animalito{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
