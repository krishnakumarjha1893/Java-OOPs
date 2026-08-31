package absEncInOOP;
import java.util.HashMap;
import java.util.Scanner;
//ye mera main bussiness logic ke liye bnaya gya class hai
public class Bank {
public static void main(String[] args)
{

    HashMap <String,CurrentAccount> cur=new HashMap<>();
    HashMap <String,SavingAccount> sav=new HashMap<>();

        Scanner Sc=new Scanner(System.in);


        System.out.println("Welocme to the Bank of Banaras ! A bank that is Under development so please be careful and type Any Integer Between [1,6] ,If you press other key then you are just a evil Human bieng now let's Start Enter 1 for Opening Saving Account,Enter 2 for Opening Current Account,Enter 3 for Balance Check,Enter 4 for Deposite Money,Enter 5 for Credit money,Enter 6 for viewing Passbok- ");
        
        int imput=Sc.nextInt();

        //case 1 jb user option 1 chunega to mai saving account khol rha hun

       if(imput==1)
       {
            SavingAccount s1=new SavingAccount();
            //here i have two way either i can pass user details through cunstoctor aur via setter method i will prefer second one because in second method i can take value one by one and also can assist our user by printing userchoice ...
            s1.setter(Sc);
            //ab sab set hogaya value to esko account number ke long map me pair kr lete hain so that future me dekhna retrieve krna data through account number eassy rhe
            sav.put(s1.getAccountNo(), s1);

       }

       //case 2 jb user option 2 chunega to mai current account khol rha hun

      else if(imput==2)
       {
             CurrentAccount c1=new CurrentAccount();
            //here i have two way either i can pass user details through cunstoctor aur via setter method i will prefer second one because in second method i can take value one by one and also can assist our user by printing userchoice ...
            c1.setter(Sc);
            //ab sab set hogaya value to esko account number ke long map me pair kr lete hain so that future me dekhna retrieve krna data through account number eassy rhe
            cur.put(c1.getAccountNo(), c1);

       }

       //case 3 jb user option 3 chunega to mai Balance check kr rha hun

     else  if(imput==3)
       {
        //dekho yhan main user ko asli azadi de rha hun "Any key " but is azadi ki sart hai user etna samjhe ki saving account ke liye strictly s hi option hai unke pass.
         System.out.println("Prees 's' if your Account Type id Saving else Press any key ");
         char c=Sc.next().charAt(0);

         // ab ham user ke account ka nature jan chuke hain so aage dono case ko case 1 case2 bna ke sepreately deal krte hain 
         //case 1 jab user kehta uska account Saving account hai
         if(c=='s')
         {
            System.out.println("Enter Your Account Number - ");
            String temp=Sc.next();
            SavingAccount s=sav.get(temp);
            if(s!=null)
            {
                System.out.println("Your Balance is - " +s.getBalance());
            }
           else
           {
            System.out.println("User Not Found .");
           }

         }
         else
            {
            System.out.println("Enter Your Account Number - ");
            String temp=Sc.next();
            CurrentAccount s=cur.get(temp);
            if(s!=null)
            {
                System.out.println("Your Balance is - " +s.getBalance());
            }
           else
           {
            System.out.println("User Not Found .");
           }

         }

       }

     //case 4 jab user paisa jama kr rha hoga , uska logiC niche bnaya hun

else if(imput==4)
    {
             //dekho yhan main user ko asli azadi de rha hun "Any key " but is azadi ki sart hai user etna samjhe ki saving account ke liye strictly s hi option hai unke pass.
         System.out.println("Prees 's' if your Account Type id Saving else Press any key ");
         char c=Sc.next().charAt(0);

         // ab ham user ke account ka nature jan chuke hain so aage dono case ko case 1 case2 bna ke sepreately deal krte hain 
         //case 1 jab user kehta uska account Saving account hai
         if(c=='s')
         {
            System.out.println("Enter Your Account Number - ");
            String temp=Sc.next();
            SavingAccount s=sav.get(temp);
            if(s!=null)
            {
                System.out.println("Enter how much money you want to Deposite in the Indias gretest Bank i.e Bank Of Banaras !");

                double tempimput=Sc.nextDouble();
                s.addBalance(tempimput);
                System.out.println("Your Now Overall Balance is - " +s.getBalance());
                if(s.isMale())
                System.out.println("Bank of Banaras have very proud on You Ms."+s.getName());
                else
                {
                   System.out.println("Bank of Banaras have very proud on You Mr."+s.getName());
                 
                }
            }
           else
           {
            System.out.println("User Not Found .");
           }

         }
         else
            {
            System.out.println("Enter How  ");
            String temp=Sc.next();
            CurrentAccount s=cur.get(temp);
            if(s!=null)
            {
                System.out.println("Your Balance is - " +s.getBalance());
            }
           else
           {
            System.out.println("User Not Found .");
           }
        }

    }


//case 5  Withdra ka logic
else if(imput==5)
{
      System.out.println("Enter 1 for Saving Account and 2 for current Account");
     int a=Sc.nextInt();
     System.out.println("Enter Account Number- ");
     String st=Sc.next();
     System.out.println("Enter How much money you want to withdraw- ");
     double amnt=Sc.nextDouble();
     if((a==1) && (sav.containsKey(st)))
     {
            sav.get(st).withdraw(amnt);
     }
     else if((a==2) && (cur.containsKey(st)))
     {
            cur.get(st).withdraw(amnt);
     }
     else
     {
        System.out.println("User Not found....");
     }
}


//case 6 viewing PassBook ka logic

else if(imput==6)
{

     System.out.println("Enter 1 for Saving Account and 2 for current Account");
     int a=Sc.nextInt();
     System.out.println("Enter Account Number- ");
     String st=Sc.next();
     if((a==1) && (sav.containsKey(st)))
     {
            sav.get(st).passBook();
     }
     else if((a==2) && (cur.containsKey(st)))
     {
            cur.get(st).passBook();
     }
     else
     {
        System.out.println("User Not found....");
     }

}





        Sc.close();


}
    
}
