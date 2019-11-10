/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model2;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Roman
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ENERC_KCAL",
    "FAT",
    "FASAT",
    "CHOCDF",
    "FIBTG",
    "PROCNT"
})
public class TotalDaily {

    @JsonProperty("ENERC_KCAL")
    private ENERCKCAL energy;
    @JsonProperty("FAT")
    private FAT fat;
    @JsonProperty("FASAT")
    private FASAT fatSaturated;
    @JsonProperty("CHOCDF")
    private CHOCDF carboHydrates;
    @JsonProperty("FIBTG")
    private FIBTG fiber;
    @JsonProperty("PROCNT")
    private PROCNT protein;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ENERC_KCAL")
    public ENERCKCAL getEnergy() {
        return energy;
    }

    @JsonProperty("ENERC_KCAL")
    public void setEnergy(ENERCKCAL eNERCKCAL) {
        this.energy = eNERCKCAL;
    }

    @JsonProperty("FAT")
    public FAT getFAT() {
        return fat;
    }

    @JsonProperty("FAT")
    public void setFAT(FAT fAT) {
        this.fat = fAT;
    }

    @JsonProperty("FASAT")
    public FASAT getSaturatedFat() {
        return fatSaturated;
    }

    @JsonProperty("FASAT")
    public void setSaturatedFat(FASAT fASAT) {
        this.fatSaturated = fASAT;
    }

    @JsonProperty("CHOCDF")
    public CHOCDF getCarbs() {
        return carboHydrates;
    }

    @JsonProperty("CHOCDF")
    public void setCarbs(CHOCDF cHOCDF) {
        this.carboHydrates = cHOCDF;
    }

    @JsonProperty("FIBTG")
    public FIBTG getFiber() {
        return fiber;
    }

    @JsonProperty("FIBTG")
    public void setFiber(FIBTG fIBTG) {
        this.fiber = fIBTG;
    }

    @JsonProperty("PROCNT")
    public PROCNT getProtein() {
        return protein;
    }

    @JsonProperty("PROCNT")
    public void setProtein(PROCNT pROCNT) {
        this.protein = pROCNT;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
