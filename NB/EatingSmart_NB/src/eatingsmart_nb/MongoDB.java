package eatingsmart_nb;

import Models.Calories;
import Models.MainNutrients;
import Models.Nutrients;
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
        String conn = "";
        Properties myProperties = Helpers.getProperties();
        return conn = myProperties.getProperty("mongodb.url");
    }

    private Document queryDocument(String srch) {
        Document foundInDb = collection.find(
                and(
                        gt("expiration", LocalDateTime.now()),
                        eq("searchKeys", srch.toLowerCase())
                )).first();

        if (foundInDb == null) {
            foundInDb = new Document();
        }

        return foundInDb;
    }

    @Override
    public Nutrients getData(String src) {

        Document doc = queryDocument(src);
        Nutrients n = new Nutrients();

        if (doc.size() == 0) {
            return null;
        } else {
             System.out.println("************DATA FROM DATABASE**********");
            n = Helpers.MapDataToObject(null, doc);
        }

        return n;

    }

    @Override
    public boolean deleteData(String srch) {
        DeleteResult result = this.collection.deleteOne(eq("searchKeys", srch.toLowerCase()));
        return result.getDeletedCount() > 0;

    }

    @Override
    public void insertData(String search, MainNutrients totNutrG, MainNutrients totalDaily, Calories totalNutrKCal) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            String totalG = objectMapper.writeValueAsString(totNutrG);
            String totalD = objectMapper.writeValueAsString(totalDaily);
            String totalK = objectMapper.writeValueAsString(totalNutrKCal);

            Document nutrientsData = new Document("searchKeys", search)
                    .append("expiration", LocalDateTime.now().plusHours(24))
                    .append("totalNutrients", totalG)
                    .append("totalDaily", totalD)
                    .append("totalNutrientsKCal", totalK);

            this.collection.insertOne(nutrientsData);

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

    }

//    public  Document GetDocument(String field, Object value){
//       try {
//           Document doc = this.collection.find(eq(field, value)).first();
//           return  doc;
//       }catch (MongoException ex){
//           System.out.println(ex.getMessage());
//           return  null;
//       }
//    }
//
//    public void InsertDocument(Document value) {
//       try {
//           this.collection.insertOne(value);
//       }catch (MongoException ex){
//           System.out.println(ex.getMessage());
//       }
//
//    }
//
//    public StringBuilder GetAllDocuments(){
//
//       StringBuilder json = new StringBuilder();
//
//        MongoCursor<Document> cursor = this.collection.find().iterator();
//        try {
//            while (cursor.hasNext()) {
//                json.append(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }
//
//        return json;
//    }
//
//
//    /**
//     *
//     * @param field
//     * @param oldValue
//     * @param newValue
//     * @return long 1- update successful, 0 - not
//     */
//    public long UpdateDocument(String field, Object oldValue, Object newValue){
//      UpdateResult result =  collection.updateOne(eq(field, oldValue), new Document("$set", new Document(field, newValue)));
//
//        return result.getModifiedCount();
//    }
}
