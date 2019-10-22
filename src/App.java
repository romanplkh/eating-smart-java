import Models.Calories;
import Models.MainNutrients;
import Models.NutritientsDetails;
import Models.Vitamins;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {

    private Controller controller = new Controller();
    private MainNutrients mainNutrientsGrams;
    private MainNutrients mainNutrientsDaily;
    private Calories calories;
    private Vitamins vitamins = new Vitamins();

    //private Map<String, NutritientsDetails> vitamins;



    public App queryData(String search) throws JsonProcessingException {

        try {
            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            Document foundInDb = controller.getNutritionsDb(search.toLowerCase());

            String totalNutrients = "";
            String totalDaily = "";
            String totalNutrientsKCal = "";


            if (foundInDb.size() > 0) {
                //GET DATA FROM DATABASE
                totalNutrients = foundInDb.get("totalNutrients").toString();
                totalDaily = foundInDb.get("totalDaily").toString();
                totalNutrientsKCal = foundInDb.get("totalNutrientsKCal").toString();

            } else {
                //GET DATA FROM API
                JsonNode data = controller.getNutritionsAPI(search.toLowerCase());
                totalNutrients = data.get("totalNutrients").toString();
                totalDaily = data.get("totalDaily").toString();
                totalNutrientsKCal = data.get("totalNutrientsKCal").toString();
                ;


                //DELETE DOCUMENT IF THERE IS ONE
                controller.deleteDocumentInDb(search.toLowerCase());

                //INSERT UPDATED DOCUMENT IN DB
                controller.insertDocumentInDb(search.toLowerCase(), totalNutrients, totalDaily, totalNutrientsKCal);
            }

            //MAP DATA TO MODELS
            this.mainNutrientsGrams = om.readValue(totalNutrients, MainNutrients.class);
            this.calories = om.readValue(totalNutrientsKCal, Calories.class);
            this.mainNutrientsDaily = om.readValue(totalDaily, MainNutrients.class);
            this.vitamins.setVitaminsCollection(getVitamins(om.readValue(totalDaily, LinkedHashMap.class)));


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return this;

    }

    private Map<String, NutritientsDetails> getVitamins(Map<String, LinkedHashMap<String, Object>> vitaminsDaily) {


        //MAP THAT HOLD ALL Nutriens as Objects NutrientDetails
        Map<String, NutritientsDetails> myCOllVitamins = new HashMap<>();
        ArrayList<String> filteredWords = new ArrayList<String>();
        filteredWords.add("FAT");
        filteredWords.add("FASAT");
        filteredWords.add("FAMS");
        filteredWords.add("FAPU");
        filteredWords.add("ENERC_KCAL");
        filteredWords.add("CHOCDF");
        filteredWords.add("FIBTG");
        filteredWords.add("SUGAR");
        filteredWords.add("PROCNT");

        // <FAT, {}>
        vitaminsDaily.forEach((key, val) -> {

            if (filteredWords.indexOf(key) == -1) {
                String label = val.get("label").toString();
                double quantity = Double.parseDouble(val.get("quantity").toString());
                String unit = val.get("unit").toString();

                //Build Object NutrientsDetails
                NutritientsDetails p = new NutritientsDetails(label, quantity, unit);

                //Push Nutrients details to Collection
                // LinkedHashMap <FAT, {label: "", quantity: "", "unit"}>
                myCOllVitamins.put(label, p);
            }

        });

        //FILTERED VITAMINS
//        Map<String, NutritientsDetails> filtered = myCOllVitamins.entrySet().stream().filter(obj -> filteredWords.indexOf(obj.getKey()) == -1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
//                LinkedHashMap::new));


        //Set collection to Class Models.Vitamins
        return myCOllVitamins;


    }


    public MainNutrients getMainNutrientsGrams() {
        return mainNutrientsGrams;
    }

    public MainNutrients getMainNutrientsDaily() {
        return mainNutrientsDaily;
    }


    public Calories getCalories() {
        return calories;
    }

    public Vitamins getVitamins() {
        return vitamins;
    }
    


}
