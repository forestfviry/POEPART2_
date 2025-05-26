/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poechecker;
import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author RC_Student_lab
 */
class Message {
    static int messageCount = 0;
    
     public boolean checkPasswordComplexity (String password){
    //check if the password is at least 9 letters long and contains
    //at least one uppercase letter, one digit, and one special letter
      if (password.length() >= 8 ||
              
        password.matches(". [A-Z].*")|| //contains at least one uppercase letter
              
        password.matches(".*[a-z].*")||
              
        password.matches(".*[0-9].*")||
              
        password.matches(".*[!@#$%67*()].*"))
        
            return true;
            
            else{ 
                    return false;
      }
}
              
       
      public boolean verifyPassword(String verifyPassword,String password){
       if (verifyPassword.equals(password)) {
           return true;
       }else{
           return false;
       }
       }  
      
      
    
    public boolean checkUsername (String Username){
        if (Username.contains("_") && Username.length()<=5){
            return true;
        }else{
            return false;
        }
    }
            public boolean verifyUsername(String verifyUsername, String username){
    return verifyUsername.equals(username);
}

            
    public boolean checkCellphoneNumber (String CellPhone){
       if(CellPhone.startsWith("+27")&& CellPhone.length()== 12 && CellPhone.matches(".*[0-9].*")){
           return true;
       }else{
           return false;
       }
        
    }
    

    public boolean Login(String username, String password, String verifyUsername, String verifyPassword) {
        if (verifyUsername.equals(username)&& verifyPassword.matches(password)){
            System.out.println("Login successful, Welcome "+username+"!");
            return true;
                    }else{
            System.out.println("Login unsuccessful, Please try again");
            return false;
            
           
        }
    }

    
         
    {
            JOptionPane.showMessageDialog(null, "Welcome to Quickchat");
            
            boolean running = true;
            
            int totalMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages are you sending"));
             while (running){
                 
                String[] options = {"Send Message", "Save Message for Later", "Send Stored Messages", "Show Recent Messages", "Quit"};

                 int choice = JOptionPane.showOptionDialog(null, 
                         "Choose an option below", 
                         "Quickchat Menu", 
                         JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, (0));
    
        

                  switch (choice){
                     case 0: //send message
                     if (messageCount < totalMessages) {
                         
                sendMessage();
                } else {
                JOptionPane.showMessageDialog(null, "You have reached the message limit", "Error", JOptionPane.INFORMATION_MESSAGE);
                     }
                     break;

                 
  
    case 1: // Save Message for Later
        String recipient = JOptionPane.showInputDialog("Enter Recipient's number:");
        String message = JOptionPane.showInputDialog("Enter your message:");
       
        break;

    case 2: // Send Stored Messages
       JOptionPane.showMessageDialog(null, "Coming soon!", "User is typing", JOptionPane.INFORMATION_MESSAGE);
        break;
        

    case 3: // Show Recent Messages
        JOptionPane.showMessageDialog(null, "Coming soon!", "User is typing", JOptionPane.INFORMATION_MESSAGE);
        break;
        
    case 4:
         JOptionPane.showMessageDialog(null, "Thank you for using Quickchat!", "Quit", JOptionPane.INFORMATION_MESSAGE);
        running = false;
        break;
                 }
             }
}
    

public static boolean Login() {
    String username = JOptionPane.showInputDialog("Please enter username:");
    String password = JOptionPane.showInputDialog("Please enter password:");

    // Ensure both fields are not empty
    if (username != null && !username.trim().isEmpty() && password != null && !password.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Login successful! Welcome, " + username + "!");
        return true;
    } else {
        JOptionPane.showMessageDialog(null, "Login failed. Please enter both username and password.");
        return false;
    }
    }
public static void sendMessage() { 

        String Recipient = JOptionPane.showInputDialog("Enter Recipient's number");
        
        if (Recipient == null || !Recipient.startsWith("+27") || Recipient.length() != 12 || !Recipient.matches("\\+27[0-9]{9}")) {
    JOptionPane.showMessageDialog(null, "Invalid phone number! Must start with +27 and be exactly 12 characters long.");
    return;
}
       
        String message = JOptionPane.showInputDialog("Enter you message:");
        if (message == null || message.trim().isEmpty()){
    JOptionPane.showMessageDialog(null, "Message cannot be empty.");
}
if (message == null || message.trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Message disregarded: Cannot be empty.");
    return;
//Source(Referencing): geeksforgeeks (Accessed 2025)
}
        String messageID = generateMessageID();
         String messageHash = generateMessageHash(messageID, message);
         System.out.println("Generated Message ID: " + messageID);
         
         messageCount++;
         
         String summary = "Message sent successfully!\n\n"
        + "Unique Message ID: " + messageID + "\n"
        + "Number of messages sent: "+ messageCount + "\n"
        + "Recipient: "+ Recipient + "\n"
        + "Message: "+ message;

         JOptionPane.showMessageDialog(null,summary);
         //Source: COPILOT AI and GEEKSFORGEEKS
    }
 public static String generateMessageID(){
        Random rand = new Random();
        StringBuilder id = new StringBuilder();
        
        for (int i = 0; i < 10; i++){
            id.append(rand.nextInt(10));
            
        }
    return id.toString();
    
    }
 public static String generateMessageHash(String messageID, String message) {
    
            if (message == null || message.trim().isEmpty()) {
        return "INVALID_HASH";
    }

    // Extracting the first two digits of a message ID
    String idPrefix = messageID.substring(0, 2);

    // Spliting the message into words for a simple context
    String[] words = message.trim().split("\\s+");
    String firstWord = words[0].toUpperCase();
    String lastWord = (words.length > 1) ? words[words.length - 1].toUpperCase() : firstWord; // single-word case

    return idPrefix + ":" + messageCount + ":" + firstWord + ":" + lastWord;
        }
    

public static void main(String[] args) {
        String messageID = "12345";
        String message = "Hello, world!";
        String hash = generateMessageHash(messageID, message);

        System.out.println("Generated Message Hash: " + hash);
    }


 static ArrayList<String> pendingMessages = new ArrayList<>();

  public static void sendSavedMessages() {
    if (pendingMessages.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No messages to send.");
        return;
    }

    StringBuilder messagesPreview = new StringBuilder("Messages ready to send:\n");
    for (String msg : pendingMessages) {
        messagesPreview.append(msg).append("\n");
    }

    JOptionPane.showMessageDialog(null, messagesPreview.toString()); // Show stored messages
    
    for (String msg : pendingMessages) {
        JOptionPane.showMessageDialog(null, "Sending message: " + msg);
    }
    pendingMessages.clear(); // Remove messages after sending
}

}



    
    
  

    
            
 
    

   
    
   

   


    

