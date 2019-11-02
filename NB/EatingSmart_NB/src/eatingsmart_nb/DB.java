package eatingsmart_nb;

import com.mongodb.client.*;
import java.util.Properties;
import org.bson.Document;

public class DB {

   public MongoCollection<Document> collection;

   public DB(){
           dbInit();
    }


    private void dbInit(){
        Properties myProperties = Helpers.getProperties();
        String connectionUrl = myProperties.getProperty("mongodb.url");
        MongoClient mongoClient = MongoClients.create(connectionUrl);
        MongoDatabase db = mongoClient.getDatabase("EatingSmart");
        this.collection = db.getCollection("Nutrients");
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
