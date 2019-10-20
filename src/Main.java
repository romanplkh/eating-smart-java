import Models.NutritientsDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.Block;
import com.mongodb.client.*;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;


public class Main {

    public static void main(String[] args) {
        // write your code here

        try {


            API api = new API();
           Nutrients n = new Nutrients();

           n.getNutrients("string");

            System.out.println(n.getMainNutrientsGrams().getCarbs().get("label"));





            //Call2();
            //Test2();
            //MongoDB();

            //GetDoc("1 banana");

            //API api = new API();

            //api.getData("1 egg");


            //OOP_TEST();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void OOP_TEST() {


    }

    public static void GetDoc(String search) throws JsonProcessingException {
        MongoClient mongoClient = MongoClients.create("mongodb+srv://roman:Lovelife89!@nutrients-lmd94.mongodb.net/admin?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("EatingSmart");
        MongoCollection<Document> collection = database.getCollection("Nutrients");

        //GET ONE SEARCH FILTER
        Document myDoc2 = collection.find(eq("name", search)).first();
        //System.out.println("FOUND  DATA: " + myDoc2.toJson());

        ObjectMapper objectMapper = new ObjectMapper();

//        Map<String, Object> jsonMap = objectMapper.readValue(myDoc2.toJson(),
//                new TypeReference<>() {
//                });

        //jsonMap.entrySet().stream().forEach(entry -> System.out.println(entry.getKey()));

    }

    public static void Insert(Document value) {
        MongoClient mongoClient = MongoClients.create("mongodb+srv://roman:Lovelife89!@nutrients-lmd94.mongodb.net/admin?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("EatingSmart");
        MongoCollection<Document> collection = database.getCollection("Nutrients");

        //INSERT DOCUMTNTS


        collection.insertOne(value);

    }

    public static void MongoDB() {

        //Connect to db
        MongoClient mongoClient = MongoClients.create("mongodb+srv://roman:Lovelife89!@nutrients-lmd94.mongodb.net/admin?retryWrites=true&w=majority");


        MongoDatabase database = mongoClient.getDatabase("EatingSmart");

        MongoCollection<Document> collection = database.getCollection("Nutrients");


        //INSERT DOCUMTNTS
        Document doc = new Document("name", "MongoDB")
                .append("timestamp", LocalDate.now().getYear())
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));

        collection.insertOne(doc);


        //Count docs
        System.out.println(collection.countDocuments());


        //Find one doc
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());

        //Find All Docs
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }


        //GET ONE SEARCH FILTER
        Document myDoc2 = collection.find(gt("timestamp", 2000)).first();
        System.out.println("FOUND  DATA: " + myDoc2.toJson());


        //GET ALL SEARCH FILTER
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());

            }
        };

        collection.find(eq("type", "database")).forEach(printBlock);

        //UPDATE ONE -> find one and update
        collection.updateOne(eq("type", "database"), new Document("$set", new Document("type", "my type")));


        //UPDATE MANY
        // UpdateResult updateResult = collection.updateMany(lt("i", 100), inc("i", 100));
        //System.out.println(updateResult.getModifiedCount());


    }

    public static void Test2() {
        try {

            BigDecimal bd = new BigDecimal(100.00);

            BigDecimal bd2 = new BigDecimal(253.43);


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
            JsonNode nutrientsCollection = objectMapper.readTree(response);
            JsonNode totalNutrients = nutrientsCollection.get("totalNutrients");

            JsonNode energy = totalNutrients.at("/ENERC_KCAL");


            LinkedHashMap<String, Object> energyDetails = objectMapper.convertValue(energy, LinkedHashMap.class);


            Iterator<JsonNode> iter = totalNutrients.iterator();


            System.out.println("-------------------------------INSERT---------------------------");
            //Insert(doc);

            conn.disconnect();

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

            System.out.println("---------------------INSERT IN DB--------------------------");
            Document doc = new Document("name", search);
            nutrientsCollection.totalNutrients.entrySet().stream().forEach(entry -> doc.append(entry.getValue().get("label").toString(), entry.getValue()));
            //Insert(doc);

            //CREATE MAP WITH ELEMENT AND ITS DETAILS
            Map<String, NutritientsDetails> nutrientsDetailsMap = new HashMap<>();

            //LOOP THROUGH COLLECTION, CONSTRUCT OBJECT AND PUT IT IN MAP DETAILS
            nutrientsCollection.totalNutrients.entrySet().stream().forEach((entry) -> {

                String key = entry.getKey();

                //HOW TO PARSE IT INSTEAD OF <OBJECT> Like in MODEL/CLASS with props (label, quatity, unit)
                LinkedHashMap<String, Object> val = entry.getValue();// <FAT, {}>


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
//            Map<String, Models.NutritientsDetails> newMapSortedByKey = nutrientsDetailsMap.entrySet().stream()
//                    .sorted(Map.Entry.<String, Models.NutritientsDetails>comparingByKey())
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            //DISPLAY WHAT IN


            conn.disconnect();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
