package eatingsmart_nb;

import Model.NutrientsCollection;
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
        this.errors.clear();
        NutrientsCollection nutr = null;
        //FROM DB
        try {

            String srchDB = Helpers.FormatStringSearch(search.toLowerCase());
            
            //SEARCH FIRST IN DATABASE
            nutr = repo.getData(srchDB);

            if (nutr == null) {

                System.out.println("************DATA FROM API**********");
                //No from db? Lets try from API
                nutr = this.api.getNutrients(search.toLowerCase());

                if (nutr == null) {
                    errors.clear();
                    errors.add(new ErrorProvider("We had a problem analysing this. "
                            + "Please check the ingredient spelling or if you have entered a quantities for the ingredients."));
                } else {
                    //DELETE OLD DATA FROM DB
                    repo.deleteData(srchDB);

                    //INSERT FRESH DATA
                    repo.insertData(srchDB, nutr);
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return nutr;

    }

}
