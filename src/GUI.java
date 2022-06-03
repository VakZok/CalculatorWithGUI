import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    //Buttons definieren
    JButton addButton = new JButton();
    JButton subtractButton = new JButton();
    JButton multiplyButton = new JButton();
    JButton divideButton = new JButton();
    JButton moduloButton = new JButton();
    JButton totalSumButton = new JButton();
    JButton crossSumButton = new JButton();

    //Interface Konstruktor
    public GUI(){
        //Titel für Frame/GUI/Fenster festlegen
        super("Calculator");

        //GUI(Frame) erzeugen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);

        //Buttons im GUI implementieren
        //add
        addButton.setBounds(50, 50, 50, 50);
        addButton.setText("+");
        addButton.addActionListener(a -> System.out.println("+"));
        //substract
        subtractButton.setBounds(50, 50, 50, 50);
        subtractButton.setText("-");
        subtractButton.addActionListener(s -> System.out.println("-"));
        //multiply
        multiplyButton.setBounds(50, 50, 50, 50);
        multiplyButton.setText("*");
        multiplyButton.addActionListener(m -> System.out.println("*"));
        //divide
        divideButton.setBounds(50, 50, 50, 50);
        divideButton.setText("/");
        divideButton.addActionListener(d -> System.out.println("/"));
        //module
        moduloButton.setBounds(50, 50, 50, 50);
        moduloButton.setText("%");
        moduloButton.addActionListener(m -> System.out.println("%"));
        //totalSum
        totalSumButton.setBounds(50, 50, 50, 50);
        totalSumButton.setText("q");
        totalSumButton.addActionListener(t -> System.out.println("q"));
        //crossSum
        crossSumButton.setBounds(50, 50, 50, 50);
        crossSumButton.setText("Σ");
        crossSumButton.addActionListener(c -> System.out.println("Σ"));

        //Buttons dem Frame (GUI) hinzufügen
        this.add(addButton);
        this.add(subtractButton);
//        this.add(multiplyButton);
//        this.add(divideButton);
//        this.add(moduloButton);
//        this.add(totalSumButton);
//        this.add(crossSumButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Test");
    }
}