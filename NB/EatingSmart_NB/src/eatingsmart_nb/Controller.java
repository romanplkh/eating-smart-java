package eatingsmart_nb;

import Model2.NutrientsCollection;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private IRepo repo;
    private API api;
    private List<ErrorProvider> errors = new ArrayList<>();

    public List<ErrorProvider> getErrors() {
        return errors;
    }

    public Controller(IRepo repo, API api) {
        this.repo = repo;
        this.api = api;

    }

    public NutrientsCollection queryData(String search) {

        //Nutrients nutr = null;
        NutrientsCollection nutr = null;
        //FROM DB
        try {
            
       
           nutr = repo.getData(search.toLowerCase());

            if (nutr == null) {

                System.out.println("************DATA FROM API**********");
                //No from db? Lets try from API
                nutr = this.api.getNutrients(search.toLowerCase());

                if (nutr.getTotalNutrients().getEnergy()!= null) {
                    //DELETE OLD DATA FROM DB
                    repo.deleteData(search.toLowerCase());

                    //INSERT FRESH DATA
                    repo.insertData(search.toLowerCase(), nutr);
                }

              

            }

        } catch (Exception e) {
            errors.add(new ErrorProvider(e.getMessage()));
        }
        
          return nutr;

    }

}
