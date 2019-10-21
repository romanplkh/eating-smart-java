import Models.MainNutrients;

import java.util.HashMap;

public class Controller {

    //Controller will be retrieve data from DB or API

    //!FROM DB
    //STORE each tipe of values from DB to Map as JSON string
    HashMap<String, String> foundInDB = new HashMap<>();

    //MAP THIS DATA TO MODELS AND RETURN MODELS
    HashMap<String, MainNutrients> setOfAllNutirents = new HashMap<>();


    

    //!FROM API
    HashMap<String, String> foundInAPI = new HashMap<>();
    HashMap<String, MainNutrients> setOfAllNutirents2 = new HashMap<>();
}
