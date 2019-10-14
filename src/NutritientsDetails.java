public class NutritientsDetails {

    public String label;
    public double quantity;
    public String unit;


    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public NutritientsDetails(String label, double quantity, String unit) {
        this.label = label;
        this.quantity = quantity;
        this.unit = unit;
    }


}
