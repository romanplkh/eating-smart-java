package Application;

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

/**
 * @exercise Final Project
 * @author Roman Pelikh
 * @date 2019-11-16
 */

public class MongoDB implements IRepo {

    private MongoCollection<Document> collection;

    /**
     * Initializes database 
     * @param database database name
     * @param collection name of collection
     */
    public MongoDB(String database, String collection) {
        MongoClient mongoClient = MongoClients.create(getConnectionString());
        MongoDatabase db = mongoClient.getDatabase(database);
        this.collection = db.getCollection(collection);
    }

    
    /**
     * Gets connection string from db.properties file
     * @return string connection
     */
    private String getConnectionString() {
        Properties myProperties = Helpers.getProperties();
        return myProperties.getProperty("mongodb.url");
    }

    
    /**
     * Queries document and checks if data exists or is fresh
     * @param srch data to search
     * @return found data or null if nothing found
     */
    private Document queryDocument(String srch) {
        Document foundInDb = collection.find(
                and(
                        gt("expiration", LocalDateTime.now()),
                        eq("searchKeys", srch.toLowerCase())
                )).first();

        return foundInDb;
    }

    /**
     * Looks for ingredients details in database
     * @param src ingredient to search
     * @return collection of nutrients
     */
    @Override
    public NutrientsCollection getNutrients(String src) {

        Document doc = queryDocument(src);

        if (doc == null) {
            return null;
        }

        NutrientsCollection n = new NutrientsCollection();

        System.out.println("************DATA FROM DATABASE**********");
        n = Helpers.MapDataToObject(doc);

        return n;

    }

    /**
     * Removes item from database
     * @param srch element to remove
     * @return result of items removed
     */
    @Override
    public boolean deleteItem(String srch) {
        DeleteResult result = this.collection.deleteOne(eq("searchKeys", srch.toLowerCase()));
        return result.getDeletedCount() > 0;

    }

    /**
     * Insert data to  db collection
     * @param search keyword of item to insert
     * @param nutrients collection of nutrients to insert
     */
    @Override
    public void insertNutrients(String search, NutrientsCollection nutrients) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            
            //Serialize data from objects (works like JSON.stringify() in JavaScript)
            String totalG = objectMapper.writeValueAsString(nutrients.getTotalNutrients());
            String totalD = objectMapper.writeValueAsString(nutrients.getTotalDaily());
            String totalK = objectMapper.writeValueAsString(nutrients.getTotalKcal());
            String vitamins = objectMapper.writeValueAsString(nutrients.getVitaminsCollection());

            //Prepare document to insert in database 
            Document nutrientsData = new Document("searchKeys", search)
                    .append("expiration", LocalDateTime.now().plusHours(24))
                    .append("totalNutrients", totalG)
                    .append("totalDaily", totalD)
                    .append("totalNutrientsKCal", totalK)
                    .append("vitamins", vitamins);

            //Insert document in db
            this.collection.insertOne(nutrientsData);

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

    }
}
