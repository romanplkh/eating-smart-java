/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eatingsmart_nb;

import Models.Nutrients;

/**
 *
 * @author Roman
 */
public interface IRepo {

    public Nutrients getData(String srch);

    public boolean deleteData(String srch);

    public void insertData(String search, Nutrients nutrients);

}
