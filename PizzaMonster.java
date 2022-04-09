import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PizzaMonster {
    private static JFrame frame;

    public static void main(String[] args) {

        ArrayList<String> itemName = new ArrayList<String>();
        ArrayList<Integer> amount = new ArrayList<Integer>();
        ArrayList<Double> cost = new ArrayList<Double>();
        ArrayList<String> weeklyItemName = new ArrayList<>();
        ArrayList<Integer> weeklyAmount = new ArrayList<Integer>();
        ArrayList<Double> weeklyCost = new ArrayList<Double>();

        frame = new JFrame("Lab 12: GUI Exercise");
        //set size of window
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //read file
        try {
            File file = new File("InventoryExample.txt");
            Scanner scan = new Scanner(file);
            // scan contents in to variable
            while (scan.hasNext() != scan.hasNext("end")) {
                String data = scan.nextLine();
                itemName.add(data.substring(0, data.indexOf(":")));
                amount.add(Integer.parseInt(data.substring(data.indexOf(":") + 2, data.indexOf(","))));
                cost.add(Double.parseDouble(data.substring(data.indexOf(",") + 2, data.length())));
                //System.out.println(data);
            }
            for (int y = 0; y < itemName.size(); y++){
                System.out.println(itemName.get(y));
            }
            scan.nextLine();
            while (scan.hasNext() != scan.hasNext("end")) {
                String data = scan.nextLine();
                weeklyItemName.add(data.substring(0, data.indexOf(":")));
                weeklyAmount.add(Integer.parseInt(data.substring(data.indexOf(":") + 2, data.indexOf(","))));
                weeklyCost.add(Double.parseDouble(data.substring(data.indexOf(",") + 2, data.length())));
                //System.out.println(weeklyItemName + " " + weeklyAmount + " " + weeklyCost);
                //System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }
        for(int i = 0; i < itemName.size(); i++) {
            System.out.println(itemName.get(i));
            System.out.println(amount.get(i));
            System.out.println(cost.get(i));
            System.out.println(weeklyItemName.get(i));
            System.out.println(weeklyAmount.get(i));
            System.out.println(weeklyCost.get(i));
        }
        //create menu
        JMenuBar menuBar = new JMenuBar();
        // add the file menu
        JMenu file = new JMenu("File");
        //make the Exit tab
        JMenuItem exit = new JMenuItem("Exit", null);
        //Open tab
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
