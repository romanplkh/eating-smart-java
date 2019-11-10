/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model2;

import Models.VitaminDetails;
import java.util.Map;

/**
 *
 * @author Roman
 */
public class NutrientsCollection {

    private TotalNutrients totalNutrients;
    private TotalDaily totalDaily;
    private Map<String, VitaminDetails> vitaminsCollection;
    private TotalNutrientsKCal totalKcal;

    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    public void setTotalNutrients(TotalNutrients totalNutrients) {
        this.totalNutrients = totalNutrients;
    }

    public TotalDaily getTotalDaily() {
        return totalDaily;
    }

    public void setTotalDaily(TotalDaily totalDaily) {
        this.totalDaily = totalDaily;
    }

    public Map<String, VitaminDetails> getVitaminsCollection() {
        return vitaminsCollection;
    }

    public void setVitaminsCollection(Map<String, VitaminDetails> vitaminsCollection) {
        this.vitaminsCollection = vitaminsCollection;
    }

    public TotalNutrientsKCal getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(TotalNutrientsKCal totalKcal) {
        this.totalKcal = totalKcal;
    }
    
    
    
    

}
