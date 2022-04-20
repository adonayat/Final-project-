
//this is the one I told y'all over text. I dont really know how to read from text and do the rest of the job	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventory implements Serializable {
    static Stock[] stocks= new Stock[5];
    static Transaction t;
    private static int bill=0;
    public Inventory() throws FileNotFoundException {
    	Scanner fileread = new Scanner(new FileReader("inventory.txt"));
	    int i = 0;
	    int line = 1;
	    try{
	    	String productname = "";
				String company = "";
				String temp = "";
	            int price = 0, volume;
	            try {
	            	while(fileread.hasNextLine()){
	            		if(line == 1){
	           
	                    productname = fileread.next();
	                    line++;
	                }
	                else if(line == 2){
	                    company = fileread.next();
	                    line++;
	                }
	                else if(line == 3){
	                	price = fileread.nextInt();
	                    line++;
	                }
	                else{
	                    volume = fileread.nextInt();
	                    stocks[i] = new Stock(productname, price, volume);
	                    line = 1;
	                }
	                i++;
	                fileread.nextLine();
	            }
	            }
	            catch(InputMismatchException ie) {
	            	throw ie;
	            }
	        }
	        catch(Exception e) {
	        	throw e;
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
		   m.AddInventory("Sample", "sample", 30, 10000);
		   m.AddInventory("Soap", "B29", 50, 1000);
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
