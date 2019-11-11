package Model;




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
    "FAT",
    "FASAT",
    "FAMS",
    "FAPU",
    "CHOCDF",
    "FIBTG",
    "SUGAR",
    "PROCNT"
})
public class TotalNutrients {

    @JsonProperty("ENERC_KCAL")
    private ENERCKCAL energy;
    @JsonProperty("FAT")
    private FAT fat;
    @JsonProperty("FASAT")
    private FASAT fatSaturated;
    @JsonProperty("FAMS")
    private FAMS fatMonoSaturated;
    @JsonProperty("FAPU")
    private FAPU fatPolySaturated;
    @JsonProperty("CHOCDF")
    private CHOCDF carboHydrates;
    @JsonProperty("FIBTG")
    private FIBTG fiber;
    @JsonProperty("SUGAR")
    private SUGAR sugar;
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
    public void sewStauratedFat(FASAT fASAT) {
        this.fatSaturated = fASAT;
    }

    @JsonProperty("FAMS")
    public FAMS getMonostaturatedFat() {
        return fatMonoSaturated;
    }

    @JsonProperty("FAMS")
    public void setMonostaturatedFat(FAMS fAMS) {
        this.fatMonoSaturated = fAMS;
    }

    @JsonProperty("FAPU")
    public FAPU getFatPolySaturated() {
        return fatPolySaturated;
    }

    @JsonProperty("FAPU")
    public void setFatPolySaturated(FAPU fAPU) {
        this.fatPolySaturated = fAPU;
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

    @JsonProperty("SUGAR")
    public SUGAR getSUGAR() {
        return sugar;
    }

    @JsonProperty("SUGAR")
    public void setSUGAR(SUGAR sUGAR) {
        this.sugar = sUGAR;
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
