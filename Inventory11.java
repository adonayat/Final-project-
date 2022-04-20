	

	
	import java.io.*;

	import java.sql.Date;
	
	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.Scanner;
	
	
	public class Inventory implements Serializable {
	    static Stock[] stocks= new Stock[1000];
	    static Transaction t;
	    private static int bill=0;
	    public Inventory() {
			FileReader reader = null;
			// open the file
			try
			{
				reader = new FileReader("inventory.txt");
			}
			catch (FileNotFoundException e)
			{
				System.out.println("File was not found");
				System.exit(-1);
			}
			// make a scanner from it
			Scanner in = new Scanner(reader);

			String name = "";
			int stock = 0;
			double price = 0;
			for(int i = 0; i < 3; i++)
			{
				name = in.nextLine();
				stock = Integer.parseInt(in.nextLine());
				price = Double.parseDouble(in.nextLine());
			}
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
