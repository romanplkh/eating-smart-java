/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 * @exercise Final Project
 * @author Roman Pelikh
 * @date 2019-11-16
 */

/**
 * Custom error provider to handle errors
 */
public class ErrorProvider {
    private String description;
/**
 * Constructor for provider to add custom errors
 * @param description description of error
 */
    public ErrorProvider(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
