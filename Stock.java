import java.io.Serializable;

public class Stock implements Serializable{
    String ProductName;
    int volume;
    double price;

    public Stock(String Productname, int volume, double price) {
        this.ProductName = Productname;
        this.volume = volume;
        this.price = price;
    }

    @Override
    public String toString() {

        return this.ProductName+" "+this.volume+" "+this.price+" ";
    }
}
