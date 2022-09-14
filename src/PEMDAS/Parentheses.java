/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEMDAS;

/**
 *This class is dedicated to finding parameters within an equation 
 * It finds parameters and organizes them in order for the computer to 
 * perform math using the rules of PEMDAS
 * @author njmkh
 */
public class Parentheses {
    public static int currChar; // Keeps track of the current character
    public static int BracCount; // Keeps track of the number of brackers
    String UpdatedInput;
    boolean outBrac = true;
    public static boolean seenNum = false;
    public static int OpLoc;
    int[] OpenBrac = new int[5]; // stores location of every (
    int[] CloseBrac = new int[5]; // stores location of every )
    public static String[] BracMath = new String[5]; // stores locatiion of data within brackets ( all of this )
    String Output; // stores placeholders for values to be worked out
    String AnswersFound = "";
    String[] Answers = new String[5]; // stores location of every answer in the original string
    String Input;
    int[] LocForAns = new int[5];
    public static boolean done = false;
    
    // Finds parameters for calculations
    String Parameter(String UserInput){
        BracCount =0;
        UpdatedInput = "";
         Input = UserInput;
        Output = "";
        int Trrack = 0;
        for ( currChar=0; currChar < (Input.length()); currChar++) 
            /*
            Repeat for length of the sum, int counter is used to keep track of
            the current character used in comparisons
            */
        {
            /*
            Calling the comparison method with the current character (1st parameter) and the
            Character to compare it to(2nd Parameter)
            */
            if (Comparison.Comp(Input.charAt(currChar),'(')) // if the current character is (
            {
                BracCount++;
                OpenBrac[BracCount] = currChar; // Stores location of the (
                 // Now program knows there is a bracket to calculate

                 LocForAns[BracCount] = UpdatedInput.length();
              //  outBrac = false; // determines if we inside or outside a bracket
            }
            else
                if  (Comparison.Comp(Input.charAt(currChar),')')) //if the current character is )   
                    {
                    CloseBrac[BracCount] = currChar; // Stores location of the )
                    
                    Complete(OpenBrac[(BracCount)],CloseBrac[BracCount],Input);
                    
                    //instead of storing answers in answers found. lets update the input witht he answer in the relative location
                    //DoingMath.Operators(BracMath[BracCount]) returns 16
                    // updatedInput = copy old updatedinput up to where we are
                    //maybe we call the organise mtheod here
                    Organise(OpenBrac[BracCount],CloseBrac[BracCount]);
                    done = false;
                    BracCount--;
                    break;          
                    //System.out.println(Output + " this is answer?");
                    
                    }
                    else
                        UpdatedInput = UpdatedInput + Input.charAt(currChar);
            Trrack = currChar;
        }
        if (BracCount == 0)
        {
       return UpdatedInput;
        }
        else
            return UpdatedInput;
    }
    
    // Takes the location of correspong ( and ) brackets and stores all charachters between them, should use get method lol
    void Complete (int Open, int Close,String Expression){
        String Complete = ""; // Stores the data within brackets
        //This for loop, checks if each character is a number or operator or another bracket
        OpLoc = 0;
    Validate.Multip[0] = 0;
    Validate.Div[0] = 0;
    Validate.Add[0] =0;
    Validate.Sub[0] = 0;
        for ( int count=(Open+1); count < (Close); count++)  // repeats between the opening and closing brackets
        { 
            if (Comparison.Comp(Expression.charAt(count),'(')) // we find a (, skip to the corresponding)+1 the count  
            {
                count = CloseBrac[(BracCount+1)]; // ensures the counter skips over a bracket
            }
            else if (Validate.checkInt(Expression.charAt(count))) //checks if the current character is an integer
                {
                    seenNum = true;
                    Complete = Complete + Expression.charAt(count); // stores the number 
                }
                    else if (Validate.checkOperator(Expression.charAt(count),OpLoc))
                    {
                        
                        Complete = Complete + Expression.charAt(count); // stores the operator
                    }
                      //OpLoc = count;
                OpLoc ++;
                
        }   
         BracMath[BracCount] = Complete;
 
                //return Complete; // Store the data within brackets to brackets in the array 
        // we answer the math within the bracket         
        }
    
    // retrieves answers for paramethers and places them in the original sum
    void Organise (int Open, int Close){
            int stop = 0;
            if (Comparison.Comp(Input.charAt(Input.length()-1),')'))
                stop = Input.length()-1;
            else
                stop = Input.length();
            String Old, Answer;

                Old = Input.substring(0, Open);
                Answer = DoingMath.Operators(BracMath[BracCount]);

                if(Open !=0 && Comparison.Comp(Input.charAt(Open),'(') && !Comparison.Comp(Input.charAt(Open-1), '^'))
                        UpdatedInput = Old + '*' + Answer;
                else
                 UpdatedInput = Old + Answer + Input.substring(Close+1);
                Input = UpdatedInput;
                Parameter(Input);
    }
}