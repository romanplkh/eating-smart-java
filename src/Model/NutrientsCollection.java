/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Map;

/**
 * @exercise Final Project
 * @author Roman Pelikh
 * @date 2019-11-16
 */
public class NutrientsCollection {

    private TotalNutrients totalNutrients;
    private TotalNutrientsDaily totalDaily;
    private Map<String, TotalVitamins> vitaminsCollection;
    private TotalNutrientsKCal totalKcal;

    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    public void setTotalNutrients(TotalNutrients totalNutrients) {
        this.totalNutrients = totalNutrients;
    }

    public TotalNutrientsDaily getTotalDaily() {
        return totalDaily;
    }

    public void setTotalDaily(TotalNutrientsDaily totalDaily) {
        this.totalDaily = totalDaily;
    }

    public Map<String, TotalVitamins> getVitaminsCollection() {
        return vitaminsCollection;
    }

    public void setVitaminsCollection(Map<String, TotalVitamins> vitaminsCollection) {
        this.vitaminsCollection = vitaminsCollection;
    }

    public TotalNutrientsKCal getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(TotalNutrientsKCal totalKcal) {
        this.totalKcal = totalKcal;
    }
    
    
    
    

}
