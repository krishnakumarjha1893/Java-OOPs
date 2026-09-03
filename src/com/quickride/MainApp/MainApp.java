package com.quickride.MainApp;

import java.util.Scanner;

public class MainApp {


    public static void main(String [] args){
        
        Scanner Sc=new Scanner(System.in);

//phle admin hai ya user ek confirm kr lete hain fir dono case ko sepretey deal krte hain 
//       1. Add Vehicle to Fleet     │             │ 1. Register / Create User   │
// │ 2. View All Fleet (All)     │             │ 2. View Available Vehicles  │
// │ 3. Remove/Update Vehicle    │             │ 3. Book a Ride              │
// │ 4. View System All Bookings │             │ 4. Complete Ongoing Ride    │
// │ 5. Back to Main Menu
    System.out.println("Enter 1 If You Are A Admmin Else Press 2 ");
    System.out.println("Enter any Integer except 1,2 for Exit...");
    int first_input=Sc.nextInt();
    //case 1 if Person is Admin or first_input ==1 
    if(first_input==1)
    {
          System.out.println(" 1. Add Vehicle to Fleet  ");
          System.out.println("View All Fleet (All) ");
          System.out.println("Remove/Update Vehicle ");
          System.out.println(" 4. View System All Bookings");
          System.out.println("5. Back to Main Menu ");
          int second_input=Sc.nextInt();
      //agar admin option 1 chune matlb he wants to add bike car auto;
               if(second_input==1)
               {
                    System.out.println("Select Nature of Vehicle Mr. Admin!");
                    System.out.println("Press 1 If Bike .");
                    System.out.println("Press 2 If Auto .");
                    System.out.println("Press 3 If Car .");
                    int third_input=Sc.nextInt();//yye input btayega ki gadi o orna hai platform pe wo car hai ya auto ya Bike
                               if(third_input==1)//Bike add
                               {
                                    




                               }
                               else if(third_input==2)//auto add
                               {




                               }
                               else if(third_input==3)//car add
                               {




                                
                               }

               }
               else if(second_input==2)
               {
                
               }
               else if(second_input==3)
               {
                
               }
               else if(second_input==4)
               {
                
               }
               else if(second_input==5)
               {
                
               }
      
          


    }
    //case 2 ab Person Customer ho ride book krne ko aaya ho
    else if(first_input==2)
    {
          System.out.println("1. Register / Create User ");
          System.out.println("2. View Available Vehicles ");
          System.out.println("3. Book a Ride ");
          System.out.println("4. Complete Ongoing Ride  ");
          int second_input=Sc.nextInt();


    }
    
//case 3hai ab ham chah rhe user 1 2 ko chhod ke kuchh v dbaye taki wo exit ho sake
    else
    {
    System.out.println(" You are Succssfully Exited from Our System...Thankyou for Using QuickRide !");
    }

    









































Sc.close();
    }
    
}
