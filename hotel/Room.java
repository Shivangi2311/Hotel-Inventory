package hotel;

//Room Class
import java.util.Scanner;


public class Room {
    private Person person;
    private Scanner input = new Scanner(System.in);
    private String[] hotel = new String[8];
    private int roomnum ;
    private String status;
  
  
//room class constructor 
    public  Room(int roomnum){
        this.roomnum = roomnum;
        this.status = "empty";
        
    }

//getter method for status =  "empty"
    public String getstatus(){
        return status;
    }
    
    //instance of the class Person 
    public void setperson(Person p){
        this.person = p;
    }
    
    public Person getperson(){
        return person;
    }
    
    public int getroomnum(){
        return roomnum;
    }
    
    //setting the roomnum 
    public void setroomnum(int r){
        this.roomnum = r;
    }
    


}

