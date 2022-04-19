public class DailyReport {
    private String nameOfItemSold;
    private int amountSold;
    private double costOfItem;
    private static double weeklyEarned;

    public void setName(String name)
    {
        nameOfItemSold = name;
    }

    public void setPrice(double cost)
    {
        costOfItem = cost;
    }
    //Not sure if this is what's intended
    public void amountBought(int inventoryAmount)
    {
        amountSold = inventoryAmount;
    }

    public String getName()
    {
        return nameOfItemSold;
    }

    public int getAmount()
    {
        return amountSold;
    }

    public double getCost()
    {
        return costOfItem;
    }

    public double getTotalCost()
    {
        return weeklyEarned;
    }
}
