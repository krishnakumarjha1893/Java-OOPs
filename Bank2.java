import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * Bank2 is my second inhanced version of Previous Banking Projet idea and this file or class is main or we can say controler class for whole code .
 * 
 * 
 * 
 * 
 */


public class Bank2 {

 static HashMap <String,Customer> c1Map=new HashMap<>();
static HashMap <String,Employee> e1Map=new HashMap<>();

public static void main(String[] args)
{
    Scanner Sc=new Scanner(System.in);
    //ye scanner globaly use kr rhe hm dusre class me v eske reverence pass kr ke use kr le rhe hain kyunki main stream to ek hi hai

    //user ke liye Sabse pahle option bo bna lete hain proper loop ke sath taki wo kabhi v glat kuchh tipe to fir se yhin aa jaye;
    // ek boolean le ke turn lgate hain true false ka with the help of while loop ab khin user badmasi krega comeback ko true kr ke break lga denge;nhi to false kr ke to first sttep pe hi rhe hain loop me

    //Welcome to Bank of Banaras!
//Enter 1 if You are a Customer
//Enter 2 if You are an Employee
//Enter 3 if You want Detail of Employee or Customer by Unique ID


     boolean comeback=true;
     while(comeback)
     {
        comeback=false;
        
        System.out.println("Welcome to Bank of Banaras! ");
System.out.println("****************************************************");
         
System.out.println("Enter 1 if You are a Customer");
System.out.println("Enter 2 if You are an Employee");
System.out.println("Enter 3 if You want Detail of Employee or Customer by Unique ID\r\n" + //
        "");
System.out.println("****************************************************");
int nature=Sc.nextInt();//nature imput store kr rha dost

if(nature==1)
{
     Customer c1=new Customer();
     c1.Setter(Sc);
     c1Map.put(c1.getId(),c1);
     System.out.println("Welcome Mr/Ms "+c1.Name+" to Bank of Banaras Your Unique ID is "+c1.getId());

}
else if(nature==2)
{
     Employee e1=new Employee();
     e1.Setter(Sc);
     e1Map.put(e1.getId(),e1);
     System.out.println("Welcome Mr/Ms "+e1.Name+" to Bank of Banaras Your Unique ID is "+e1.getId());

}
else if(nature==3)
    {

        
     System.out.println("Hey you are Serching whom? press e if Employee or press c if Customer- ");
     char c=Sc.next().charAt(0);
     if(c=='e')
     {
        System.out.println("Hey Enter Employee Unique Id Carrefully So that we can provid You Details...   "); 
        String temp=Sc.next();
         if(e1Map.containsKey(temp)){
            Employee e1=e1Map.get(temp);
            e1.show();

        }
        else{
            System.out.println("Employee not found !");
        }
     }
     else{

        System.out.println("Hey Enter Customer Unique Id Carrefully So that we can provid You Details...  ");
        String temp=Sc.next();
         if(c1Map.containsKey(temp)){
            Customer c1=c1Map.get(temp);
            c1.show();

        }
        else{
            System.out.println("Customer not found !");
        }
     }


    }

else 
{
    comeback=true;
}

     }
     Sc.close();
}
    
}



/**
 * 
 * Customer file Below
 */



class Customer{

   // private name age genger Account Type  Unique Id
private int Age;
private char Gender;
public String Name;
private String AccountType;
private String UniqueId;

 public void Setter(Scanner Sc)
    {
       this.UniqueId = IdGenerator.generateCustomerId();
   System.out.println("Plese Enter Customer detail carefully:- ");
   System.out.println("Enter Name - ");
   this.Name=Sc.next();
   System.out.println("Enter Sex(\"M as Male and F as Female\") -");   
   this.Gender=Sc.next().charAt(0);
   System.out.println("Enter Your Age -  ");
   this.Age=Sc.nextInt();
   System.out.println("Account Type ? (pres \"s\" for Saving Account And \"c\" for current Account - ");
  char cr= Sc.next().charAt(0);
  if(cr=='s')
  {
this.AccountType="Saving Account";
  }
else if(cr=='c'){
this.AccountType="Current Account";
}
else {
    this.AccountType="mc Accont generated as you enter neither s nor c so ....and mc stand for mad customer";
}

    }
 
//get id method for seeing object id and map puting

public String getId()
{
    return this.UniqueId;
}

public void show()
{
                  System.out.println("Name of Customer is "+ this.Name);
                  System.out.println("Age is "+ this.Age);
                  System.out.println("Gender - "+this.Gender);
                  System.out.println("Account Type- "+this.AccountType);
                   System.out.println("Unique Id is "+ this.UniqueId);
}

}

//Name,Age,Gender,Unique ID for employee

/**
 * Employee file Below
 */



 class Employee {

    private int Age;
    private char Gender;
    public String Name;
    private String Designation;
    private String UniqueId;

     public void Setter(Scanner Sc)
    {
       this.UniqueId = IdGenerator.generateEmployeeId();
   System.out.println("Plese Enter Employee detail carefully:- ");
   System.out.println("Enter Name - ");
   this.Name=Sc.next();
   System.out.println("Enter Sex(\"M as Male and F as Female\") -");   
   this.Gender=Sc.next().charAt(0);
   System.out.println("Enter Your Age -  ");
   this.Age=Sc.nextInt();
   System.out.println("Designation/Post - ");
   this.Designation=Sc.next();

    }

public String getId()
{
    return this.UniqueId;
}

public void show()
{
                  System.out.println("Name of Customer is "+ this.Name);
                  System.out.println("Age is "+ this.Age);
                  System.out.println("Gender - "+this.Gender);
                  System.out.println("Account Type- "+this.Designation);
                   System.out.println("Unique Id is "+ this.UniqueId);
                   System.out.println("Designation is "+ this.Designation);
}


}



/**
 * IdGenerator - with the help of this file/class i am gona generate Id for our customer or Employees so that we can retrive data once they register .and gentelman/women my dream is one day i will use database for this work currently i am not capable.
 */


class IdGenerator {

    private static int employeeCounter = 1000;
    private static int customerCounter = 5000;

    public static String generateEmployeeId() {
        employeeCounter++;
        return "EMP" + employeeCounter;
    }

    public static String generateCustomerId() {
        customerCounter++;
        return "CUS" + customerCounter;
    }
}