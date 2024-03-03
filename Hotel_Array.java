
package hotel_array;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hotel_Array {

    static Scanner input = new Scanner(System.in);
   static String[] hotel = new String[8]; //Array for hotel 
   static String[] lastName = new String[8];//Array for last name of customers
   static String [] creditCardNum = new String[8];//Array for credit card number of customers
   static int[] numOfCust = new int[8];//Number of customer staying in a room 
   static String roomName; //  stores the first name of the customer 
   static int roomNum = 0; // stores room numbers of the hotel 
   

   
   public static void main(String[] args) {
       
       char choice ;
       initialise(hotel);
       do {
          
          displayMenu();
          System.out.println("enter a choice (qQ) to exit");
          choice = input.next().toUpperCase().charAt(0);
         
         
         switch(choice)
            {
                case 'A': System.out.println("you chose to add customer to room");
                           addCustomer(hotel);
                           break;
                case 'V': System.out.println("you chose to display all customers");
                          viewRooms(hotel);
                          break;
                case 'E': System.out.println("You choose to view all empty rooms");
                          emptyRooms(hotel);
                          break;
                case 'D': System.out.println("you chose to remove  customer");
                          deleteCustomer(hotel);
                          break;
                case 'S': System.out.println("you chose to store program data in to file");
                        storeData(hotel);
                          break;
                case 'L': System.out.println("you chose to load program data from file");
                         loadData(hotel);
                         break;
                case 'F': System.out.println("You choose to order the customers in alphabetic order");
                        findRoom(hotel);
                         break;
                case 'O': System.out.println("You choose to order the customers in alphabetic order");
                        sortNames(hotel);
                         break;
                case 'Q': System.out.println("Thanks for using our system"); 
                        break;
                default: System.out.println("enter a valid option");
               
            }
         
        
       } while (choice !='Q');
       
       
   }
   
 public   String toLowerCase(){
       return null;
 }
 
//displays all rooms 
 public  static void viewRooms (String[] hotel) {
   for (int i = 0; i < 8 ; i++){
        System.out.println("Room Number " + (i) + " : " + hotel[i] + " " + lastName[i] + " number of people in room " + (i) + " : " + numOfCust[i] );     
     }
    }
 
      
//initialises all the rooms to empty at the beining of the code  
 private static void initialise( String[] hotel ) {
 for (int x = 0; x < 8; x++ ) hotel[x] = "empty";
 }

//adds customer to the room 
 //checks for validation of integer
public static void addCustomer(String[] hotel){
    boolean done =  false;
    
    while(done =  true){
    System.out.println("Enter room number (0-7) or 8 to stop:" );
    //roomNum = input.nextInt();
    if(!input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter an integer: ");
            input.next(); 
        }
    else{
        roomNum = input.nextInt();
        done = true;
        break;
    }
    }

    if (roomNum !=8){
    System.out.println("Enter number of customers staying in " + roomNum +" :" ) ;

    
    while (done = true){
    
    if(!input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter an integer: ");
           
            input.next(); 
           
        }
    else{
        numOfCust[roomNum] = Integer.parseInt(input.next());
        done = true;
         break;
    }
    
    }

    System.out.println("Enter First name of the customer paying for the room number" + roomNum +" " + ":" ) ;
    roomName = input.next().toLowerCase();
    hotel[roomNum] = roomName ;
    System.out.println("Enter Last name of the customer paying for the room number" + roomNum +" "+" :" ) ;
    lastName[roomNum] = input.next().toLowerCase();
    System.out.println("Enter credit cardnumber of the customer for the room number" + roomNum +" " +" :" ) ;
    creditCardNum[roomNum] = input.next();
    }

}

//deletes customer from the room 
public static void deleteCustomer(String[] hotel){
    System.out.println("Enter room number of the room to empty: ");
    roomNum = input.nextInt();
    if (hotel[roomNum] != null) {
        hotel[roomNum] = "empty";
        lastName[roomNum] = "null";
        numOfCust[roomNum] = 0;
        creditCardNum[roomNum] = "empty";
        System.out.println("Customer has been removed from the room ");
    }
    }
    
//displays all empty rooms 
public static void emptyRooms(String[] hotel){
    for (int i = 0; i < 8 ; i++){
      if (hotel[i].equals("empty"))System.out.println("room " + i + " is empty");  
}
}


//this function find the details of the customer by enetering first name 
public static void findRoom(String[] hotel){
    
    String name;
    int local = 0;
    int i=0;
    System.out.println("Enter the name of the customer you want to find: ");
    name = input.next().toLowerCase();
    for(i=0 ; i<8 ; i++){
            if(name.equals(hotel[i])){
                System.out.println(hotel[i] + " " + lastName[i] +  " occupies room no. " + (i) + " there are " + numOfCust[i] + " people in the room");
                local += 1; 
                 break;
            }
           
            }
       if(local != 1){
                System.out.println("Customer not found!");
}
}

//sorts first names alphabetically in acending order 
public static void sortNames(String[] names){
    int n = names.length;
    String temp;
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (names[i].compareTo(names[j])>0)
            {
                temp = names[i];
                names[i] = names[j];
                names[j] = temp;
            }
        }
    }
    for (int k = 0; k < n; k++) {
        
    System.out.println(names[k]);
    
    }
}


    

//function to store array in a text file
public static void storeData(String[] hotel) {                   
         PrintWriter outToFile = null;
        try{
           //creates new file 
           outToFile = new PrintWriter("hotelArray.txt");
        // loops add the data enterd into the file   
        for (int s=0; s<8; s++)
        {
            
            String send = hotel[s];
            String x = lastName[s];
            int y = numOfCust[s] ;
            String z = creditCardNum[s] ;
            
            
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
public static String[] loadData(String[] hotel) {
    String[] names = new String[8];
    try (Scanner fileReader = new Scanner(new BufferedReader(new FileReader("hotelArray.txt"))))
    {
        int i = 0;
        int roomNo = 0 ;
        while(fileReader.hasNext())
        {
            String num = fileReader.next();
                roomNum = Integer.parseInt(num);
                hotel[i] =  fileReader.next()  ;
                lastName[i] = (fileReader.next());
                numOfCust[i] = (Integer.parseInt(fileReader.next()));
                creditCardNum[i]= (fileReader.next());
                i += 1;
                
                System.out.println("Room Number " + (roomNo) + " : first name " + hotel[roomNo] + " last name: " + lastName[roomNo] + " number of people: " + numOfCust[roomNo] + " credit card number :" + creditCardNum[roomNo]);
                roomNo++;
            
        }
    } catch (IOException e) {
        System.out.println("Error, Sorry file could not be found");
    }
    return names;
}

    //format of the display menu 
     private static void displayMenu() {
        System.out.println("A: Add customers to room");
        System.out.println("V: View all customers in the room");
        System.out.println("E: View all empty rooms");
        System.out.println("D: Delete customers from room");
        System.out.println("F: Find customers from room");
        System.out.println("S: Store program data in to file");
        System.out.println("L: Load program data from file");
        System.out.println("O: Order alphabetically");
        System.out.println("-----------------------------------------------");
          
    }
    
    
}