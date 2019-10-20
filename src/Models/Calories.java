package Models;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Map;

public class Calories {
    Map<String, Object> energyCal;
    Map<String, Object> preteinCal;
    Map<String, Object> fatCal;
    Map<String, Object> carbsCal;

    public Map<String, Object> getEnergyCal() {
        return energyCal;
    }

    @JsonSetter("ENERC_KCAL")
    public void setEnergyCal(Map<String, Object> energyCal) {
        this.energyCal = energyCal;
    }

    public Map<String, Object> getPreteinCal() {
        return preteinCal;
    }

    @JsonSetter("PROCNT_KCAL")
    public void setPreteinCal(Map<String, Object> preteinCal) {
        this.preteinCal = preteinCal;
    }

    public Map<String, Object> getFatCal() {
        return fatCal;
    }

    @JsonSetter("FAT_KCAL")
    public void setFatCal(Map<String, Object> fatCal) {
        this.fatCal = fatCal;
    }

    public Map<String, Object> getCarbsCal() {
        return carbsCal;
    }

    @JsonSetter("CHOCDF_KCAL")
    public void setCarbsCal(Map<String, Object> carbsCal) {
        this.carbsCal = carbsCal;
    }
}
