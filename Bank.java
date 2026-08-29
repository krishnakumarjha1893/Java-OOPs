import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    
 private static Map<String, Customer> customers = new HashMap<>();
    private static Map<String, Employee> employees = new HashMap<>();

public static void main(String[] args) {
    
Scanner Sc=new Scanner(System.in);

System.out.println("Welcome to Bank of Banaras !");
System.out.println("Enter 1 if You are a Customer");
System.out.println("Enter 2 if You are a Employee");
System.out.println("Enter 3 if You want Detail of Employee or Customer by Unique ID");
int nature;
nature=Sc.nextInt();

boolean roll_back=true;
while(roll_back)
{
     if(nature==1)
     {
             Customer c1=new Customer();
             c1.setter(Sc);
             customers.put(c1.getId(), c1);

             System.out.println("Welcome Mr/Ms "+c1.name+" to Bank of Banaras Your ID is "+c1.id);







roll_back=false;
     }
  

    else if(nature==2)
    {

Employee c1=new Employee();
             c1.setter(Sc);
             employees.put(c1.getId(), c1);

 System.out.println("Welcome Mr/Ms "+c1.name+" to Bank of Banaras Your ID is "+c1.id);  
roll_back=false;
    }


    else if(nature==3)
    {
                

        System.out.println("Enter Id for Serch -");
        String idid=Sc.next();
        Customer obj1 = customers.get(idid);
        Employee obj2 = employees.get(idid);
        if (obj1 != null){
            obj1.getter();
        }
        else if(obj2 != null){
            obj2.getter();
        }
        else{
            System.out.println("Enter cporrect Id in next Life....");
        }
        roll_back = false;

    }
  else
  {
    System.out.println("Enter valid Integer i.e either 1 or 2 or 3");
    nature=Sc.nextInt();
    roll_back=true;

  }




}







Sc.close();


}



}




//ID ko alag se deal kr leta hun
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


/**
 * Customer
 */
 class Customer {
int age;
String name;
String AccType;
char gender;
String id;


public String getId()
{
    return this.id;
}


public void setter(Scanner Sc){
   this.id = IdGenerator.generateCustomerId();
   System.out.println("Plese Enter Customer detail carefully:- ");
   System.out.println("Enter Name - ");
   this.name=Sc.next();
   System.out.println("Enter Sex(\"M as Male and F as Female\") -");   
   this.gender=Sc.next().charAt(0);
   System.out.println("Enter Your Age -  ");
   this.age=Sc.nextInt();
   System.out.println("Account Type ? (pres \"s\" for Saving Account And \"c\" for current Account - ");
  char cr= Sc.next().charAt(0);
  if(cr=='s')
  {
this.AccType="Saving Account";
  }
else if(cr=='c'){
this.AccType="Current Account";
}
else {
    this.AccType="mc Accont generated as you enter neither s nor c so ....and mc stand for mad customer";
}


}


public void getter()
{
                  System.out.println("Name of Customer is "+ this.name);
                  System.out.println("Age is "+ this.age);
                  System.out.println("Gender - "+this.gender);
                  System.out.println("Account Type- "+this.AccType);
                   System.out.println("Id is "+ this.id);
}

    
}


class Employee{

    int age;
    String name;
    char gender;
    String id;

    public String getId()
{
    return this.id;
}



public void setter(Scanner Sc){


   System.out.println("Plese Enter Employee detail carefully:- ");
   System.out.println("Enter Name - ");
   this.name=Sc.next();
   System.out.println("Enter Sex(\"M as Male and F as Female\") -");   
   this.gender=Sc.next().charAt(0);
   System.out.println("Enter Your Age -  ");
   this.age=Sc.nextInt();
    this.id = IdGenerator.generateEmployeeId();
   
}

public void getter()
{
                  System.out.println("Name of Employee is "+ this.name);
                  System.out.println("Age is "+ this.age);
                  System.out.println("Gender - "+this.gender);
                   System.out.println("Id is "+ this.id);
}

}






