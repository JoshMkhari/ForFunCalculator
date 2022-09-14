/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEMDAS;

/**
 *This class is dedicated to reading data from left to right within an equation 
 * determining if multiplication or division is to be done 
 * adding/subtracting integers
 * @author njmkh
 */
public class DoingMath {
    static String Input;
     static String UpdatedOutput;
     static boolean lNegNum;
    static boolean rNegNum ; 
    static int charLeft, charRight, countWhile = 0;
    static double Answer = 0;
    static String sLeft;
    static  String sRight;
     static char arrOperators[] = new char[]{'*','/','+','-'};
     static int LocForAns,end, count;
     static boolean working = true;
    
    public static String Operators(String Expression){
        Input = Expression;// Retrieves the Complete bracket 8+4+6
        initialize();
        //check for exponents first
        PE();
        Md();
        As();
       return Input;
    }
    static void PE(){
   working = true;
     while(working)
      {
          if(Validate.Exp[0] != 0) //and if we have 0 divisions to perform , then no need for comparison.
            {
                //we do multiplication at the firstfound instance of multiplication 
                getNums(Validate.Exp[1]);
                Exp();
            }
          else
              working = false;
      }
              
    }
    static void Md(){
   working = true;
     while(working)
      {
       if(Validate.Multip[0] !=0) // if we have atleast one multiplication
        {
            if(Validate.Div[0] == 0) //and if we have 0 divisions to perform , then no need for comparison.
            {
                //we do multiplication at the firstfound instance of multiplication 
                getNums(Validate.Multip[1]);
                Multip();
            }
            else
                //we need to compare wish to do first
                if(Validate.Div[1] > Validate.Multip[1])
                {
                    getNums(Validate.Multip[1]); // do the multiplication on the earliest multip
                    Multip();
                }
            else
                {
                    getNums(Validate.Div[1]); // do the division on the earliest div
                    Div();
                }
        }
       else
           {if(Validate.Div[0] != 0)
           {
               getNums(Validate.Div[1]); // do the first division
               Div();
           }
           else
               working =false;
           }
      }
    }
    static void As(){
        working = true;
        //System.out.println(Validate.Sub[0]);
        while(working)
      {
          //System.out.println("within while ");
      if(Validate.Add[0] != 0)
      {
          if(Validate.Sub[0] == 0)
          {
              getNums(Validate.Add[1]);
              Add();
          }
          else
              if (Validate.Sub[1]> Validate.Add[1])
              {
                  getNums(Validate.Add[1]);
                  Add();
              }
          else
              {
                  getNums(Validate.Sub[1]);
                  Sub();
              }
      }
      else
      {
          if(Validate.Sub[0] != 0)
          {
          getNums(Validate.Sub[1]);
          Sub();
          }
          else
              working = false;
      }
      }
    }
    static void Exp(){
          
       if(Validate.Exp[0] !=0) // if we have atleast one exponent
        {
           double iRight = Double.parseDouble(sRight);
                   double iLeft = Double.parseDouble(sLeft);
                   Answer = Double.parseDouble(sLeft);
                   
                  for (int i = 1; i < iRight; i++) { //0,1,2,3
                      Answer = Answer*iLeft;
                    }
                
               if (lNegNum && rNegNum)
                    updateInput(false);    
                else if(!lNegNum && !rNegNum)
                    updateInput(false);
                else
                {
                    updateInput(true);
                }  
 
      }
    }
    static void Multip(){
        double iRight = Double.parseDouble(sRight); // iRight +2, iLeft +6

                   double iLeft = Double.parseDouble(sLeft);
                   Answer = iLeft*iRight; //Answer = 12
                
               int count =1;
               if (lNegNum && rNegNum)
                    updateInput(false);    
                else if(!lNegNum && !rNegNum)
                    updateInput(false);
                else
                {
                    updateInput(true);
                }
        
    }
    
    static void Div(){
       double iRight = Double.parseDouble(sRight); // iRight +2, iLeft +6
                {
                   double iLeft = Double.parseDouble(sLeft);
                   Answer = iLeft/iRight; //Answer = 12
                }
                
               if (lNegNum && rNegNum)
                    updateInput(false);    
                else if(!lNegNum && !rNegNum)
                    updateInput(false);
                else
                    updateInput(true);      
    }
        
