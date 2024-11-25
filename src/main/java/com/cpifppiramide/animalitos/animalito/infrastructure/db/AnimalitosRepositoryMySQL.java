package com.cpifppiramide.animalitos.animalito.infrastructure.db;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitosRepository;
import com.cpifppiramide.animalitos.context.MySQLDBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalitosRepositoryMySQL implements AnimalitosRepository {


    @Override
    public List<Animalito> getAll() {
        List<Animalito> animalitos = new ArrayList<>();
        try {
            ResultSet rs = MySQLDBConnection.getInstance().prepareStatement("select * from animales").executeQuery();
            while (rs.next()){
                Animalito animalito = new Animalito(rs.getInt("id"),rs.getString("nombre"),rs.getString("tipo"));
                animalitos.add(animalito);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animalitos;
    }

    @Override
    public Animalito get(Integer id) {
        Animalito animalito =null;
        try {
            ResultSet rs = MySQLDBConnection.getInstance().prepareStatement("select * from animales where id = "+id).executeQuery();
            rs.next();
            animalito = new Animalito(rs.getInt("id"), rs.getString("nombre"),rs.getString("tipo"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animalito;
    }
}
