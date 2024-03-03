
package hotel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hotel {
 
   static Person[] persons = new Person[8];
   static Scanner input = new Scanner(System.in);
   static Room[] rooms = new Room[8];
   static String roomName;
   static int roomNum = 0;
   static Roomqueue waiting_list = new Roomqueue();

   public static void main(String[] args) {
       
            char choice ;
            initialise();
       do {
          
          displayMenu();
          System.out.println("enter a choice (qQ) to exit");
          choice = input.next().toUpperCase().charAt(0);
         
         
         switch(choice)
            {
                case 'A': System.out.println("you chose to add customer to room");
                           addCustomer();
                           break;
                case 'V': System.out.println("you chose to display all customers");
                          viewRoom();
                          break;
                case 'E': System.out.println("You choose to view all empty rooms");
                          emptyRooms();
                          break;
                case 'D': System.out.println("you chose to remove  customer");
                          deleteCustomer();
                          break;
                case 'S': System.out.println("you chose to store program data in to file");
                        storeData();
                          break;
                case 'F': System.out.println("you chose to find a customer");
                        findRoom();
                        break;
                case 'L': System.out.println("you chose to load program data from file");
                          loadData();
                         break;
                case 'O': System.out.println("You choose to order the customers in alphabetic order");
                         sortNames();
                         break;
                case 'Q': System.out.println("Thanks for using our system"); 
                        break;
                default: System.out.println("enter a valid option");
               
            }
         
        
       } while (choice !='Q');


}
     
 //adds customer to the room 
 //checks for validation of integer   
 public static void addCustomer(){
    boolean done = false;
     int noOfPeople = 0;
     String fName;
     String lName;
     String CCN;
    if (roomNum == 8) {
    System.out.println("Rooms are full, you are being added to waiting list");
        
    System.out.println("Enter number of customers staying in room :" ) ;
    while (done = true){
        if(!input.hasNextInt()){
        System.out.println("Invalid input!");
            System.out.print("Enter an integer: ");
            input.next(); 
       
        } else{
            noOfPeople = Integer.parseInt(input.next());
            done = true;
            break; 
        }
    }
    
    System.out.println("Enter First name of the customer paying for the room :" ) ;
     fName = input.next() ;
    System.out.println("Enter Last name of the customer paying for the room :" ) ;
     lName = input.next();
    System.out.println("Enter credit cardnumber of the customer for the room :" ) ;
     CCN = input.next();
    }
    
    else{
    
    System.out.println("Enter number of customers staying in room :" ) ;
    while (done = true){
        if(!input.hasNextInt()){
        System.out.println("Invalid input!");
            System.out.print("Enter an integer: ");
            input.next(); 
       
        } else{
            noOfPeople = Integer.parseInt(input.next());
            done = true;
            break; 
        }
    }
    
    System.out.println("Enter First name of the customer paying for the room number" + roomNum +" :" ) ;
     fName = input.next() ;
    System.out.println("Enter Last name of the customer paying for the room number" + roomNum +" :" ) ;
     lName = input.next();
    System.out.println("Enter credit cardnumber of the customer for the room number" + roomNum +" :" ) ;
     CCN = input.next();
   // roomNum++;
    }
    
    Person p = new Person(noOfPeople,fName,lName,CCN);
    
    int numfull = 0;
    for (int i = 0; i < 8; i++) {
        if (!rooms[i].getperson().getfName().equals("empty")) {
            numfull++;
        }
    }
    if (numfull == 8) {
        System.out.println("All rooms are full, you are added to the waiting list");
        waiting_list.addqueue(p);
    }
    else {
        
    int i = 0;
    while (!rooms[i].getperson().getfName().equals("empty")) {
        i++;
    }
    if (i < 8) {
       p.setroomnum(i);
       rooms[i].setperson(p);
       roomNum++;
    }
    }
    

   
 } 
 
//initialises all the rooms to empty at the beining of the code  
 public static void initialise(){
     for (int x = 0; x < 8; x++ ){
         rooms[x] = new Room(x);
         Person def = new Person(0,"empty","empty","empty");
         rooms[x].setperson(def);
     }
 }
 
 //displays all rooms 
 public static void viewRoom(){
        for (int i = 0; i < 8 ; i++){
            System.out.println("Room Number " + (i) + " : " + "first name: " + rooms[i].getperson().getfName() + " "+ "last name:  " + " " + rooms[i].getperson().getlName()+ " " + "room occuoancy : " + rooms[i].getperson().getnoOfPeople() + " " + "Credit Card number: " + " " + rooms[i].getperson().getCCn() );

        }
    }
 
//deletes customer from the room  
public static void deleteCustomer(){
    System.out.println("Enter room number of the room to empty: ");
    int roomnum = input.nextInt();

        if (rooms[roomnum].getperson() != null){
            rooms[roomnum].setroomnum(0);
            rooms[roomnum].getperson().setfName("empty"); 
            rooms[roomnum].getperson().setlName("empty");
            rooms[roomnum].getperson().setnoOfPeople(0);
            rooms[roomnum].getperson().setCCn("empty");
         }
    Person toAdd = waiting_list.remove();
    if (toAdd != null) {
        rooms[roomnum].setperson(toAdd);
        toAdd.setroomnum(roomnum);        
    }
        
}
 
//displays all empty rooms 
     public static void emptyRooms(){
        for (int i = 0; i < 8 ; i++){
            if (rooms[i].getperson().getfName().equals("empty"))System.out.println("room " + i + " is empty");
        }
    }

//this function find the details of the customer by enetering first name      
     public static void findRoom(){
        String name;
        int local = 0;
        int i=0;
        System.out.println("Enter the name of the customer you want to find: ");
        name = input.next().toLowerCase();
        for(i=0 ; i<8 ; i++){
            if(name.equals(rooms[i].getperson().getfName())){
                System.out.println("Room Number " + (i) + " : first name " + rooms[i].getperson().getfName() + " "+ "last name " + " " + rooms[i].getperson().getlName() + "room occuoancy : " + rooms[i].getperson().getnoOfPeople() + "" + "Credit Card number" + rooms[i].getperson().getCCn() );
                local += 1;
                break;
            }

        }
        if(local != 1){
            System.out.println("Customer not found!");
        }
    }    
     
  
//sorts first names alphabetically in acending order      
         public static void sortNames(){

        int n = rooms.length;
        String temp;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (rooms[i].getperson().getfName().compareTo (rooms[j].getperson().getfName())>0)
                {
                    temp = rooms[i].getperson().getfName();
                    rooms[i].getperson().setfName(rooms[j].getperson().getfName());
                    rooms[j].getperson().setfName(temp);
                }
            }
        }
        for (int k = 0; k < n; k++) {
            System.out.println(rooms[k].getperson().getfName());
        }
    }
     
     
     
