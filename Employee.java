public class Employee {
    String name;

    public Employee(String Name) {
        this.name = Name;
    }
    public void seeInventory(){
        System.out.println("--EMPLOYEE--");
        System.out.println("Company Productname price volume");
        System.out.println("================================");
        Stock[] s=Inventory.stocks;
        for (Stock stock : s) {
            System.out.println(stock.toString());
        }
        System.out.println("================================");
        
    }
    
}
