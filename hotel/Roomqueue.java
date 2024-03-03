
package hotel;

//Roomqueue class

public class Roomqueue {
 
 static Person qitems[] = new Person[8];
 static int front = 0, end = 0;
 
 //adding person to queue
 static void addqueue(Person input) {
 qitems[end] = input;
 end++;
 }
 
 //rotates the array 
 static Person takequeue() {
 if (end > front) {
 front++;
 return qitems[front-1];
 //front++;
 } else {
 System.out.println("Empty queue");
 return null;
 }
 }
  
 //removes the passenger
 public Person remove()
{
    //if the queue array is not empty
    //checks if the queue is empty
    if(front == end)  
    {  
        System.out.println("\nthe queue is empty \n");  
       
    }
    
    else if(front == 20)  
        {  
            front = 0;  
        }  
    else 
    {  
        //first = first + 1;  
        Person removedPerson = qitems[front];
    //QArray[first]=QArray[first+1];
    front++;
    System.out.println("passenger removed is:" +removedPerson);
   
    
      return removedPerson;
    
}
     return null;
    
}
 
 
 
 
 
 
 
}
