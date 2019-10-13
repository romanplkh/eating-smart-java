import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class DB {

   private MongoClient mongoClient;
   private MongoDatabase database;
   private MongoCollection<Document> collection;

   public DB(){
        this.mongoClient = MongoClients.create("mongodb+srv://roman:Lovelife89!@nutrients-lmd94.mongodb.net/admin?retryWrites=true&w=majority");

    }

    public void initDB(){
        try {

            this.database = this.mongoClient.getDatabase("EatingSmart");
        }catch (MongoException ex){

            System.out.println(ex.getMessage());
        }

    }


    public void GetCollection(String collectionName){
       try {
           this.collection = this.database.getCollection(collectionName);
       }catch (MongoException ex){
           System.out.println(ex.getMessage());
       }

    }

    public  Document GetDocument(String field, Object value){
       try {
           Document doc = this.collection.find(eq(field, value)).first();
           return  doc;
       }catch (MongoException ex){
           System.out.println(ex.getMessage());
           return  null;
       }
    }

    public void InsertDocument(Document value) {
       try {
           this.collection.insertOne(value);
       }catch (MongoException ex){
           System.out.println(ex.getMessage());
       }

    }

    public StringBuilder GetAllDocuments(){

       StringBuilder json = new StringBuilder();

        MongoCursor<Document> cursor = this.collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                json.append(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        return json;
    }


    /**
     *
     * @param field
     * @param oldValue
     * @param newValue
     * @return long 1- update successful, 0 - not
     */
    public long UpdateDocument(String field, Object oldValue, Object newValue){
      UpdateResult result =  collection.updateOne(eq(field, oldValue), new Document("$set", new Document(field, newValue)));

        return result.getModifiedCount();
    }





}
