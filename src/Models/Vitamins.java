package Models;

import Models.NutritientsDetails;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Vitamins {

    private Map<String, NutritientsDetails> vitaminsCollection;

    public Map<String, NutritientsDetails> getVitaminsCollection() {
        return vitaminsCollection;
    }

    public void setVitaminsCollection(Map<String, NutritientsDetails> vitaminsCollection) {
        this.vitaminsCollection = vitaminsCollection;
    }
}
