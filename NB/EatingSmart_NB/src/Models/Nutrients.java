/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Map;

/**
 *
 * @author Roman
 */
public class Nutrients {
    private MainNutrients mainNutrientsGramms;
    private MainNutrients mainNutrientsDaily;
    private Map<String, VitaminDetails> vitaminsCollection;
    private Calories calories;

    public MainNutrients getMainNutrientsGramms() {
        return mainNutrientsGramms;
    }

    public void setMainNutrientsGramms(MainNutrients mainNutrientsGramms) {
     
        this.mainNutrientsGramms = mainNutrientsGramms;
    }

    public MainNutrients getMainNutrientsDaily() {
        return mainNutrientsDaily;
    }

    public void setMainNutrientsDaily(MainNutrients mainNutrientsDaily) {
        this.mainNutrientsDaily = mainNutrientsDaily;
    }

    public Map<String, VitaminDetails> getVitaminsCollection() {
        return vitaminsCollection;
    }

    public void setVitaminsCollection(Map<String, VitaminDetails> vitaminsCollection) {
        this.vitaminsCollection = vitaminsCollection;
    }
    
    

    public Calories getCalories() {
        return calories;
    }

    public void setCalories(Calories calories) {
        this.calories = calories;
    }
    
    
    

}
