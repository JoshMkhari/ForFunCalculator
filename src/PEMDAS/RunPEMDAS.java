/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEMDAS;

import static PEMDAS.DoingMath.Exp;
import java.util.Scanner;


/**
 *
 * @author njmkh
 */

public class RunPEMDAS {
    public static String Equation;

    
    public static void main(String[] args){
    System.out.println("Enter an Equation"); 
        //System.out.println(Test.substring(0, 4) + "x" + Test.substring(4,Test.length()));
        
    String Expression;
    //Stores equation in the Equation variable
    Scanner s1 = new Scanner(System.in);
    Equation = s1.nextLine();
    
   // initializing arrays before first use
    
     //Calls the Parameter method to count brackets and organise the equation
     Parentheses P1 = new Parentheses();


        Expression =P1.Parameter(Equation);



    //String Answer = DoingMath.Operators(Expression);
    System.out.println( "Answer is " + DoingMath.Operators(Expression));
    }
}
