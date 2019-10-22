//import Models.Calories;
//import Models.MainNutrients;
//import Models.NutritientsDetails;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Nutrients {
//
//
//
//
//    // !Test this method where I can use it
//    public void fillColletions(JsonNode data){
//        ObjectMapper om = new ObjectMapper();
//        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        JsonNode nutrientsGramsData= data.get("totalNutrients");
//        JsonNode nutrientsDailyData = data.get("totalDaily");
//    }
//
//
//
//    public void getNutrients(String search) {
//
//        try {
//
//
//
//           JsonNode response = new API().getData("1 apple");
//            //GET ALL KEY-VALUES
//            JsonNode totalNutrColl = response.get("totalNutrients");
//
//
//            //!ITERATE THROUGH JSON NOD PROPS
////            Iterator<String> allProps = totalNutrColl.fieldNames();
////            ObjectMapper om = new ObjectMapper();
////            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//            //Iterate throug keys FAT, PROTEIN, CARBS
////            while(allProps.hasNext()) {
////                //PROTEIN, FAT.....
////                String fieldName = allProps.next();
////                //Return value for each field LABEL-AMOUNT-UNIT
////                JsonNode field = totalNutrColl.get(fieldName);
////                //PARSE TO MODEL
////                Map<String, Models.NutritientsDetails> totalNutrientsGrams = om.readValue(field.toString(), LinkedHashMap.class);
////                test.add(totalNutrientsGrams);
////            }
//
//
//
//          //  Map<String, LinkedHashMap<String, Models.NutritientsDetails> > mapIngredients = om.readValue(totalNutrColl.toString(), LinkedHashMap.class);
//
//
//           //JsonNode protein =  response.get("totalNutrients").at("/PROCT");
//            //*GET ALL DATA IN TOTAL NUTRIENTS
//           JsonNode totalNutrientsG =  response.get("totalNutrients");
//           //*STORE IT IN MAP
//            Map<String, LinkedHashMap<String, Object>> totalNutrientsGrams = om.readValue(totalNutrientsG.toString(), LinkedHashMap.class);
//
//
//
//
//
//
//
//
//
//
//            //!NUTRIENTS, CALORIES, VITAMINS
//            //*STORE MAIN NUTRIENTS IN CLASS MainNitrients
//            MainNutrients totalNutr = om.readValue(totalNutrientsG.toString(), MainNutrients.class);
//
//            JsonNode totalCaloris = response.get("totalNutrientsKCal");
//            Calories cals = om.readValue(totalCaloris.toString(), Calories.class);
//
//            JsonNode totalDayliVal = response.get("totalDaily");
//            MainNutrients totalDay = om.readValue(totalDayliVal.toString(), MainNutrients.class);
//
//
//
//            Models.Vitamins v = new Models.Vitamins();
//            //MAP THAT HOLD ALL Nutriens as Objects NutrientDetails
//            Map<String, NutritientsDetails>  myCOllVitamins = new HashMap<>();
//
//            totalNutrientsGrams.entrySet().stream().forEach((entry) -> {
//
//                String key = entry.getKey();
//                LinkedHashMap<String, Object> val = entry.getValue();// <FAT, {}>
//
//                String label = val.get("label").toString();
//                Double quantity = Double.valueOf(val.get("quantity").toString());
//                String unit = val.get("unit").toString();
//
//                //Build Object NutrientsDetails
//                NutritientsDetails p = new NutritientsDetails(label, quantity, unit);
//
//                //Push Nutrients details to Collection
//                // LinkedHashMap <FAT, {label: "", quantity: "", "unit"}>
//                myCOllVitamins.put(key, p);
//            });
//
//
//
//            //!FILTER  ENTRYSET AND LEAVE ONLY VITAMINS
//            ArrayList filteredWords = new ArrayList();
//            filteredWords.add("FAT");
//            filteredWords.add("FASAT");
//            filteredWords.add("FAMS");
//            filteredWords.add("FAPU");
//            filteredWords.add("ENERC_KCAL");
//            filteredWords.add("CHOCDF");
//            filteredWords.add("FIBTG");
//            filteredWords.add("SUGAR");
//            filteredWords.add("PROCNT");
//
//
//            //FILTERED VITAMINS
//            Map<String, NutritientsDetails> filtered = myCOllVitamins.entrySet().stream().filter(obj -> filteredWords.indexOf(obj.getKey()) == -1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
//                    LinkedHashMap::new));
//
//
//            //Set collection to Class Models.Vitamins
//            v.vitsColl = filtered;
//
//
//            v.vitsColl.entrySet().stream().forEach(entry -> {
//                String key = entry.getValue().label;
//                double amt = entry.getValue().quantity;
//                String unit = entry.getValue().unit;
//
//                System.out.println(key);
//
//
//            });
//
//
//
//
//
//
//
//
//
//
//        } catch (Exception e) {
//            System.out.println(e.getCause());
//            System.out.println(e.getMessage());
//
//        }
//
//
//    }
//
//
//}
