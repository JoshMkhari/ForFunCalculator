/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEMDAS;

/**
 *Class dedicated to ensuring only numbers and operators are being used
 * @author njmkh
 */
public class Validate {
    //[0] stores number of operators found [1->4]stores locations of type[*/+-] operator in a bracket
    public static int[] Multip = new int[5]; 
    public static int[] Div = new int[5];
    public static int[] Add = new int[5];
    public static int[] Sub = new int[5];
    public static int[] Exp = new int[5];
    public static int populated = 0;
    public static int simple = 0;
    // ensures the current character is an integer between 0-9
    public static boolean checkInt(char Check){
            String integers = "0123456789.";
        for ( int num=0; num < 11; num++){
            if (Comparison.Comp(Check, integers.charAt(num)))
            {
             Parentheses.seenNum = true;
             return true; 
            }
        }
        return false;
    }
    // ensures the current character is a mathematical operator    
    public static boolean checkOperator(char Check, int Loc){
        String Operators = "*/+-^";
               if (Comparison.Comp(Check, Operators.charAt(0)))
               {
                     Multip[0] = Multip[0] + 1;
                     Multip[Multip[0]] = Loc; 
                     Parentheses.seenNum = false;
                     return true;
               }
               else if (Comparison.Comp(Check, Operators.charAt(1)))
               {
                   Div[0]= Div[0] +1;
                   Div[Div[0]] = Loc;
                   Parentheses.seenNum = false;
                   return true;
               }
               else if (Comparison.Comp(Check, Operators.charAt(2)))
               {
                   {  
                   Add[0] = Add[0] +1;
                   Add[Add[0]] = Loc;
                   Parentheses.seenNum = false;
                   return true;
                   }
               }
               else if (Comparison.Comp(Check, Operators.charAt(3)))
               {
                   if(Parentheses.seenNum && (Loc!=0))
                   {
                    Sub[0] = Sub[0]+1;
                    Sub[Sub[0]] = Loc;
                    Parentheses.seenNum = false;
                    return true;
                   }
                   
               }
               else if(Comparison.Comp(Check, Operators.charAt(4)))
                   {
                       Exp[0] = Exp[0]+1;
                       Exp[Exp[0]] = Loc;
                       Parentheses.seenNum = false;
                       return true;
                   }
      return false;        
    }
}
