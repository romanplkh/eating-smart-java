package Application;

import Model.NutrientsCollection;
import java.util.ArrayList;
import java.util.List;



/**
 * @exercise Final Project
 * @author Roman Pelikh
 * @date 2019-11-16
 */
public class Controller {

    private IRepo repo;
    private API api;
    private List<ErrorProvider> errors;

    public List<ErrorProvider> getErrors() {
        return errors;
    }

    
    /**
     * Initializes controller
     * @param repo any repository that implements IRepo interface
     * @param api  API class
     */
    public Controller(IRepo repo, API api) {
        this.repo = repo;
        this.api = api;
        this.errors = new ArrayList<>();

    }

    
    /**
     * Search data in database or makes call to API endpoint
     * @param search ingredient to search
     * @return data mapped against models in NutrientsCollection class
     */
    public NutrientsCollection queryData(String search) {
        this.errors.clear();
        NutrientsCollection nutr = null;
        //FROM DB
        try {

            
            //Format search string to avoid redundant calls
            String srchDB = Helpers.FormatStringSearch(search.toLowerCase());
            
            //SEARCH FIRST IN DATABASE
            nutr = repo.getNutrients(srchDB);

            if (nutr == null) {

                System.out.println("************DATA FROM API**********");
                //No from db? Lets try from API
                nutr = this.api.getNutrients(search.toLowerCase());

                
                //NO DATA => INFROM USER
                if (nutr == null) {
                    errors.clear();
                    errors.add(new ErrorProvider("We had a problem analysing this. "
                            + "Please check the ingredient spelling or if you have entered a quantities for the ingredients."));
                } else {
                    //DELETE OLD DATA FROM DB
                    repo.deleteItem(srchDB);

                    //INSERT FRESH DATA
                    repo.insertNutrients(srchDB, nutr);
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return nutr;

    }

}
