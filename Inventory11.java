	

	
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.Serializable;
	
	import java.sql.Date;
	
	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.Scanner;
	
	
	public class Inventory implements Serializable {
	    static Stock[] stocks= new Stock[5];
	    static Transaction t;
	    private static int bill=0;
	    public Inventory() {
	    	stocks[0]=new Stock("Cheese","Mozzarella",100,2000);
	    	stocks[1]=new Stock("Cooking Oil","olive",100,2000);
	    	stocks[2]=new Stock("Dishwash","Dawn",100,2000);
	    	stocks[3]=new Stock("Tomato Sauce","Prego",100,2000);
	    	stocks[4]=new Stock("Meat","Beef",100,2000);
	    }
	public static int generateBill(){
	    return bill;
	}
	public static void saveTransaction(String Receiver,int item){
		bill+=stocks[item-1].price;
	    t = new Transaction(Receiver,Date.valueOf(LocalDate.now()),stocks[item-1].price,stocks[item-1].Productname);
	    stocks[item-1].volume-=1;
	    
	}
	   public static void readTransaction(){
	       System.out.println("Product Name:"+t.Productname+"\n"+"Receiver Name:"+t.receiverName+"\n"+"Date:"+t.transactionDate.toString() + "\n");
	    }
	        
	
	    
	
	
	
	public static void main(String[] args) throws IOException {
	   Inventory i=new Inventory();
	   i.saveTransaction("Adonay",4);
	   readTransaction();
	   i.saveTransaction("Adonay",4);
	   readTransaction();
	   i.saveTransaction("Adonay",4);
	   readTransaction();
	   Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	   System.out.println("Enter Password");
	   if(myObj.next().equalsIgnoreCase(Manager.pass)){
		   Manager m;
		   m = new Manager("Adonay",Manager.pass);
		   System.out.println("--MANAGER--");
		   m.seeTransaction();
		   m.AddInventory("sample", "sample", 30, 10000);
		   m.AddInventory("Sample", "sample", 50, 1000);
		   m.seeBill();
		   
	   }
	   else{
	       System.out.println("Wrong Manager Password"); 
	   }//passABC 
	   i.saveTransaction("Adonay", 7);
	   readTransaction();
	   Employee e=new Employee("Adonay");
	       e.seeInventory();
	  }
	}
