
package hotel;

//person class

public class Person {
    

    private String lName; //Last Name of the customer  
    private String CCN ; //Credit Card Number
    private int noOfPeople;//Number of people staying in the room 
    private String fName;//First Name of the customer 
    private int roomnum;//Initialises the room number
    
//constructor
public  Person(int noOfPeople,String fName,String lName,String CCN){
     this.CCN=CCN;
     this.lName = lName;
     this.noOfPeople = noOfPeople;
     this.fName = fName;
}



   public void setnoOfPeople(int noOfPeople){
        this.noOfPeople = noOfPeople;
    }

    public void setCCn(String CCN){
        this.CCN = CCN;
    }
    public void setlName(String lName){
        this.lName = lName;
    }


    public int getnoOfPeople(){
        return noOfPeople;
    }

    String getlName(){
        return lName;
    }

    String getCCn(){
        return CCN;
    }

    String getfName(){
        return fName;
    }

    
    public void setfName(String f){
        this.fName = f;
    }
    
public void setroomnum(int roomnum){
    this.roomnum = roomnum;
}

}

    

