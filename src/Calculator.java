import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    //Buttons für die Zahlen 0-9 und das Ergebnis
    //Buttons für die Rechenoperationen
    JButton[] operationButtons = new JButton[8]; //Wir legen ein Array aus 8 Buttons an, für die Rechenoperationen
    // Buttons für die Funktionen
    JButton[] functionButtons = new JButton[2]; //Array for 2 Funktionsbuttons
    JButton deleteButton, clearButton;

    //Attribute zur späteren Übergabe des Userinputs anlegen
    int number1=0, number2=0, result=0;

    //Konstruktor anlegen
    public Calculator() {
        //unser Calculator muss nun zunächst ein Frame (Fenster) erzeugen, in welchem wir unser Textfeld und unsere Buttons platzieren können
        JFrame window = new JFrame("Calculator"); //Frame erzeugen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Frame verlassen beim schließen
        window.setSize(400, 500); //Frame Maßen zuweisen
        window.setLayout(null); //Verhindert das Zerschließen des Fensters, wenn Größenänderung. Aber: bisher keine Anpassung der Elemente

        //nun Teilen wir das Fenster in panels, die wir später befüllen werden
        JPanel[] panels = new JPanel[3];
        JPanel head, center, button;

        //wir bauen das Fenster von oben nach unten auf und starten mit dem Textfeld, in dem die Eignabe des Nutzers erscheint
        JTextField textfield = new JTextField(); //Textfeld anlegen
        textfield.setSize(300, 50); //Textfield Maßen zuweisen
        textfield.setEditable(false); //Eingabe in der Textfeld verbietenS

<<<<<<< Updated upstream
        //nun müssen wir die gewünschten Bauteile noch dem Fenster hinzufügen
        window.add(textfield, BorderLayout.NORTH);

=======
        //Panels erzeugen und Buttons hinzufügen
        //Das erste Panel ist für unsere nummer von 0-9, das erg und negierte Werte (-)
        JPanel numberPanel = new JPanel();
        numberPanel.setLayout();
        //wir erzeugen die numberButtons
        JButton[] numberButtons = new JButton[12];
        for (int i=0; i<=numberPanel.length();){
            numberButtons[i] = new JButton(String.valueOf(i)); //die Buttons werden mit dem Wert als Text erzeugt und dem Array hinzugefügt
        }

        //wir erzeugen die Buttons
        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton moduloButton = new JButton("%");
        JButton crossSumButton = new JButton("blank");
        JButton totalSumButton = new JButton("Sigma");
        JButton equalsButton = new JButton("=");
        //und weiesen diese dem entsprechenden Array zu
        JButton[] operationButtons = new JButton[8]; //Wir legen ein Array aus 11 Buttons an, um nicht jeden Zahl von 0 bis 9 + Ergebnis + negativ einzeln als Button definieren zu müssen
        operationButtons[0] = addButton;
        operationButtons[1] = subtractButton;
        operationButtons[2] = multiplyButton;
        operationButtons[3] = divideButton;
        operationButtons[4] = moduloButton;
        operationButtons[5] = crossSumButton;
        operationButtons[6] = totalSumButton;
        operationButtons[7] = equalsButton;
        //nun fügen wir den Buttons noch einen ActionListener hinzu
        for (int i=0; i<operationButtons.length(); i++){
            operationButtons[i].addActionListener(this);
        }

        //Das zweite Panel ist für unsere Operatoren
        JPanel operationPanel = new JPanel();
        operationPanel.setLayout();
        //wir erzeugen die Buttons
        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton moduloButton = new JButton("%");
        JButton crossSumButton = new JButton("blank");
        JButton totalSumButton = new JButton("Sigma");
        JButton equalsButton = new JButton("=");
        //und weiesen diese dem entsprechenden Array zu
        JButton[] operationButtons = new JButton[8]; //Wir legen ein Array aus 11 Buttons an, um nicht jeden Zahl von 0 bis 9 + Ergebnis + negativ einzeln als Button definieren zu müssen
        operationButtons[0] = addButton;
        operationButtons[1] = subtractButton;
        operationButtons[2] = multiplyButton;
        operationButtons[3] = divideButton;
        operationButtons[4] = moduloButton;
        operationButtons[5] = crossSumButton;
        operationButtons[6] = totalSumButton;
        operationButtons[7] = equalsButton;
        //nun fügen wir den Buttons noch einen ActionListener hinzu
        for (int i=0; i<operationButtons.length(); i++){
            operationButtons[i].addActionListener(this);
        }
>>>>>>> Stashed changes

        //nun müssen wir die gewünschten Bauteile noch dem Fenster hinzufügen und es sichtbar machen
        window.add(textfield);
        window.setVisible(true); //Frame sichtbar machen (erst am Ende, weil sonst Inhalte teilweise erst nach skalieren des Fensters erscheinen
    }
    public static void main(String[] args){
        new Calculator(); //= Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

/* Check
ExitOnClose
ELemente fixieren aber skalieren lassen
Action listener (this) das this verstehen
 */