package eatingsmart_nb;

import Model.NutrientsCollection;
import Model.TotalNutrientsDaily;
import Model.TotalNutrients;
import Model.TotalNutrientsKCal;
import Model.TotalVitamins;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static NutrientsCollection MapDataToObject(JsonNode dataApi) {

        NutrientsCollection nutrColl = new NutrientsCollection();

        try {

            String main = "";
            String kcal = "";
            String daily = "";

            ObjectMapper om = getMapper();

            main = dataApi.get("totalNutrients").toString();
            daily = dataApi.get("totalDaily").toString();
            kcal = dataApi.get("totalNutrientsKCal").toString();
            nutrColl.setVitaminsCollection(mapVitamins(om.readValue(daily, LinkedHashMap.class)));

            //PARSE JSON
            TotalNutrients total = om.readValue(main, TotalNutrients.class);
            TotalNutrientsDaily totalDaily = om.readValue(daily, TotalNutrientsDaily.class);
            TotalNutrientsKCal totalKcals = om.readValue(kcal, TotalNutrientsKCal.class);

            //POPULATE COLLECTION OF NUTRIENTS WITH DATA
            nutrColl.setTotalDaily(totalDaily);
            nutrColl.setTotalKcal(totalKcals);
            nutrColl.setTotalNutrients(total);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return nutrColl;
    }

    public static NutrientsCollection MapDataToObject(Document dataDb) {

        NutrientsCollection nutrColl = new NutrientsCollection();

        try {

            String main = "";
            String kcal = "";
            String daily = "";
            String vitamins = "";

            ObjectMapper om = getMapper();
            main = dataDb.get("totalNutrients").toString();
            daily = dataDb.get("totalDaily").toString();
            kcal = dataDb.get("totalNutrientsKCal").toString();
            vitamins = dataDb.get("vitamins").toString();
            nutrColl.setVitaminsCollection(mapVitamins(om.readValue(vitamins, LinkedHashMap.class)));

            //PARSE JSON
            TotalNutrients total = om.readValue(main, TotalNutrients.class);
            TotalNutrientsDaily totalDaily = om.readValue(daily, TotalNutrientsDaily.class);
            TotalNutrientsKCal totalKcals = om.readValue(kcal, TotalNutrientsKCal.class);

            //POPULATE COLLECTION OF NUTRIENTS WITH DATA
            nutrColl.setTotalDaily(totalDaily);
            nutrColl.setTotalKcal(totalKcals);
            nutrColl.setTotalNutrients(total);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return nutrColl;
    }

    private static ObjectMapper getMapper() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }

    private static Map<String, TotalVitamins> mapVitamins(Map<String, LinkedHashMap<String, Object>> vitaminsDaily) {

        //MAP THAT HOLD ALL Nutriens as Objects NutrientDetails
        Map<String, TotalVitamins> myCOllVitamins = new HashMap<>();

        
        //CREATE FILTER WORDS FOR VITAMINS
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

        
        //FILLTER VITAMINS AND STORE THEM IN VITAMINS COLLECTION
        vitaminsDaily.forEach((key, val) -> {

            if (filteredWords.indexOf(key) == -1) {
                String label = val.get("label").toString();
                double quantity = val.get("quantity") != null ? Double.parseDouble(val.get("quantity").toString()) : 0;
                String unit = val.get("unit").toString();

                //Build Object TotalVitamins
                TotalVitamins p = new TotalVitamins(label, quantity, unit);

                //Push Vitamins details to Collection
                myCOllVitamins.put(label, p);
            }

        });

        return myCOllVitamins;

    }

    /**
     * Gets the string to format, removes empty spaces, sort the
     * letters in ascending order
     * Method is used to store search values in db, so expression "1 orange" and "orange 1" will be evaluated as equal
     * @param s string value
     * @return formatted string to store in db as a key for search
     */
    public static String FormatStringSearch(String s) {
        s = s.replace(" ", "");
        char toSort[] = s.toCharArray();
        Arrays.sort(toSort);
        return new String(toSort);
    }

}
