/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


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
        }
        
        
    }
    
    
     public static void Call2() throws MalformedURLException, ProtocolException{
          try {
            URL url = new URL("https://api.edamam.com/api/nutrition-data?app_id=f7c18e2c&app_key=4d954df472a36b23bdd06f81aeff9cc6&ingr=1%20large%20apple");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }

            BufferedReader response = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            
            
            ObjectMapper objectMapper = new ObjectMapper();
            
           
            
              Map<String, Object> jsonMap = objectMapper.readValue(response,
    new TypeReference<Map<String,Object>>(){});
              
              
              Map<String, Object> nutrients = new HashMap<>();
              
              jsonMap.entrySet().forEach(entry -> {
              
                  nutrients.put(entry.getKey(), entry.getValue()); 
              
              });
              
              
              
                        
            
            conn.disconnect();
        } catch (Exception e) {
        }
         
         
         
     }
    

    public static void Call() {
//        try {
//            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//
//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }
//
//            BufferedReader response = new BufferedReader(new InputStreamReader(
//                    (conn.getInputStream())));
//            
//             Object obj = new JSONParser().parse(response); 
//            JSONArray ja = (JSONArray)obj;
//            
//            Iterator it = ja.iterator();
//            
//             Iterator<Map.Entry> itr1;
//            //ITERATE THROU ALL ALL OBJECTS IN ARRAY
//            while(it.hasNext()){
//                itr1 = ((Map) it.next()).entrySet().iterator();
//                
//                
//                //ITERATE THROUGH PROPERTIES IN ARRAY
//                while(itr1.hasNext()){
//                    Map.Entry pair = itr1.next();
//                    System.out.println(pair.getKey() + " ========= " + pair.getValue());
//                }
//            }
//           
//        
//
//            String output;
//            System.out.println("Output from Server .... \n");
//            while ((output = response.readLine()) != null) {
//                System.out.println(output);
//            }
//
//            conn.disconnect();
//        } catch (Exception e) {
       // }

    }

}
