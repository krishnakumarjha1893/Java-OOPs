package absEncInOOP;

import java.util.Scanner;

public class SavingAccount extends BankAccount {


        //private instance of parent class BankAccount-  AccontNumber; holderName; balance; gender; AccountType


    public void setter(Scanner Sc)
    {
        System.out.println("Enter Your Detail Very Carefully");
        System.out.println("Enter Your Name- ");
        super.setName(Sc.nextLine());
        System.out.println("Enter Your Name- ");
        super.setAccountNumber(AccountNoGenerator.getSavingAccountNo());
        setAccountType("Saving Account Type");
        System.out.println("Enter 1 if you are a mail else pree 2 - ");
        int temp=Sc.nextInt();
        if(temp==1)
        {
            super.setGender('M');
        }
        else{
            super.setGender('F');
        }
        // balance initial update krne ka logic
         boolean turn =true;
         while(turn)
         {
        System.out.println("Enter you first Deposit How much You want to deposit minimum it shoud be 1000");
         double a=Sc.nextInt();
         if(a>=1000)
         {
            super.setBalance(a);
            turn=false;
            break;
         }
        
        }



        

    }
    
}
