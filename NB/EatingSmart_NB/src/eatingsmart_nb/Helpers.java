package eatingsmart_nb;

import Model2.NutrientsCollection;
import Model2.TotalDaily;
import Model2.TotalNutrients;
import Model2.TotalNutrientsKCal;
import Models.Calories;
import Models.MainNutrients;
import Models.Nutrients;
import Models.VitaminDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

    public static NutrientsCollection MapDataToObject(JsonNode dataApi, Document dataDb) {
        String main = "";
        String kcal = "";
        String daily = "";
        String vitamins = "";

        Nutrients nutrients = new Nutrients();
        NutrientsCollection nutrColl = new NutrientsCollection();
        try {

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            //GET FROM API
            if (dataApi != null) {
                main = dataApi.get("totalNutrients").toString();
                daily = dataApi.get("totalDaily").toString();
                kcal = dataApi.get("totalNutrientsKCal").toString();
                nutrients.setVitaminsCollection(getVitamins(om.readValue(daily, LinkedHashMap.class)));
            }

            //GET FROM DB
            if (dataDb != null) {
                main = dataDb.get("totalNutrients").toString();
                daily = dataDb.get("totalDaily").toString();
                kcal = dataDb.get("totalNutrientsKCal").toString();
                vitamins = dataDb.get("vitamins").toString();
                nutrients.setVitaminsCollection(getVitamins(om.readValue(vitamins, LinkedHashMap.class)));
            }

            MainNutrients mainNutrientsG = om.readValue(main, MainNutrients.class);
            MainNutrients mainNutrientsD = om.readValue(daily, MainNutrients.class);

            TotalNutrients total = om.readValue(main, TotalNutrients.class);
            TotalDaily totalDaily = om.readValue(daily, TotalDaily.class);
            TotalNutrientsKCal totalKcals = om.readValue(kcal, TotalNutrientsKCal.class);
            
            
            nutrColl.setTotalDaily(totalDaily);
            nutrColl.setTotalKcal(totalKcals);
            nutrColl.setTotalNutrients(total);
            nutrColl.setVitaminsCollection(getVitamins(om.readValue(vitamins, LinkedHashMap.class)));

            Calories kcals = om.readValue(kcal, Calories.class);
            nutrients.setCalories(kcals);
            nutrients.setMainNutrientsDaily(mainNutrientsD);
            nutrients.setMainNutrientsGramms(mainNutrientsG);

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        return nutrColl;
    }

    private static Map<String, VitaminDetails> getVitamins(Map<String, LinkedHashMap<String, Object>> vitaminsDaily) {

        //MAP THAT HOLD ALL Nutriens as Objects NutrientDetails
        Map<String, VitaminDetails> myCOllVitamins = new HashMap<>();

        ArrayList<String> filteredWords = new ArrayList<>();
        filteredWords.add("FAT");
        filteredWords.add("FASAT");
        filteredWords.add("FAMS");
        filteredWords.add("FAPU");
        filteredWords.add("ENERC_KCAL");
        filteredWords.add("CHOCDF");
        filteredWords.add("FIBTG");
        filteredWords.add("SUGAR");
        filteredWords.add("PROCNT");

        NumberFormat number = NumberFormat.getInstance();

        number.setMaximumFractionDigits(2);

        vitaminsDaily.forEach((key, val) -> {

            if (filteredWords.indexOf(key) == -1) {
                String label = val.get("label").toString();
                double quantity = val.get("quantity") != null ? Double.parseDouble(val.get("quantity").toString()) : 0;
                String unit = val.get("unit").toString();

                //Build Object VitaminDetails
                VitaminDetails p = new VitaminDetails(label, quantity, unit);

                //Push Vitamins details to Collection
                myCOllVitamins.put(label, p);
            }

        });

        return myCOllVitamins;

    }

}
