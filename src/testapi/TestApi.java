/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Roman
 */
public class TestApi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            Call2();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void Call2() throws MalformedURLException, ProtocolException {
        try {

            Scanner sc = new Scanner(System.in);

            System.out.println("Your search");

            String search = sc.nextLine();

            
            //Build URL String
            URL url = new URL("https://api.edamam.com/api/nutrition-data?app_id=f7c18e2c&app_key=4d954df472a36b23bdd06f81aeff9cc6&ingr=" + URLEncoder.encode(search, "UTF-8"));
            
            //Open HTTP connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            
            //CONFIGURATION CONNECTION
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            
            //READ DATA AND STORE IN BUFFER
            BufferedReader response = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            
            
            //INIT JSON LIBRARY
            ObjectMapper objectMapper = new ObjectMapper();
            //IGNORE PROPERTIES THAT WILL NOT BE USED 
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            //PARSE OBJECT IN COLLECTION
            NutrientsCollection nutrientsCollection = objectMapper.readValue(response, NutrientsCollection.class);

            System.out.println("-------------------------------ROW DATA---------------------------");
            
            nutrientsCollection.totalNutrients.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + "  ----- " + entry.getValue()));

            //CREATE MAP WITH ELEMENT AND ITS DETAILS
            Map<String, NutritientsDetails> nutrientsDetailsMap = new HashMap<>();

            //LOOP THROUGH COLLECTION, CONSTRUCT OBJECT AND PUT IT IN MAP DETAILS
            nutrientsCollection.totalNutrients.entrySet().stream().forEach((entry) -> {

                String key = entry.getKey();

                //HOW TO PARSE IT INSTEAD OF <OBJECT> Like in MODEL/CLASS with props (label, quatity, unit)
                LinkedHashMap<String, JsonNode> val = entry.getValue();// <FAT, {}>
                
                

                // FAT :{label: "", quantity: "", unit:""}
                //GET DETAIL FROM ENTRY 
                String label = val.get("label").toString();
                Double quantity = Double.valueOf(val.get("quantity").toString());
                String unit = val.get("unit").toString();

                //Build Object NutrientsDetails 
                NutritientsDetails p = new NutritientsDetails(label, quantity, unit);

                //Push Nutrients details to Collection
                // LinkedHashMap <FAT, {label: "", quantity: "", "unit"}>
                nutrientsDetailsMap.put(key, p);
            });

            //--------------HOW TO PARSE ONLY THIS PROPERTY TO CLASS let's say class of FATS, PROTEINS, CHARBS etc...
            //Create filter words 
            ArrayList fatAbbr = new ArrayList();
            fatAbbr.add("FAT");
            fatAbbr.add("FASAT");
            fatAbbr.add("FAMS");
            fatAbbr.add("FAPU");

            //Filter Map           
            Map<String, NutritientsDetails> filtered = nutrientsDetailsMap.entrySet().stream().filter(obj -> fatAbbr.indexOf(obj.getKey()) != -1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            //SORT BY KEYS
//            Map<String, NutritientsDetails> newMapSortedByKey = nutrientsDetailsMap.entrySet().stream()
//                    .sorted(Map.Entry.<String, NutritientsDetails>comparingByKey())
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            //DISPLAY WHAT IN
            NutritientsDetails fat = nutrientsDetailsMap.get(Types.FAPU.toString());

            conn.disconnect();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
