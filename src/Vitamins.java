import Models.NutritientsDetails;

import java.util.HashMap;
import java.util.Map;

public class Vitamins {

    Map<String, NutritientsDetails> vitsColl = new HashMap<>();

    public Map<String, NutritientsDetails> getVitsColl() {
        return vitsColl;
    }

    public void setVitsColl(Map<String, NutritientsDetails> vitsColl) {
        this.vitsColl = vitsColl;
    }
}
