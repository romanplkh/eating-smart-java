import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.*;
import java.util.stream.Collectors;

public class Nutrients {

    public MainNutrients getMainNutrientsGrams() {
        return mainNutrientsGrams;
    }

    public void setMainNutrientsGrams(MainNutrients mainNutrientsGrams) {
        this.mainNutrientsGrams = mainNutrientsGrams;
    }

    public MainNutrients getMainNutrientsDaily() {
        return mainNutrientsDaily;
    }

    public void setMainNutrientsDaily(MainNutrients mainNutrientsDaily) {
        this.mainNutrientsDaily = mainNutrientsDaily;
    }

    public Vitamins getVitamins() {
        return vitamins;
    }

    public void setVitamins(Vitamins vitamins) {
        this.vitamins = vitamins;
    }

    private MainNutrients mainNutrientsGrams;
    private MainNutrients mainNutrientsDaily;
    private Vitamins vitamins;

    private ArrayList<Map<String, NutritientsDetails> > test = new ArrayList();

    private  LinkedHashMap<String, String> vits = new LinkedHashMap<>();

    Nutrients() {

    }


    public void fillColletions(JsonNode data){
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode nutrientsGramsData= data.get("totalNutrients");
        JsonNode nutrientsDailyData = data.get("totalDaily");

    }







    public void getNutrients(String search) {

        try {

           JsonNode response = new API().getData("1 apple");
            //GET ALL KEY-VALUES
            JsonNode totalNutrColl = response.get("totalNutrients");
            Iterator<String> allProps = totalNutrColl.fieldNames();
            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


            //Iterate throug keys FAT, PROTEIN, CARBS
//            while(allProps.hasNext()) {
//                //PROTEIN, FAT.....
//                String fieldName = allProps.next();
//                //Return value for each field LABEL-AMOUNT-UNIT
//                JsonNode field = totalNutrColl.get(fieldName);
//                //PARSE TO MODEL
//                Map<String, NutritientsDetails> jsonMap = om.readValue(field.toString(), LinkedHashMap.class);
//                test.add(jsonMap);
//            }



          //  Map<String, LinkedHashMap<String, NutritientsDetails> > mapIngredients = om.readValue(totalNutrColl.toString(), LinkedHashMap.class);


           //JsonNode protein =  response.get("totalNutrients").at("/PROCT");
           JsonNode totalNutrientsG =  response.get("totalNutrients");
            Map<String, LinkedHashMap<String, Object>> jsonMap = om.readValue(totalNutrientsG.toString(), LinkedHashMap.class);
            MainNutrients totalNutr = om.readValue(totalNutrientsG.toString(), MainNutrients.class);
            this.mainNutrientsGrams = totalNutr;
            JsonNode totalCaloris = response.get("totalNutrientsKCal");
            Calories cals = om.readValue(totalCaloris.toString(), Calories.class);

            JsonNode totalDayliVal = response.get("totalDaily");
            MainNutrients totalDay = om.readValue(totalDayliVal.toString(), MainNutrients.class);



            Vitamins v = new Vitamins();


            //MAP THAT HOLD ALL Nutriens as Objects NutrientDetails
            Map<String, NutritientsDetails>  myCOllVitamins = new HashMap<>();

            jsonMap.entrySet().stream().forEach((entry) -> {

                String key = entry.getKey();
                LinkedHashMap<String, Object> val = entry.getValue();// <FAT, {}>

                String label = val.get("label").toString();
                Double quantity = Double.valueOf(val.get("quantity").toString());
                String unit = val.get("unit").toString();

                //Build Object NutrientsDetails
                NutritientsDetails p = new NutritientsDetails(label, quantity, unit);

                //Push Nutrients details to Collection
                // LinkedHashMap <FAT, {label: "", quantity: "", "unit"}>
                myCOllVitamins.put(key, p);
            });


            ArrayList filteredWords = new ArrayList();
            filteredWords.add("FAT");
            filteredWords.add("FASAT");
            filteredWords.add("FAMS");
            filteredWords.add("FAPU");
            filteredWords.add("ENERC_KCAL");
            filteredWords.add("CHOCDF");
            filteredWords.add("FIBTG");
            filteredWords.add("SUGAR");
            filteredWords.add("PROCNT");


            //FILTERED VITAMINS
            Map<String, NutritientsDetails> filtered = myCOllVitamins.entrySet().stream().filter(obj -> filteredWords.indexOf(obj.getKey()) == -1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                    LinkedHashMap::new));


            //Set collection to Class Vitamins
            v.vitsColl = filtered;


            v.vitsColl.entrySet().stream().forEach(entry -> {
                String key = entry.getValue().label;
                double amt = entry.getValue().quantity;
                String unit = entry.getValue().unit;

                System.out.println(key);




            });


            System.out.println("dsf");







        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());

        }


    }


}
