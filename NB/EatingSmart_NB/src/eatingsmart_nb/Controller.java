package eatingsmart_nb;

import Models.NutritientsDetails;
import com.fasterxml.jackson.databind.JsonNode;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bson.Document;

//Rename to repo class. Repos has to know about Rest or Mongo
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

        db.collection.insertOne(nutrientsData);
    }


    //!FROM API
    public JsonNode getNutritionsAPI(String search)     {
        //GET DATA FROM API
        API api = new API();
        return api.getData(search);
    }


    public Map<String, NutritientsDetails> extractVitamins(Map<String, LinkedHashMap<String, Object>> vitaminsDaily) {

        Map<String, NutritientsDetails> filteredVitamins = new HashMap<>();
        ArrayList<String> filterWords = new ArrayList<String>();
        filterWords.add("FAT");
        filterWords.add("FASAT");
        filterWords.add("FAMS");
        filterWords.add("FAPU");
        filterWords.add("ENERC_KCAL");
        filterWords.add("CHOCDF");
        filterWords.add("FIBTG");
        filterWords.add("SUGAR");
        filterWords.add("PROCNT");


        vitaminsDaily.forEach((key, val) -> {

            if (filterWords.indexOf(key) == -1) {
                String label = val.get("label").toString();
                double quantity = Double.parseDouble(val.get("quantity").toString());
                String unit = val.get("unit").toString();

                //Build Object NutrientsDetails
                NutritientsDetails p = new NutritientsDetails(label, quantity, unit);

                //Push Nutrients details to Collection
                filteredVitamins.put(label, p);
            }

        });

        //FILTERED VITAMINS
//        Map<String, NutritientsDetails> filtered = filteredVitamins.entrySet().stream().filter(obj -> filterWords.indexOf(obj.getKey()) == -1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
//                LinkedHashMap::new));


        //Set collection to Class Models.Vitamins
        return filteredVitamins;

    }





    



}
