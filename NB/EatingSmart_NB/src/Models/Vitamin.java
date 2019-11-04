package Models;

import java.util.Map;

public class Vitamin {

    private Map<String, VitaminDetails> vitaminsCollection;
    

    public Map<String, VitaminDetails> getVitaminsCollection() {
        return vitaminsCollection;
    }

    public void setVitaminsCollection(Map<String, VitaminDetails> vitaminsCollection) {
        this.vitaminsCollection = vitaminsCollection;
    }
}
