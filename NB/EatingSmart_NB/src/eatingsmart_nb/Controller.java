package eatingsmart_nb;

import Models.Nutrients;

public class Controller {

    IRepo repo;
    API api;

    public Controller(IRepo repo, API api) {
        this.repo = repo;
        this.api = api;

    }

    public Nutrients queryData(String search) {

        Nutrients nutr = repo.getData(search.toLowerCase());

        if (nutr == null) {

            System.out.println("************DATA FROM API**********");
            //No from db? Lets try from API
            nutr = this.api.getNutrients(search.toLowerCase());
            //DELETE OLD DATA FROM DB
            repo.deleteData(search.toLowerCase());

            //INSERT FRESH DATA
            repo.insertData(search.toLowerCase(), nutr.getMainNutrientsGramms(), nutr.getMainNutrientsDaily(), nutr.getCalories());

        }

        return nutr;
    }

}
