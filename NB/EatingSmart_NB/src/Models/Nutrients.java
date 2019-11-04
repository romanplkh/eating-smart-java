/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;

/**
 *
 * @author Roman
 */
public class Nutrients {
    private MainNutrients mainNutrientsGramms;
    private MainNutrients mainNutrientsDaily;
    private List<VitaminDetails> vitamins;
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

    public List<VitaminDetails> getVitamins() {
        return vitamins;
    }

    public void setVitamins(List<VitaminDetails> vitamins) {
        this.vitamins = vitamins;
    }

    public Calories getCalories() {
        return calories;
    }

    public void setCalories(Calories calories) {
        this.calories = calories;
    }
    
    
    

}
