import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Nutrients {
    private NutritientsDetails proteins;

    private ArrayList<Map<String, NutritientsDetails> > test = new ArrayList();

    Nutrients() {

    }


    public NutritientsDetails getProteins() {
        return proteins;
    }


    public void getNutrients(JsonNode response) {

        try {
            //GET ALL KEY-VALUES
            JsonNode all = response.get("totalNutrients");

            Iterator<String> fieldNames = all.fieldNames();
            ObjectMapper om = new ObjectMapper();

            //Iterate throug keys FAT, PROTEIN, CARBS
            while(fieldNames.hasNext()) {

                //PROTEIN, FAT.....
                String fieldName = fieldNames.next();

                //Return value for each field LABEL-AMOUNT-UNIT
                JsonNode field = all.get(fieldName);

                //PARSE TO MODEL
                Map<String, NutritientsDetails> jsonMap = om.readValue(field.toString(), LinkedHashMap.class);
                test.add(jsonMap);
            }

           JsonNode protein =  response.get("totalNutrients").at("/PROCNT");
            Map<String, NutritientsDetails> jsonMap = om.readValue(protein.toString(), LinkedHashMap.class);

            System.out.println("MY " + test.get(1).values().toArray());


            ArrayList fatAbbr = new ArrayList();
            fatAbbr.add("FAT");
            fatAbbr.add("FASAT");
            fatAbbr.add("FAMS");
            fatAbbr.add("FAPU");

            //Filter Map

            JsonNode allItems = response.get("totalNutrients");


            Map<String, NutritientsDetails> myMap = om.readValue(allItems.toString(), LinkedHashMap.class);


            Map<String, NutritientsDetails> filrt = new LinkedHashMap<>();

            for(Map.Entry<String, NutritientsDetails> entry : myMap.entrySet()){
                if(fatAbbr.indexOf(entry.getKey()) == -1){
                    filrt.put(entry.getKey(), entry.getValue());
                }
            }


        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());

        }


    }


}
