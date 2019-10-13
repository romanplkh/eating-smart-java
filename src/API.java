import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class API {

    private MongoClient mongoClient;
    private String apiId;
    private String apiKey;
    private URL baseUrl;


    API() {
        init();
    }

    private void init() {
        this.mongoClient = MongoClients.create("mongodb+srv://roman:Lovelife89!@nutrients-lmd94.mongodb.net/admin?retryWrites=true&w=majority");
        getCredentials();
    }

    private void getCredentials() {
        try {
            MongoDatabase db = this.mongoClient.getDatabase("Administrator");
            MongoCollection<Document> admin = db.getCollection("Creds");
            Document creds = admin.find().first();
            //Get credentials for API
            this.apiId = creds.get("app_id").toString();
            this.apiKey = creds.get("app_key").toString();
            this.baseUrl = new URL(creds.get("base_url").toString() + "app_id=" + this.apiId + "&" + "app_key=" + this.apiKey + "&ingr=");
        } catch (MongoException | MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }


    public JsonNode getData(String search) {
        try {
            URL searchRequest = new URL(this.baseUrl.toString() + URLEncoder.encode(search, StandardCharsets.UTF_8));
            HttpURLConnection conn = (HttpURLConnection) searchRequest.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            BufferedReader response = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode nutrientsCollection = objectMapper.readTree(response);
            conn.disconnect();
            return nutrientsCollection;
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


//    public Map<String, Object> getMappedValue(Document doc) {
//        try {
//            Map<String, Object> jsonMap = this.objectMapper.readValue(doc.toJson(), new TypeReference<>() {
//            });
//            return jsonMap;
//        } catch (JsonProcessingException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//
//    }

//
//    public Map<String, Object> getMappedValue(String json) {
//        try {
//            Map<String, Object> jsonMap = this.objectMapper.readValue(json, new TypeReference<>() {
//            });
//            return jsonMap;
//        } catch (JsonProcessingException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//
//    }


}
