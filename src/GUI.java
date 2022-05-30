import javax.swing.JFrame;
import javax.swing.JButton;

public class GUI extends JFrame {
    public GUI(){
        super("Calculator");

        //Buttons erzeugen
        //Button "add"
        JButton addButton = new JButton();
        addButton.setBounds(50, 50, 50, 50);
        //Button "add"
        JButton subtractButton = new JButton();
        subtractButton.setBounds(50, 50, 50, 50);
        //Button "add"
        JButton multiplyButton = new JButton();
        multiplyButton.setBounds(50, 50, 50, 50);
        //Button "add"
        JButton divideButton = new JButton();
        divideButton.setBounds(50, 50, 50, 50);
        //Button "add"
        JButton moduloButton = new JButton();
        moduloButton.setBounds(50, 50, 50, 50);
        //Button "add"
        JButton totalSumButton = new JButton();
        totalSumButton.setBounds(50, 50, 50, 50);
        JButton crossSumButton = new JButton();
        crossSumButton.setBounds(50, 50, 50, 50);

        //GUI(Frame) erzeugen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 500);
        setVisible(true);
        //Buttons hinzufügen
        add(addButton);
//        add(subtractButton);
//        add(multiplyButton);
//        add(divideButton);
//        add(moduloButton);
//        add(totalSumButton);
//        add(crossSumButton);
    }
}