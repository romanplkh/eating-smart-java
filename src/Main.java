import Models.MainNutrients;
import Models.NutritientsDetails;
import UI.SmartEating;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.Block;
import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
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
        //GUI
        //SmartEating gui = new SmartEating();
        //gui.setVisible(true);
        

        try {

            App app = new App();


           //MainNutrients grams =  app.queryData("1 egg").getMainNutrientsGrams();
           MainNutrients value = app.queryData("1 apple").getMainNutrientsDaily();

           

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
