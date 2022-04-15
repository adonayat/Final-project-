import javax.swing.*;
import javax.swing.JLabel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.*;

public class PizzaMonster {
    private JTextArea statusLabel;
    private JFrame frame;

    public PizzaMonster() {
        prepareGUI();
    }

    public static void main(String[] args) {
        PizzaMonster store = new PizzaMonster();
        store.showMenuDemo();
    }

    private void prepareGUI() {
        frame = new JFrame("Lab 12: GUI Exercise");
        frame.setSize(400,400);
        statusLabel = new JTextArea();
        statusLabel.setBounds(10,30, 200,200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(statusLabel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void showMenuDemo() {
        String list = "";
        //create ArrayList
        ArrayList<String> itemName = new ArrayList<String>();
        ArrayList<Integer> amount = new ArrayList<Integer>();
        ArrayList<Double> cost = new ArrayList<Double>();
        ArrayList<String> weeklyItemName = new ArrayList<>();
        ArrayList<Integer> weeklyAmount = new ArrayList<Integer>();
        ArrayList<Double> weeklyCost = new ArrayList<Double>();

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

        //format string
        for(int i = 0; i < itemName.size(); i++){
            list = list + String.format(itemName.get(i) + " " + amount.get(i) + " " + cost.get(i) + "\n");
        }

        //create menu
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("Mode");
        JMenuItem open = new JMenuItem("Inventory", null);
        open.setActionCommand(list);
        JMenuItem exit = new JMenuItem("Exit", null);
        exit.setActionCommand("Exit");

        //create button
        ButtonListener listen = new ButtonListener();
        open.addActionListener(listen);
        exit.addActionListener(listen);

        //add menu
        file.add(open);
        file.add(exit);

        //add file to the menubar
        menuBar.add(file);

        // add the menuBar to the window
        frame.setJMenuBar(menuBar);

        // set other things
        frame.setTitle("Simple menu");

        // launch the windwo
        frame.setVisible(true);
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            statusLabel.setText(e.getActionCommand());
        }
        public void Exit(ActionEvent q) {
            if(q.getActionCommand() == "Exit") {
                System.exit(0);
            }
        }
    }
}