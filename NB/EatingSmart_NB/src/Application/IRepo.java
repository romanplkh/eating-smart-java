/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Model.NutrientsCollection;


/**
 * @exercise Final Project
 * @author Roman Pelikh
 * @date 2019-11-16
 */
public interface IRepo {

    public NutrientsCollection getNutrients(String srch);

    public boolean deleteItem(String srch);

    public void insertNutrients(String search, NutrientsCollection nutrients);

}
