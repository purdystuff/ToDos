package users;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Users {
    
    //these are the fields for the User class
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;

    //this is the constructor which is responsible for initializing the state of the object
    public Users(String theUsersFirstName, String theUsersLastName, String theUsersGender, String theUsersDateOfBirth){
       
        this.firstName = theUsersFirstName;
        this.lastName = theUsersLastName;
        this.gender = theUsersGender;
        

        var dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyy");
        dateOfBirth = LocalDate.parse(theUsersDateOfBirth, dateTimeFormatter);
        
    }
    
    //The methods below are the getters and setters for accessing the objects
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String theNewGender){
        this.gender = theNewGender;
    }

    //this method takes the local date and subtracts the user's DOB to get their current age.
    public int getAge(){
       int yourAge = LocalDate.now().getYear() - dateOfBirth.getYear();
        return yourAge ;
    }

    //this method which doesn't work as intended is supposed to take the user's data and 
    //allow it to be accessed as a string. 
    public String toString(){
        
        String userInfo = firstName + " " + lastName + " a " + gender + " is " + getAge() + " years old.";
        String nbUserInfo = firstName + " " + lastName + " " + gender + " is " + getAge() + " years old.";
        if (gender.equals("Non-binary")){
            return nbUserInfo;
        } else return userInfo;
    }
    
}
