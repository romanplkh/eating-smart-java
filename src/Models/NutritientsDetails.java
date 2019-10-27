package Models;

import java.text.NumberFormat;

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
        NumberFormat num = NumberFormat.getNumberInstance();
        num.setMaximumFractionDigits(2);
        this.quantity = Double.parseDouble(num.format(quantity));
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public NutritientsDetails(String label, double quantity, String unit) {
        setLabel(label);
        setQuantity(quantity);
        setUnit(unit);
    }


}
