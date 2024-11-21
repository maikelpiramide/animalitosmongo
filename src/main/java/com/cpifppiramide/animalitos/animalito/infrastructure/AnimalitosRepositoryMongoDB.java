package com.cpifppiramide.animalitos.animalito.infrastructure;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitosRepository;
import com.cpifppiramide.animalitos.context.MongoDBConnection;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

public class AnimalitosRepositoryMongoDB implements AnimalitosRepository {
    @Override
    public Animalito save(Animalito animalito) {
        Document document = new Document();
        document.append("nombre", animalito.getNombre());
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("animalitos");
        collection.insertOne(document);
        return null;
    }

    @Override
    public List<Animalito> getAll() {
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("animalitos");
        for (Document document : collection.find()) {
            System.out.println(document.toJson());
        }
        return List.of();
    }
}
