import java.io.Serializable;
import java.util.Date;

class Transaction implements Serializable {
    String receiverName;
    Date transactionDate;
    int totalBill;
    String Productname;

    public Transaction(String receiverName, Date transactionDate, int totalBill, String Productname) {
        this.receiverName = receiverName;
        this.transactionDate = transactionDate;
        this.totalBill = totalBill;
        this.Productname = Productname;
    }

   

}

    

