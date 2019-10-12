import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.MongoException;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class API {

    private MongoClient mongoClient;
    private String apiId;
    private String apiKey;
    private URL baseUrl;


    ObjectMapper objectMapper;


    API() {
        this.objectMapper = new ObjectMapper();
        this.mongoClient = MongoClients.create("mongodb+srv://roman:Lovelife89!@nutrients-lmd94.mongodb.net/admin?retryWrites=true&w=majority");
    }


    public void getCredentials() {

        try {
            MongoDatabase db = this.mongoClient.getDatabase("Administrator");

            MongoCollection<Document> admin = db.getCollection("Creds");

            //Get document
            Document creds = admin.find().first();

            //Get id for API
            this.apiId = creds.get("app_id").toString();
            this.apiKey = creds.get("app_key").toString();
            this.baseUrl =  new URL(creds.get("base_url").toString());

            System.out.printf(this.apiId);
            System.out.printf(this.apiKey);
            System.out.printf(this.baseUrl.toString());


        } catch (MongoException | MalformedURLException e) {
            System.out.println(e.getMessage());
        }


//        URL url = new URL("https://api.edamam.com/api/nutrition-data?app_id=f7c18e2c&app_key=4d954df472a36b23bdd06f81aeff9cc6&ingr=" + URLEncoder.encode(search, "UTF-8"));
//
//        //Open HTTP connection
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//
//        //CONFIGURATION CONNECTION
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Accept", "application/json");
//
//
//        //READ DATA AND STORE IN BUFFER
//        BufferedReader response = new BufferedReader(new InputStreamReader(
//                (conn.getInputStream())));

    }


    public void getUrl() {
        // this.url
    }


    //THIS IS LIKE DATATABLE FOR SQL

    public Map<String, Object> getMappedValue(Document doc) {
        try {
            Map<String, Object> jsonMap = this.objectMapper.readValue(doc.toJson(), new TypeReference<>() {
            });
            return jsonMap;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


    public Map<String, Object> getMappedValue(String json) {
        try {
            Map<String, Object> jsonMap = this.objectMapper.readValue(json, new TypeReference<>() {
            });
            return jsonMap;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


}
