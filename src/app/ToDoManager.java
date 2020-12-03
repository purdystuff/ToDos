package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import users.Users;

import java.io.File;
import java.io.IOException;

public class ToDoManager{

    private static ArrayList<Users> users = new ArrayList<Users>();
    private static int count = 1;
    private static final String fileName = "users.todo";
    private static File file = new File(fileName);
    private static String currentLine;
        
    public static void main(String[] args) {
       
        System.out.println();

        System.out.println("Welcome to your To-Do Manager");
        System.out.println("-".repeat(30));
        System.out.println("Today's Date: " + LocalDate.now());
        System.out.println();

        System.out.println("Here are the current users in our system:");
        System.out.println("-".repeat(40));
        System.out.println();

        loadUsers();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a last name to find a user: ");
        System.out.println("To see all users type \"All\": ");
        System.out.println();
        String lastName = keyboard.nextLine();
        System.out.println();
        keyboard.close();

        ArrayList<Users> foundLastName = findUser(lastName);
        System.out.println();

        //printUsers();
          
        System.out.println();
            
    }

//this method takes the input from the users.todo file and adds each line to the array!                 
private static void loadUsers(){
  
    try{
    Scanner fileReader = new Scanner (file);
    fileReader.nextLine();

    while(fileReader.hasNextLine()){

            currentLine = fileReader.nextLine();
            String[] nameParts =currentLine.split(",");
        
            var user = new Users(nameParts[0], nameParts[1], nameParts[2], nameParts[3]);
           
             users.add(user);
        }
       
        fileReader.close();
    }catch(IOException e){
        System.out.println("There was an error " + e.getMessage());
    } 
}

//this method prints all of the users information from the file
private static void printUsers(){

    for (int i = 0; i < users.size(); i++){
    System.out.println("User " + count + ": " + users.get(i).toString());
    count ++;
    }
    
}

private static ArrayList<Users> findUser(String lastName){
    ArrayList <Users> foundLastName = new ArrayList<Users>();
    for (int i = 0; i < users.size(); i++){
        if (lastName.equals(users.get(i).getLastName())) {
            System.out.println(users.get(i));
        }
    } if(lastName.equals("All")){
        printUsers();
    } else {
        System.out.println("User not found. Sorry.");
    }
    return foundLastName;
}

}

