import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.*;

public class PizzaMonster {
    private JTextArea statusLabel;
    private JFrame frame;
    private JMenuItem open;
    private JMenuItem weekly;
    private JMenuItem exit;
    private JMenuItem login;
    private JMenuItem addItem;
    private JLabel label;
    private boolean manager = false;

    public PizzaMonster() {
        prepareGUI();
    }

    public static void main(String[] args) {
        PizzaMonster store = new PizzaMonster();
        store.showMenuDemo();
    }

    private void prepareGUI() {
        frame = new JFrame("Lab 12: GUI Exercise");
        frame.setSize(1000,600);
        statusLabel = new JTextArea();
        statusLabel.setBounds(10,30, 400,400);
        statusLabel.setEditable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(statusLabel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void showMenuDemo() {
        String list = "";
        String listWeekly = "";
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
            list = list + String.format("%-10s %10d %.2f \n", itemName.get(i), amount.get(i), cost.get(i));
        }

        //format weekly string
        for(int i = 0; i < weeklyItemName.size(); i++){
            listWeekly = listWeekly + String.format("%-10s %10d %.2f \n", weeklyItemName.get(i), weeklyAmount.get(i), weeklyCost.get(i));
        }

        //create menu
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("Product");
        JMenu man = new JMenu("Manager");
        login = new JMenuItem("Login/Logout", null);
        open = new JMenuItem("Inventory", null);
        open.setActionCommand(list);
        weekly =new JMenuItem("Weekly", null);
        weekly.setActionCommand(listWeekly);
        addItem = new JMenuItem("Add Inven.");
        exit = new JMenuItem("Exit", null);

        //create button
        ButtonListener listen = new ButtonListener();
        open.addActionListener(listen);
        weekly.addActionListener(listen);
        addItem.addActionListener(listen);
        exit.addActionListener(listen);
        login.addActionListener(listen);

        //add menu
        file.add(open);
        file.add(weekly);
        file.add(addItem);
        file.add(exit);

        man.add(login);

        //add file to the menubar
        menuBar.add(file);
        menuBar.add(man);

        // add the menuBar to the window
        frame.setJMenuBar(menuBar);

        // set other things
        frame.setTitle("Simple menu");

        // launch the windwo
        frame.setVisible(true);
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JMenuItem actionSource = (JMenuItem) e.getSource();
            JFrame f=new JFrame();

            if(actionSource.equals(open)){
                statusLabel.setText(e.getActionCommand());
            } else if (actionSource.equals(exit)) {
                System.exit(0);
            }
            else if (actionSource.equals(weekly)) {
                if (manager == true){
                    statusLabel.setText(e.getActionCommand());
                }
                else{
                    JOptionPane.showMessageDialog(f,"Password Incorrect");
                }
            }
            else if (actionSource.equals(login)) {
                if(manager == true){
                    manager = false;
                }
                else {
                    String password = JOptionPane.showInputDialog(f,"Enter Name");
                    if (password.equals(12345)){
                        manager = true;
                    }
                    else{
                        JOptionPane.showMessageDialog(f,"Password Incorrect");
                    }
                }
            }
            else if (actionSource.equals(addItem)){
                if (manager == true){
                    JOptionPane.showInputDialog(f,"Enter Name of Product");
                    JOptionPane.showInputDialog(f,"Enter Amount");
                    JOptionPane.showInputDialog(f,"Enter Price of Individual Item");
                }
                else{
                    JOptionPane.showMessageDialog(f,"Password Incorrect");
                }
            }
        }
    }
}