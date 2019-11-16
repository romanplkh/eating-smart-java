/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eatingsmart_nb;

import Model.NutrientsCollection;


/**
 *
 * @author Roman
 */
public interface IRepo {

    public NutrientsCollection getNutrients(String srch);

    public boolean deleteItem(String srch);

    public void insertNutrients(String search, NutrientsCollection nutrients);

}