//function to store array in a text file         
         public static void storeData(){
        PrintWriter outToFile = null;
        try{
            //creates new file
            outToFile = new PrintWriter("hotelArray.txt");
            // loops add the data enterd into the file
            for (int s=0; s<8; s++)
            {
                //int t = rooms[s].getroomnum();
                String send = rooms[s].getperson().getfName();
                String x = rooms[s].getperson().getlName();
                int y = rooms[s].getperson().getnoOfPeople();
                String z = rooms[s].getperson().getCCn();

                //outToFile.println(t);
                outToFile.println(s);
                outToFile.println(send);
                outToFile.println(x);
                outToFile.println(y);
                outToFile.println(z);

            }
            outToFile.flush();
            outToFile.close();
            System.out.println("File has been stored");

        }catch(FileNotFoundException e){
            System.out.println("Sorry file not found");
        }
    }

     
//load data 
//needs a return type    
   public static String[] loadData() {
        String[] names = new String[8];
        try (Scanner fileReader = new Scanner(new BufferedReader(new FileReader("hotelArray.txt"))))
        {
            int i = 0;
            int roomNo = 0;
            while(fileReader.hasNext())
            {
                String num = fileReader.next();
                rooms[i].setroomnum(Integer.parseInt(num));
                rooms[i].getperson().setfName( fileReader.next() ) ;
                rooms[i].getperson().setlName(fileReader.next());
                rooms[i].getperson().setnoOfPeople(Integer.parseInt(fileReader.next()));
                rooms[i].getperson().setCCn(fileReader.next());
                i += 1;
                
                System.out.println("Room Number " + (roomNo) + " : first name " + rooms[roomNo].getperson().getfName() + " "+ "last name " + " " + rooms[roomNo].getperson().getlName() + "room occuoancy : " + rooms[roomNo].getperson().getnoOfPeople() + "" + "Credit Card number" + rooms[roomNo].getperson().getCCn() );
                roomNo++;

            }
        } catch (IOException e) {
            System.out.println("Error, Sorry file could not be found");
        }
        return names;
    }
      
         
//format of the display menu         
 public static void displayMenu() {
        System.out.println("A: Add customers to room");
        System.out.println("V: View all customers in the room");
        System.out.println("E: View all empty rooms");
        System.out.println("F: Find customer by name");
        System.out.println("D: Delete customers from room");
        System.out.println("S: Store program data in to file");
        System.out.println("L: Load program data from file");
        System.out.println("O: Order alphabetically");
        System.out.println("-----------------------------------------------");

    }

    public  String toLowerCase(){
        return null;
    }   
        
     
}


























    




















    
   
        


    

