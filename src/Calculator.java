import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    //Textfield anlegen in dem die Eingabe des Nutzers erscheint
    JTextField textfield = new JTextField(); //Textfeld anlegen
    //Wir legen ein Array aus 11 Buttons an, um nicht jeden Zahl von 0 bis 9 + Ergebnis + negativ einzeln als Button definieren zu müssen
    JButton[] operationButtons = new JButton[8]; //Wir legen ein Array aus 11 Buttons an, um nicht jeden Zahl von 0 bis 9 + Ergebnis + negativ einzeln als Button definieren zu müssen
    //wir erzeugen die numberButtons, weisen Sie dem Array hinzugeben, geben ihnen einen ActionListener und fügen sie dem numberPanel hinzu
    JButton[] numberButtons = new JButton[10];
    //nun müssen wir noch neg, ans, del und clear anlegen
    JButton negate = new JButton("(-)");
    JButton answer = new JButton("Ans");
    JButton clear = new JButton("Clear");
    JButton delete = new JButton("Del");
    //Attribute zur späteren Übergabe des Userinputs anlegen
    int number1=0, number2=0, result=0;

    //Konstruktor anlegen
    public Calculator() {
        //unser Calculator muss nun zunächst ein Frame (Fenster) erzeugen, in welchem wir unser Textfeld und unsere Buttons platzieren können
        JFrame window = new JFrame("Calculator"); //Frame erzeugen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Frame verlassen beim schließen
        window.setSize(500, 500); //Frame Maßen zuweisen
        window.setLayout(new BorderLayout()); //Wir geben dem Fenster ein Border Layout

        //Panels erzeugen; Textfeld und Buttons hinzufügen
        //Textfeld
        //wir bauen das Fenster von oben nach unten auf und starten mit dem ersten Panel, welches sich im head (north) befindet
        JPanel textPanel = new JPanel();
        //wir stellen das Textfeld entsprechend ein
        textfield.setSize(300, 150); //Textfield Maßen zuweisen
        textfield.setEditable(false); //Eingabe in das Textfeld verbieten
        //und fügen das Textfeld dem textPanel hinzu
        textPanel.add(textfield);

        //Numbers
        //Das zweite Panel ist für unsere nummer von 0-9, das erg und negierte Werte (-). Es wird im Center liegen
        JPanel numberPanel = new JPanel(new GridLayout(4,3)); //wir geben dem panel ein Grid mit 4 Zeilen und 3 Spalte
        numberPanel.setBackground(Color.DARK_GRAY);

        //Buttons von 0-9 erzeugen
        for (int i=0; i<numberButtons.length; i++){ //
            numberButtons[i] = new JButton(String.valueOf(i)); //die Buttons werden mit dem Wert als Text erzeugt und dem Array hinzugefügt
        }
        //numberButtons den ActionListener zuweisen
        for (JButton numberButton : numberButtons) {
            numberButton.addActionListener(this);
        }
        //wir müssen dem ans und neg Button noch einen actionlistener zuweisen
        negate.addActionListener(this);
        answer.addActionListener(this);
        //und manuell dem Grid zuweisen, damit ein realitätsgetreues Grid Testenfeld entsteht
        numberPanel.add(numberButtons[7]);
        numberPanel.add(numberButtons[8]);
        numberPanel.add(numberButtons[9]);
        numberPanel.add(numberButtons[4]);
        numberPanel.add(numberButtons[5]);
        numberPanel.add(numberButtons[6]);
        numberPanel.add(numberButtons[1]);
        numberPanel.add(numberButtons[2]);
        numberPanel.add(numberButtons[3]);
        numberPanel.add(negate);
        numberPanel.add(numberButtons[0]);
        numberPanel.add(answer);

        //das dritte Panel ist für unsere Operatoren und wird sich rechts anordnen
        JPanel operationPanel = new JPanel(new GridLayout(4,2)); //das operationPanel bekommt 4 Zeile und zwei Reihen
        operationPanel.setBackground(Color.BLUE);
        //wir erzeugen unsere operationButtons
        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton moduloButton = new JButton("%");
        JButton crossSumButton = new JButton("blank");
        JButton totalSumButton = new JButton("Sigma");
        JButton equalsButton = new JButton("=");
        //und weiesen diese dem entsprechenden Array zu
        operationButtons[0] = addButton;
        operationButtons[1] = subtractButton;
        operationButtons[2] = multiplyButton;
        operationButtons[3] = divideButton;
        operationButtons[4] = moduloButton;
        operationButtons[5] = crossSumButton;
        operationButtons[6] = totalSumButton;
        operationButtons[7] = equalsButton;
        //nun fügen wir den Buttons noch einen ActionListener hinzu und adden sie dem operationPanel
        for (JButton operationButton : operationButtons) {
            operationButton.addActionListener(this);
            operationPanel.add(operationButton);
        }

        //Das vierte und letzte Panel ist für unsere functionButtons und befindet sich unten
        JPanel functionPanel = new JPanel(new GridLayout(1,2)); //functionPanel bekommt 1 Zeile und 2 Reihen
        functionPanel.setBackground(Color.GREEN);
        //wir geben den function Buttons ebenfalls einen actionListener und fügen sie dem functionPanel hinzu
        delete.addActionListener(this);
        clear.addActionListener(this);
        functionPanel.add(delete);
        functionPanel.add(clear);


        //nun müssen wir die gewünschten Bauteile noch dem Fenster hinzufügen und es sichtbar machen
        window.add(textfield, BorderLayout.NORTH);
        window.add(numberPanel, BorderLayout.CENTER);
        window.add(operationPanel, BorderLayout.EAST);
        window.add(functionPanel, BorderLayout.SOUTH);
        window.setVisible(true); //Frame sichtbar machen (erst am Ende, weil sonst Inhalte teilweise erst nach skalieren des Fensters erscheinen
    }
    public static void main(String[] args){
        new Calculator(); //= Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //im Falle eines gedrückten Buttons muss angegeben werden,was passieren soll --> if für jeden Button
        //Wir beginnen mit der Ausgabe der Werte im Textfeld (Strings)
        //zuerst prüfen wir, ob der input einem numberButton entspricht
        //dazu gehen wir mit einer foreach alle number buttons durch
        for (JButton numberbutton : numberButtons) {
            if (e.getSource() == numberbutton) { //getsource übergibt hierbei das Objekt (den Button)
                textfield.setText(textfield.getText().concat(numberbutton.getText())); //das Textfeld holt seinen bereits vorhandenen Text und den Text des gedrückten Buttons, und fügt diesen mit concat hinten an
            }
        }
        //das gleiche müssen wir für die operationButtons machen
        for (JButton operationButton : operationButtons) {
            if (e.getSource() == operationButton) {
                textfield.setText(textfield.getText().concat(operationButton.getText()));
            }
        }
        //nun kümmenr wir uns noch um negate, ans, del udn clear
        if (e.getSource() == clear) {
            textfield.setText(""); //wir setzten das Eingabefeld als leer
        }

    }
}

/* Check
ExitOnClose
ELemente fixieren aber skalieren lassen
Action listener (this) das this verstehen
 */