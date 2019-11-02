package Models;

import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.Map;

public class MainNutrients {
    Map<String, Object> energy;
    Map<String, Object> fatGeneral;
    Map<String, Object> fatSatured;
    Map<String, Object> fatMonosatured;
    Map<String, Object> fatPolysatured;
    Map<String, Object> carbs;
    Map<String, Object> fiber;
    Map<String, Object> protein;
    Map<String, Object> sugar;


    public Map<String, Object> getEnergy() {
        return energy;
    }

    @JsonSetter("ENERC_KCAL")
    public void setEnergy(Map<String, Object> energy) {
        this.energy = energy;
    }

    public Map<String, Object> getFatGeneral() {
        return fatGeneral;
    }

    @JsonSetter("FAT")
    public void setFatGeneral(Map<String, Object> fatGeneral) {
        this.fatGeneral = fatGeneral;
    }

    public Map<String, Object> getFatSatured() {
        return fatSatured;
    }
    @JsonSetter("FASAT")
    public void setFatSatured(Map<String, Object> fatSatured) {
        this.fatSatured = fatSatured;
    }

    public Map<String, Object> getFatMonosatured() {
        return fatMonosatured;
    }
    @JsonSetter("FAMS")
    public void setFatMonosatured(Map<String, Object> fatMonosatured) {
        this.fatMonosatured = fatMonosatured;
    }

    public Map<String, Object> getFatPolysatured() {
        return fatPolysatured;
    }
    @JsonSetter("FAPU")
    public void setFatPolysatured(Map<String, Object> fatPolysatured) {
        this.fatPolysatured = fatPolysatured;
    }

    public Map<String, Object> getCarbs() {
        return carbs;
    }
    @JsonSetter("CHOCDF")
    public void setCarbs(Map<String, Object> carbs) {
        this.carbs = carbs;
    }

    public Map<String, Object> getFiber() {
        return fiber;
    }
    @JsonSetter("FIBTG")
    public void setFiber(Map<String, Object> fiber) {
        this.fiber = fiber;
    }

    public Map<String, Object> getProtein() {
        return protein;
    }
    @JsonSetter("PROCNT")
    public void setProtein(Map<String, Object> protein) {
        this.protein = protein;
    }

    public Map<String, Object> getSugar() {
        return sugar;
    }
    @JsonSetter("SUGAR")
    public void setSugar(Map<String, Object> sugar) {
        this.sugar = sugar;
    }
}
