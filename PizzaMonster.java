import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.*;
import java.util.Random;

public class PizzaMonster {
    private JTextArea statusLabel;
    private JFrame frame;
    private JMenuItem open;
    private JMenuItem weekly;
    private JMenuItem exit;
    private JMenuItem login;
    private JMenuItem addItem;
    private JLabel productName;
    private JTextField name;
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
        frame.setSize(800,600);
        statusLabel = new JTextArea();
        statusLabel.setBounds(10,30, 400,400);
        statusLabel.setEditable(false);

        productName = new JLabel("Name of Order");
        productName.setBounds(524, 50, 100,30);

        name = new JTextField();
        name.setBounds(524, 75, 180, 19);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(statusLabel);
        frame.add(productName);
        frame.add(name);
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
            for(int j = 0; j > -1; j++)
            {
                String end = scan.nextLine();
                if (end.equals("end"))
                {
                    break;
                }
                for(int i = 0; i < 1; i++)
                {
                    itemName.add(end);
                    amount.add(Integer.parseInt(scan.nextLine()));
                    double c = Double.parseDouble(scan.nextLine());
                    cost.add(c);
                    scan.nextLine();
                    weeklyItemName.add(end);
                    Random rn = new Random();
                    weeklyAmount.add(rn.nextInt(30)+1);
                    weeklyCost.add(c);

                }
                if(scan.hasNext()){}
                else
                {
                    break;
                }
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

            //print inventory
            if(actionSource.equals(open))
                statusLabel.setText(e.getActionCommand());
            else if (actionSource.equals(exit)) //ends program
                System.exit(0);
            else if (actionSource.equals(weekly)) { //print results
                if (manager == true)
                    statusLabel.setText(e.getActionCommand());
                else
                    JOptionPane.showMessageDialog(f,"You do not have Access");
            }
            else if (actionSource.equals(login)) { //makes user manager
                if(manager == true)
                    manager = false;
                else { //check if user knows password
                    String password = JOptionPane.showInputDialog(f,"Enter Password");
                    //set them as manager
                    String p = "12345";
                    if (password.equals(p))
                        manager = true;
                    else
                        JOptionPane.showMessageDialog(f,"Password Incorrect");
                }
            }
            else if (actionSource.equals(addItem)){
                if (manager == true){
                    JOptionPane.showInputDialog(f,"Enter Name of Product");
                    JOptionPane.showInputDialog(f,"Enter Amount");
                    JOptionPane.showInputDialog(f,"Enter Price of Individual Item");
                }
                else
                    JOptionPane.showMessageDialog(f,"You do not have Access");
            }
        }
    }
}