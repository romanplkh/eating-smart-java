import Models.Calories;
import Models.MainNutrients;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.Date;

import static com.mongodb.client.model.Filters.*;

public class App {

    private MainNutrients mainNutrientsGrams;
    private MainNutrients mainNutrientsDaily;
    private Calories calories;
    private Vitamins vitamins;




    //!SET VITAMINS
    //TODO: REFACTOR METHODS OPTIMUZE USE IF FUNCTIONS
    //TODO: ADD VITAMINS


    public App queryData(String search) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //!1. Check if data is is in data base and not expired
        DB db = new DB();

        //if current time > than time stored in DB fetch from API,
        Document foundInDb = db.collection.find(
                and(
                        gt("expiration", LocalDateTime.now()),
                        eq("searchKey", search)
                )).first();



        if (foundInDb.size() != 0) {
            //GET DATA FROM DATABASE
            String totalNutrients = foundInDb.get("totalNutrients").toString();
            String totalDaily = foundInDb.get("totalDaily").toString();
            String totalNutrientsKCal = foundInDb.get("totalNutrientsKCal").toString();


            //MAP DATA TO MODELS
            this.mainNutrientsGrams = om.readValue(totalNutrients, MainNutrients.class);
            this.calories = om.readValue(totalNutrientsKCal, Calories.class);
            this.mainNutrientsDaily = om.readValue(totalDaily, MainNutrients.class);


        } else {
            //GET DATA FROM API
            API api = new API();
            JsonNode data = api.getData(search);
            JsonNode totNutrG = data.get("totalNutrients");
            JsonNode totalDaily = data.get("totalDaily");
            JsonNode totalNutrKCal = data.get("totalNutrientsKCal");


            //MAP DATA TO MODELS
            this.mainNutrientsGrams = om.readValue(totNutrG.toString(), MainNutrients.class);
            this.calories = om.readValue(totalNutrKCal.toString(), Calories.class);
            this.mainNutrientsDaily = om.readValue(totalDaily.toString(), MainNutrients.class);




            //DELETE DOCUMENT IF THERE IS ONE
            db.collection.deleteOne(eq("searchKey", search));

            //INSERT DOCUMENT IN DB
            Document nutrientsData = new Document("serachKeys", search)
                    .append("expiration", LocalDateTime.now().plusHours(24))
                    .append("totalNutrients", totNutrG.toString())
                    .append("totalDaily", totalDaily.toString())
                    .append("totalNutrientsKCal", totalNutrKCal.toString());


            db.collection.insertOne(nutrientsData);

        }
        

        return this;
    }


    public MainNutrients getMainNutrientsGrams() {
        return mainNutrientsGrams;
    }

    public MainNutrients getMainNutrientsDaily() {
        return mainNutrientsDaily;
    }

    public Vitamins getVitamins() {
        return vitamins;
    }
    public Calories getCalories() {
        return calories;
    }


}
