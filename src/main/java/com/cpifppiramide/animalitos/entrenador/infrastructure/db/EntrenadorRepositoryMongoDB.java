package com.cpifppiramide.animalitos.entrenador.infrastructure.db;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.context.MongoDBConnection;
import com.cpifppiramide.animalitos.entrenador.domain.Entrenador;
import com.cpifppiramide.animalitos.entrenador.domain.EntrenadorRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonObjectId;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class EntrenadorRepositoryMongoDB implements EntrenadorRepository {
    @Override
    public String save(Entrenador entrenador) {
        Document document = new Document();
        document.append("nombre", entrenador.getNombre());
        InsertOneResult insertOneResult = MongoDBConnection.getDatabase().getCollection("entrenadores").insertOne(document);
        return  ((BsonObjectId)insertOneResult.getInsertedId()).getValue().toHexString();
    }

    //devolvemos el entrenador con sus animalitos
    @Override
    public Entrenador get(String id) {
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("entrenadores");

        Document document = collection.find(eq("_id", new ObjectId(id))).first();

        List<Document> animalitosDocuments = (ArrayList<Document>)document.get("animalitos");

        List<Animalito> animalitos = new ArrayList<>();

        for ( Document d : animalitosDocuments) {
            animalitos.add(new Animalito(d.getInteger("id"), d.getString("nombre"), d.getString("tipo"),d.getInteger("nivel")));
        }

        return new Entrenador(document.getObjectId("_id").toHexString(), document.getString("nombre"), animalitos);
    }

    @Override
    public void captura(String id, Animalito animalito) {
        Document animalitoDocument = new Document();
        animalitoDocument.append("id",animalito.getId());
        animalitoDocument.append("nombre",animalito.getNombre());
        animalitoDocument.append("nivel",animalito.getNivel());

        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("entrenadores");
        Bson update = Updates.push("animalitos",animalitoDocument );
        collection.findOneAndUpdate(eq("_id", new ObjectId(id)),update);
    }


}
