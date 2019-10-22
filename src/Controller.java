import Models.MainNutrients;
import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.*;
import com.mongodb.client.ClientSession;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.time.LocalDateTime;
import java.util.HashMap;

import static com.mongodb.WriteConcern.*;
import static com.mongodb.client.model.Filters.*;

public class Controller {


    //!FROM DB
    public Document getNutritionsDb(String search){
        DB db = new DB();
        

        Document foundInDb = db.collection.find(
                and(
                        gt("expiration", LocalDateTime.now()),
                        eq("searchKeys", search.toLowerCase())
                )).first();

        if(foundInDb == null){
            foundInDb = new Document();
        }

        return  foundInDb;
    }

    public boolean deleteDocumentInDb(String search)  {
        DB db = new DB();
        DeleteResult result = db.collection.deleteOne(eq("searchKeys", search.toLowerCase()));
        return result.getDeletedCount() > 0;
    }


    public void insertDocumentInDb(String search, String totNutrG, String totalDaily, String totalNutrKCal )    {
        DB db = new DB();
        Document nutrientsData = new Document("searchKeys", search)
                .append("expiration", LocalDateTime.now().plusHours(24))
                .append("totalNutrients", totNutrG)
                .append("totalDaily", totalDaily)
                .append("totalNutrientsKCal", totalNutrKCal);

        db.collection.insertOne(nutrientsData);;
    }


    //!FROM API
    public JsonNode getNutritionsAPI(String search)     {
        //GET DATA FROM API
        API api = new API();
        return api.getData(search);
    }








    



}
