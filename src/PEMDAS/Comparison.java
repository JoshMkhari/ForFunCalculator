/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEMDAS;

/**
 * Class dedicated to comparing 2 different characters
 * @author njmkh
 */
public class Comparison {
    
    //Simply compares 2 characters
    
    public static boolean Comp(char UserInput, char Compare){ //The current character from the user input, the comparison character
       String UserI,Comp;
       
       UserI = String.valueOf(UserInput);
       Comp = String.valueOf(Compare);
        return UserI.equals(Comp); // Determines if the characters are the same
    }
}
