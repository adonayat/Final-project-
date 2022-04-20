


import java.io.Serializable;

public class Stock implements Serializable{
    String Productname;
    int price;
    int volume;

    public Stock(String Productname, int price, int volume) {
        this.Productname = Productname;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public String toString() {
        
        return this.Productname+" "+this.price+" "+this.volume;
    }


}
