import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    //Buttons für die Zahlen 0-9 und das Ergebnis
    JButton[] numberButtons = new JButton[11]; //Wir legen ein Array aus 11 Buttons an, um nicht jeden Zahl von 0 bis 9 + Ergebnis einzeln als Button definieren zu müssen
    //Buttons für die Rechenoperationen
    JButton[] operationButtons = new JButton[8]; //Wir legen ein Array aus 8 Buttons an, für die Rechenoperationen
    JButton addButton, subtractButton, multiplyButton, divideButton, moduloButton, crossSumButton, totalSumButton, equalsButton;
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
        window.setVisible(true); //Frame sichtbar machen

        //wir bauen das Fenster von oben nach unten auf und starten mit dem Textfeld, in dem die Eignabe des Nutzers erscheint
        JTextField textfield = new JTextField(); //Textfeld anlegen
        textfield.setSize(300, 50);


        //nun müssen wir die gewünschten Bauteile noch dem Fenster hinzufügen
        window.add(textfield);

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

 */