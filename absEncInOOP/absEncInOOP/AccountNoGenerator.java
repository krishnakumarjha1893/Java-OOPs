package absEncInOOP;

public class AccountNoGenerator {
    

    private static int cInitialCounter=1000;
    private static int sInitialCounter=2000;
//for geting currentAccount Number we use this method and due to stattic nature i can easily call him without makg any object
   protected static String getCurrentAccountNo()
    {
            cInitialCounter++;   
             return "CUR"+cInitialCounter;
            
    }

     protected static String getSavingAccountNo()
    {
             sInitialCounter++;
             return "SAV"+sInitialCounter;
            
    }



}
