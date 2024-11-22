package com.cpifppiramide.animalitos.entrenador.domain;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;

public interface EntrenadorRepository {

    public String save(Entrenador entrenador);
    public Entrenador get(String id);
    public void captura(String id, Animalito animalito);
}
