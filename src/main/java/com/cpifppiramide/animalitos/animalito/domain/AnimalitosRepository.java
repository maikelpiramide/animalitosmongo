package com.cpifppiramide.animalitos.animalito.domain;

import java.util.List;

public interface AnimalitosRepository {

    public Animalito save(Animalito animalito);
    public List<Animalito> getAll();

}
