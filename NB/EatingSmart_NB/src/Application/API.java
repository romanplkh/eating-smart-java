package Application;

import Model.NutrientsCollection;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import org.bson.Document;


/**
 * @exercise Final Project
 * @author Roman Pelikh
 * @date 2019-11-16
 */

public class API {

    private MongoClient mongoClient;
    private String apiId;
    private String apiKey;
    private URL baseUrl;

    public API() {
        init();
    }

    /**
     * Get string connection to db
     * Connect to MongoDb and get API key, API id and base URL
     */
    private void init() {
        Properties myProperties = Helpers.getProperties();
        String connectionUrl = myProperties.getProperty("mongodb.url");
        this.mongoClient = MongoClients.create(connectionUrl);
        getCredentialsApi();
    }

    
    /**
     * Get API id, API key, base URL
     * 
     */
    private void getCredentialsApi() {
        try {
            MongoDatabase db = this.mongoClient.getDatabase("Administrator");
            MongoCollection<Document> admin = db.getCollection("Creds");
            Document creds = admin.find().first();
            //Get credentials for API

            if (creds != null) {
                this.apiId = creds.get("app_id").toString();
                this.apiKey = creds.get("app_key").toString();
                this.baseUrl = new URL(creds.get("base_url").toString() + "app_id=" + this.apiId + "&" + "app_key=" + this.apiKey + "&ingr=");
            } else {
                throw new MongoException("Can't fetch credentials");
            }
        } catch (MongoException | MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * 
     * Makes call to API and parses the result to JSON Node
     * @param search value to search
     * @return result of API call in JsonNode Raw format
     */
    private JsonNode getData(String search) {
        JsonNode nutrientsCollection;
        try {

            URL searchRequest = new URL(this.baseUrl.toString() + URLEncoder.encode(search, StandardCharsets.UTF_8.toString()));
            HttpURLConnection conn = (HttpURLConnection) searchRequest.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            BufferedReader response = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            nutrientsCollection = objectMapper.readTree(response);
            conn.disconnect();
            return nutrientsCollection;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Gets data in JsonNode format and calls method to map data against models
     * @param srch ingredient to search
     * @return mapped collection of nutrients
     */
    public NutrientsCollection getNutrients(String srch) {
        JsonNode data = this.getData(srch);

        if (data.get("totalNutrients").isEmpty()) {
            System.out.println("cannot fetch data from api");
            return null;
        }

        return Helpers.MapDataToObject(data);

    }

}
