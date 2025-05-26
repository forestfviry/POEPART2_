/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poechecker;
import java.util.Locale;
import java.util.Scanner;


/**
 *
 * @author RC_Student_lab
 */
public class POEChecker {

    public static void main(String[] args) {
        
       
        
        //Creating an instance to create a class
       Message objMessage = new Message ();
        
        //Creating a scanner class
        Scanner input = new Scanner (System.in);
        
        
        //Prompting the username 
        
        System.out.println("Please enter your username");
        //User enters the username
        String username = input.nextLine();
        
        //Using if statements to check the username
        if(objMessage.checkUsername (username)==true){
            //Displaying the results
            System.out.println("Thank you for the username");
        }else{
            System.out.println("The username is incorrectly formatted");
         
        }
        
        //prompt user to enter password
        System.out.println("Please enter password");
        //enters password
        String password = input.nextLine();
        //using if statement to check password
        if (true== objMessage.checkPasswordComplexity(password)) {
            //display results
            System.out.println("Password successfully captured");
        } else {
            //display results
            System.out.println("Password unsuccesfully captured");
        }  
        
            //prompt the user to enter a cellphone number
            System.out.println("enter your cellphone number and include the SA format");
            
            String CellphoneNumber = input.nextLine();
            
            //using if statement to check cellphone number
            if (objMessage.checkCellphoneNumber(CellphoneNumber)){
                //display results
                System.out.println("Cellphone Number succesfully captured");
            
                } else {
                //display results
               System.out.println("Cellphone Number unsuccessfully captured");
                
        }
            System.out.println("Please enter the username that you used");
            String verifyUsername = input.nextLine();
            System.out.println("Enter password that you used");
            String verifyPassword = input.nextLine();
            //Login Attempt
            System.out.println("Attempting to Login");
    objMessage.Login(username, password, verifyUsername, verifyPassword);
    
    }
       
    }


        
   



        

    


    

