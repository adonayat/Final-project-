


import java.io.Serializable;

public class Stock implements Serializable{
    String Productname;
    String Company;
    int price;
    int volume;

    public Stock(String Productname, String Company, int price, int volume) {
        this.Productname = Productname;
        this.Company = Company;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public String toString() {
        
        return this.Company+" "+this.Productname+" "+this.price+" "+this.volume;
    }


}
