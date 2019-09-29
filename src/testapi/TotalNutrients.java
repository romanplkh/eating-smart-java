/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapi;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Roman
 */
public class TotalNutrients {

    //ENERG_CAL  VALUE
    public Map<String, LinkedHashMap<String, Object>> totalNutrients;
    public Map<String, LinkedHashMap<String, Object>> totalDaily;
    public Map<String, LinkedHashMap<String, Object>> totalNutrientsKCal;

    public Map<String, LinkedHashMap<String, Object>> getTotalNutrients() {
        return totalNutrients;
    }

    public void setTotalNutrients(Map<String, LinkedHashMap<String, Object>> totalNutrients) {
        this.totalNutrients = totalNutrients;
    }

    public Map<String, LinkedHashMap<String, Object>> getTotalDaily() {
        return totalDaily;
    }

    public void setTotalDaily(Map<String, LinkedHashMap<String, Object>> totalDaily) {
        this.totalDaily = totalDaily;
    }

    public Map<String, LinkedHashMap<String, Object>> getTotalNutrientsKCal() {
        return totalNutrientsKCal;
    }

    public void setTotalNutrientsKCal(Map<String, LinkedHashMap<String, Object>> totalNutrientsKCal) {
        this.totalNutrientsKCal = totalNutrientsKCal;
    }

    

}
