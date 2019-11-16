package eatingsmart_nb;

import Model.NutrientsCollection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mongodb.client.*;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import com.mongodb.client.result.DeleteResult;
import java.time.LocalDateTime;
import java.util.Properties;
import org.bson.Document;

public class MongoDB implements IRepo {

    MongoCollection<Document> collection;

    public MongoDB(String database, String collection) {
        MongoClient mongoClient = MongoClients.create(getConnectionString());
        MongoDatabase db = mongoClient.getDatabase(database);
        this.collection = db.getCollection(collection);
    }

    private String getConnectionString() {
        Properties myProperties = Helpers.getProperties();
        return myProperties.getProperty("mongodb.url");
    }

    private Document queryDocument(String srch) {
        Document foundInDb = collection.find(
                and(
                        gt("expiration", LocalDateTime.now()),
                        eq("searchKeys", srch.toLowerCase())
                )).first();

        if (foundInDb == null) {
            return null;
        }

        return foundInDb;
    }

    @Override
    public NutrientsCollection getNutrients(String src) {

        Document doc = queryDocument(src);

        if (doc == null) {
            return null;
        }

        NutrientsCollection n = new NutrientsCollection();

//        if (doc.size() == 0) {
//            return null;
//        } else {
        System.out.println("************DATA FROM DATABASE**********");
        n = Helpers.MapDataToObject(doc);
//        }

        return n;

    }

    @Override
    public boolean deleteItem(String srch) {
        DeleteResult result = this.collection.deleteOne(eq("searchKeys", srch.toLowerCase()));
        return result.getDeletedCount() > 0;

    }

    @Override
    public void insertNutrients(String search, NutrientsCollection nutrients) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            String totalG = objectMapper.writeValueAsString(nutrients.getTotalNutrients());
            String totalD = objectMapper.writeValueAsString(nutrients.getTotalDaily());
            String totalK = objectMapper.writeValueAsString(nutrients.getTotalKcal());
            String vitamins = objectMapper.writeValueAsString(nutrients.getVitaminsCollection());

            Document nutrientsData = new Document("searchKeys", search)
                    .append("expiration", LocalDateTime.now().plusHours(24))
                    .append("totalNutrients", totalG)
                    .append("totalDaily", totalD)
                    .append("totalNutrientsKCal", totalK)
                    .append("vitamins", vitamins);

            this.collection.insertOne(nutrientsData);

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

    }
}
