/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;


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
        
        Call();
    }

    public static void Call() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader response = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            
             Object obj = new JSONParser().parse(response); 
            JSONArray ja = (JSONArray)obj;
            
            Iterator it = ja.iterator();
            
             Iterator<Map.Entry> itr1;
            //ITERATE THROU ALL ALL OBJECTS IN ARRAY
            while(it.hasNext()){
                itr1 = ((Map) it.next()).entrySet().iterator();
                
                
                //ITERATE THROUGH PROPERTIES IN ARRAY
                while(itr1.hasNext()){
                    Map.Entry pair = itr1.next();
                    System.out.println(pair.getKey() + " ========= " + pair.getValue());
                }
            }
           
        

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = response.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();
        } catch (Exception e) {
        }

    }

}
