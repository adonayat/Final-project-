import java.io.Serializable;

public class Stock implements Serializable{
    String Productname;
    int volume;
    double price;

    public Stock(String Productname, int volume, double price) {
        this.Productname = Productname;
        this.volume = volume;
        this.price = price;
    }

    @Override
    public String toString() {

        return this.Productname+" "+this.volume+" "+this.price+" ";
    }
}
