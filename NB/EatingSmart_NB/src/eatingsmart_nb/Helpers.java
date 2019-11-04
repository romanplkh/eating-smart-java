package eatingsmart_nb;

import Models.Calories;
import Models.MainNutrients;
import Models.Nutrients;
import Models.VitaminDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.bson.Document;

public class Helpers {

    public static Properties getProperties() {

        Properties props = new Properties();

        try {

            //Build path to the file properties
            //@ Get folder directory
            //@ Get db props file
            String propertiesPath = System.getProperty("user.dir") + "\\db.properties";

            //Load the file content into the "in" variable
            FileInputStream in = new FileInputStream(propertiesPath);
            //Loads properties to the Properties object
            props.load(in);
            in.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return props;

    }

    public static Nutrients MapDataToObject(JsonNode dataApi, Document dataDb) {
        String main = "";
        String kcal = "";
        String daily = "";

        if (dataApi != null) {
            main = dataApi.get("totalNutrients").toString();
            daily = dataApi.get("totalDaily").toString();
            kcal = dataApi.get("totalNutrientsKCal").toString();
        }

        if (dataDb != null) {
            main = dataDb.get("totalNutrients").toString();
            daily = dataDb.get("totalDaily").toString();
            kcal = dataDb.get("totalNutrientsKCal").toString();
        }

        Nutrients nutrients = new Nutrients();
        try {
            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            MainNutrients mainNutrientsG = om.readValue(main, MainNutrients.class);
            MainNutrients mainNutrientsD = om.readValue(daily, MainNutrients.class);
            Calories kcals = om.readValue(kcal, Calories.class);
            List<VitaminDetails> vitaminsList = extractVitamins(om.readValue(daily, LinkedHashMap.class));

            nutrients.setCalories(kcals);
            nutrients.setMainNutrientsDaily(mainNutrientsD);
            nutrients.setMainNutrientsGramms(mainNutrientsG);
            nutrients.setVitamins(vitaminsList);

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        return nutrients;
    }

    public static List<VitaminDetails> extractVitamins(Map<String, LinkedHashMap<String, Object>> vitaminsDaily) {

        List<VitaminDetails> filteredVitamins = new ArrayList<>();
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
                VitaminDetails p = new VitaminDetails(label, quantity, unit);

                //Push Nutrients details to Collection
                filteredVitamins.add(p);
            }

        });

        return filteredVitamins;

    }
}
