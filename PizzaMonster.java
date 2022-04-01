import javax.swing.*;

public class PizzaMonster {
    private static JFrame frame;

    public static void main(String[] args) {

        frame = new JFrame("Lab 12: GUI Exercise");
        //set size of window
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create menu
        JMenuBar menuBar = new JMenuBar();
        // add the file menu
        JMenu file = new JMenu("File");
        //make the Exit tab
        JMenuItem exit = new JMenuItem("Exit", null);
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