    static void Add(
    ){ 
        double iRight = Double.parseDouble(sRight);
                double iLeft = Double.parseDouble(sLeft);
                if (lNegNum && rNegNum){
                        Answer = iLeft + iRight;
                        updateInput(true);
                    }
                    else if (lNegNum)
                    {
                        if (iLeft>iRight)
                        {
                            Answer = iLeft-iRight;
                            updateInput(true);
                        }
                        else 
                        {
                            Answer = iRight - iLeft;
                            updateInput(false);
                        }
                    }else if(rNegNum)
                    {
                        if (iRight>iLeft)
                        {
                            Answer = iRight - iLeft;
                            updateInput(true);
                        }
                        else
                        {
                            Answer = iLeft-iRight;
                            updateInput(false);                            
                        }
                    }else 
                    {
                        Answer = iLeft + iRight;
                        updateInput(false);
                    }
            
                    
    }
    static void Sub(){
            double iLeft = Double.parseDouble(sLeft);
                double iRight = Double.parseDouble(sRight);
                if (lNegNum && rNegNum){
                        if (iLeft>iRight)
                        {
                            Answer = iLeft-iRight;
                            updateInput(true);
                        }
                        else 
                        {
                            Answer = iRight - iLeft;
                            updateInput(false);
                        }
                    }
                    else if (lNegNum)
                    {
                            Answer = iLeft+iRight;
                            updateInput(true);
      
                    }else if(rNegNum)
                    {
                            Answer = iLeft+iRight;
                            updateInput(false);
                    }else if(iLeft>iRight)  
                    {
                        Answer = iLeft - iRight;
                        updateInput(false);
                    }else
                    {
                        Answer = iRight - iLeft;
                        updateInput(true);
                    }
                
        
    }
    // retrieves integers on the left and right of an operator
    public static void getNums(int Loc){
        int count = 1; // keeps track of distance from operator
        boolean looking = true; // stops while loop when false
        sRight = "";
        sLeft = "";
        lNegNum = false;
        rNegNum = false;
        
        //System.out.println("Loc in get nums is " + Loc);
       while(looking){// searching for integers on the left of operator
        if (Validate.checkInt(Input.charAt(Loc-count))) // checks if char on left of operator is an integer
            {
                sLeft = Input.charAt(Loc-count) + sLeft; // stores innteger in left string
                LocForAns = Loc-count;
                //System.out.println(sLeft);
                count++; 
                
                if ((Loc-count)<0)
                {
                   looking =false;// increases counter
                   
                }
            }
        else    
        {
            if (Comparison.Comp(Input.charAt(Loc-count), '-'))
            {
                if (Parentheses.seenNum)
                {
                    lNegNum = true;
                    LocForAns = Loc-count;
                    count++;
                }
                
            }               
        looking = false;
        }
    }

        count = 1;// reseting count for search on right
       looking = true;
       Parentheses.seenNum = false;
            if (Comparison.Comp(Input.charAt(Loc+count), '-'))
            {
                    rNegNum = true;
                    end = Loc +count;
                    count++;  
                }
     
            while(looking){ 
                if (Validate.checkInt(Input.charAt(Loc+count)))
                    {
                sRight = sRight + Input.charAt(Loc+count);
                end = Loc+count;
                count++;
                if ((Loc+count)>=Input.length())
                                {
                                    looking = false;
                                 }
                    }
                else{
                    looking = false;
                    }
                }
}
    static void initialize(){
  int count = 0;
    Validate.Multip[0] = 0;
    Validate.Div[0] = 0;
    Validate.Add[0] =0;
    Validate.Sub[0] = 0;
    Validate.Exp[0] =0;
    
        while(count<(Input.length()-1))
        {
            Validate.checkOperator(Input.charAt(count),count);
            count++;
            Parentheses.seenNum = true;
                
        }
    }

    
    public static void updateInput(boolean negative){
        String newInput;
        UpdatedOutput ="";
        if (negative)
        UpdatedOutput = UpdatedOutput + "-" + (Answer);
        
        else
             UpdatedOutput = UpdatedOutput + (Answer);//UpdatedOutput = 6;
        
        //;
        if (((end+1) == Input.length())) {
            {
            Input = Input.substring(0, (LocForAns)) +  UpdatedOutput;
            }
        }
        else
        {
        Input = Input.substring(0, (LocForAns)) + UpdatedOutput + Input.substring((end+1) ,Input.length());
        }
        
        //updating operators table for Input
    initialize();
        //System.out.println("after Initialize" + Input);
    }
    
}