package absEncInOOP;

import java.util.Scanner;

public class CurrentAccount extends BankAccount {



    //private instance of parent class BankAccount -> AccontNumber; holderName; balance; gender; AccountType
    //chuki ye current account hai es liye bank of Banaras overdraft limit v provide krta j ki 10000 hai;
    final static double OverDraftLimit=10000;


    public void setter(Scanner Sc)
    {
        System.out.println("Enter Your Detail Very Carefully");
        System.out.println("Enter Your Name- ");
        super.setName(Sc.nextLine());
        super.setAccountNumber(AccountNoGenerator.getCurrentAccountNo());
        setAccountType("Current Account Type");
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

        //widram methode ko override krna hai

public void withdraw(double amnt)
{
    if((this.getBalance()+OverDraftLimit)>=amnt){

        this.setBalance(this.getBalance()-amnt);
    }
    else 
    {
        System.out.println("Your over Draft Limit is 10 K and Your balance is low i.e " +this.getBalance() +"so enter according to it ");
    }
}

//view passbok ke liye passbook na ka methode bnate han dno e saving and current me

public void passBook()
{
    System.out.println("Name - "+this.getName());
    System.out.println("Gender - "+this.getGender());
    System.out.println("Account Type - "+this.GetAccountType());
    System.out.println("Acccount Number - "+this.getAccountNo());
    System.out.println("Balance -  "+this.getBalance());

}

        

    }











    

