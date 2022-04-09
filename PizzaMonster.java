import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PizzaMonster {
    private static JFrame frame;

    public static void main(String[] args) {

        //create ArrayList
        ArrayList<String> itemName = new ArrayList<String>();
        ArrayList<Integer> amount = new ArrayList<Integer>();
        ArrayList<Double> cost = new ArrayList<Double>();
        ArrayList<String> weeklyItemName = new ArrayList<>();
        ArrayList<Integer> weeklyAmount = new ArrayList<Integer>();
        ArrayList<Double> weeklyCost = new ArrayList<Double>();

        //set size of window
        frame = new JFrame("Lab 12: GUI Exercise");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //read file to variables
        try {
            File file = new File("InventoryExample.txt");
            Scanner scan = new Scanner(file);

            //scan name, amount, and cost in to variable
            while (scan.hasNext() != scan.hasNext("end")) {
                String data = scan.nextLine();
                itemName.add(data.substring(0, data.indexOf(":")));
                amount.add(Integer.parseInt(data.substring(data.indexOf(":") + 2, data.indexOf(","))));
                cost.add(Double.parseDouble(data.substring(data.indexOf(",") + 2, data.length())));
            }
            scan.nextLine();

            //scan name, weekly amount and cost in to variable
            while (scan.hasNext() != scan.hasNext("end")) {
                String data = scan.nextLine();
                weeklyItemName.add(data.substring(0, data.indexOf(":")));
                weeklyAmount.add(Integer.parseInt(data.substring(data.indexOf(":") + 2, data.indexOf(","))));
                weeklyCost.add(Double.parseDouble(data.substring(data.indexOf(",") + 2, data.length())));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        //create menu
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit", null);
        JMenuItem open = new JMenuItem("Open", null);

        //messing around with tabs
        file.add(open);
        file.add(exit);

        // add file to the menubar
        menuBar.add(file);

        // add the menuBar to the window
        frame.setJMenuBar(menuBar);

        // set other things
        frame.setTitle("Simple menu");

        // launch the windwo
        frame.setVisible(true);

    }
}
