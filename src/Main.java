import Models.MainNutrients;
import Models.NutritientsDetails;
import Models.Vitamins;
import UI.SmartEating;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.Block;
import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
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
        JFrame gui = new JFrame("SmartEating");

        gui.setContentPane(new SmartEating().panelMain);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);

        SmartEating ui = new SmartEating();






        

        try {

//            App app = new App();
//
//            app.queryData("1 egg");
//
//
//




           

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
