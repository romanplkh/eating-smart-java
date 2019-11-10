/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model2;

/**
 *
 * @author Roman
 */
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ENERC_KCAL",
    "PROCNT_KCAL",
    "FAT_KCAL",
    "CHOCDF_KCAL"
})
public class TotalNutrientsKCal {

    @JsonProperty("ENERC_KCAL")
    private ENERCKCAL energy;
    @JsonProperty("PROCNT_KCAL")
    private PROCNTKCAL protein;
    @JsonProperty("FAT_KCAL")
    private FATKCAL fat;
    @JsonProperty("CHOCDF_KCAL")
    private CHOCDFKCAL carboHydrate;
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

    @JsonProperty("PROCNT_KCAL")
    public PROCNTKCAL getProteinKcal() {
        return protein;
    }

    @JsonProperty("PROCNT_KCAL")
    public void setProteinKcal (PROCNTKCAL pROCNTKCAL) {
        this.protein = pROCNTKCAL;
    }

    @JsonProperty("FAT_KCAL")
    public FATKCAL getFATKCAL() {
        return fat;
    }

    @JsonProperty("FAT_KCAL")
    public void setFATKCAL(FATKCAL fATKCAL) {
        this.fat = fATKCAL;
    }

    @JsonProperty("CHOCDF_KCAL")
    public CHOCDFKCAL getCarbsKCAL() {
        return carboHydrate;
    }

    @JsonProperty("CHOCDF_KCAL")
    public void setCarbsKCAL(CHOCDFKCAL cHOCDFKCAL) {
        this.carboHydrate = cHOCDFKCAL;
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
