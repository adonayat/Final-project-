public class Inventory {
    private String name;
    private int amount;
    private double price;

    public Inventory(String itemName, int inStock, double cost)
    {
        name = itemName;
        amount = inStock;
        price = cost;
    }

    public void setStock(int stock)
    {
        amount = stock;
    }

    public void setCost(double pricing)
    {
        price = pricing;
    }

    public String getName()
    {
        return name;
    }

    public int getStock()
    {
        return amount;
    }

    public double getCost()
    {
        return price;
    }
}
