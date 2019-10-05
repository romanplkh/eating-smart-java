import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;

import java.net.URL;
import java.util.Map;

public class API {


    DB db;
    ObjectMapper objectMapper;
    URL url;

    API(String baseUrl) {
        this.objectMapper = new ObjectMapper();
    }



    public void getUrl(){
       // this.url
    }


    public Map<String, Object> getMappedValue(Document doc) throws JsonProcessingException {
        Map<String, Object> jsonMap = this.objectMapper.readValue(doc.toJson(),
                new TypeReference<>() {
                });
        return jsonMap;
    }


    public Map<String, Object> getMappedValue(String json) throws JsonProcessingException {
        Map<String, Object> jsonMap = this.objectMapper.readValue(json,
                new TypeReference<>() {
                });
        return jsonMap;
    }





}
