/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
            
            
            URL url = new URL("https://api.edamam.com/api/nutrition-data?app_id=f7c18e2c&app_key=4d954df472a36b23bdd06f81aeff9cc6&ingr="+ URLEncoder.encode(search, "UTF-8"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader response = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(
                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            //PARSE ONE OBJECT IN COLLECTION
            TotalNutrients nutrientsCollection = objectMapper.readValue(response, TotalNutrients.class);

            //CREATE MAP WITH ELEMENT AND ITS DETAILS
            Map<String, NutritientsDetails> nutrientsDetailsMap = new HashMap<>();
            
            
         
                 
            
            //LOOP THROUGH COLLECTION, CONSTRUCT OBJECT AND PUT IT IN MAP DETAILS
            nutrientsCollection.getTotalNutrients().entrySet().stream().forEach((entry) -> {

                String key = entry.getKey();
                LinkedHashMap<String, Object> val = entry.getValue();

                //GET DETAIL FROM ENTRY
                String label = val.get("label").toString();
                Double quantity = Double.valueOf(val.get("quantity").toString());
                String unit = val.get("unit").toString();

                //Build Object NutrientsDetails
                NutritientsDetails p = new NutritientsDetails(label, quantity, unit);

                //Push Nutrients details to Collection
                nutrientsDetailsMap.put(key, p);
            });
            
            
            
            
            
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
