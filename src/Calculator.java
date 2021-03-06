import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    //Textfield
    JTextField textfield = new JTextField(); //Textfield anlegen in dem die Eingabe des Nutzers erscheint

    //Number Buttons
    JButton[] numberButtons = new JButton[10]; //wir erzeugen ein Array für unsere Number Buttons

    //Ans und Random
    JButton randomNumber = new JButton("⤨");
    JButton answer = new JButton("Ans");

    //Operation Buttons
    JButton[] operationButtons = new JButton[8]; //wir erzeugen ein Array für unsere Operation Buttons
    JButton addButton = new JButton("+"); //die Buttons werden mit darauf erscheinendem Bild implementiert
    JButton subtractButton = new JButton("-");
    JButton multiplyButton = new JButton("*");
    JButton divideButton = new JButton("/");
    JButton moduloButton = new JButton("%");
    JButton crossSumButton = new JButton("quer");
    JButton totalSumButton = new JButton("sum");
    JButton equalsButton = new JButton("=");

    //Clear und Delete
    JButton clear = new JButton("Clear");
    JButton delete = new JButton("Del");

    //Attribute zur späteren Übergabe des Userinputs
    int number1=0, number2=0, result=0;
    String operator;

    //Wir fügen zwei Fonts hinzu, um alles besser lesbar zu machen
    Font myTextfieldFont = new Font("", Font.BOLD, 50);
    Font myButtonFont = new Font("", Font.BOLD, 17);

    //Konstruktor
    public Calculator() {

        //Window
        //unser Calculator muss nun zunächst ein Frame (Fenster) erzeugen, in welchem wir unser Textfeld und unsere Buttons platzieren können
        JFrame window = new JFrame("Calculator"); //Frame erzeugen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Frame verlassen beim schließen
        window.setSize(500, 500); //Frame Maßen zuweisen
        window.setLayout(new BorderLayout()); //Wir geben dem Fenster ein Border Layout


        //Textfield
        //wir bauen das Fenster von oben nach unten auf und starten mit dem ersten Panel, welches sich im head (north) befindet
        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.LIGHT_GRAY);
        textfield.setSize(300, 500); //Textfield Maßen zuweisen
        textfield.setFont(myTextfieldFont); //wir fügen unser Font hinzu
        textPanel.add(textfield); //Textfeld dem Text Panel hinzufügen


        //Numbers
        //Das zweite Panel ist für unsere Nummern von 0-9, erg und negierte Werte (-). Es wird im Center liegen
        JPanel numberPanel = new JPanel(new GridLayout(4,3, 5, 5)); //wir geben dem panel ein Grid mit 4 Zeilen und 3 Spalte und die Buttons haben jeweils 5 Pixel Abstand zueinander
        numberPanel.setBackground(Color.LIGHT_GRAY);

        //Number Buttons Text und Actionlistener
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i)); //wir weisen den Number Buttons ihren Text zu
            numberButtons[i].setFont(myButtonFont);
            numberButtons[i].addActionListener(this); //und geben ihnen den Actionlistener
        }

        //random und answer Font und ActionListener
        randomNumber.setFont(myButtonFont);
        answer.setFont(myButtonFont);
        randomNumber.addActionListener(this);
        answer.addActionListener(this);

        //Buttons manuell dem Grid hinzufügen --> realitätsgetreu
        numberPanel.add(numberButtons[7]);
        numberPanel.add(numberButtons[8]);
        numberPanel.add(numberButtons[9]);
        numberPanel.add(numberButtons[4]);
        numberPanel.add(numberButtons[5]);
        numberPanel.add(numberButtons[6]);
        numberPanel.add(numberButtons[1]);
        numberPanel.add(numberButtons[2]);
        numberPanel.add(numberButtons[3]);
        numberPanel.add(randomNumber);
        numberPanel.add(numberButtons[0]);
        numberPanel.add(answer);


        //Operations
        //das dritte Panel ist für unsere Operatoren und wird sich rechts anordnen
        JPanel operationPanel = new JPanel(new GridLayout(4,2, 5 ,5)); //das operationPanel bekommt 4 Zeile und 2 Spalten
        operationPanel.setBackground(Color.LIGHT_GRAY);

        //wir weisen die Operations Buttons dem Array hinzu
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
            operationButton.setFont(myButtonFont);
            operationButton.setBackground(Color.ORANGE); // um die Function Buttons abzuheben geben wir ihnen noch eine andere Farbe
            operationPanel.add(operationButton);
        }

        //Functions
        //Das vierte und letzte Panel ist für unsere functionButtons und befindet sich unten
        JPanel functionPanel = new JPanel(new GridLayout(1,2)); //functionPanel bekommt 1 Zeile und 2 Spalten
        textPanel.setBackground(Color.LIGHT_GRAY);

        //wir geben den function Buttons ebenfalls einen actionListener und fügen sie dem functionPanel hinzu
        delete.setFont(myButtonFont);
        clear.setFont(myButtonFont);
        delete.addActionListener(this);
        clear.addActionListener(this);
        functionPanel.add(delete);
        functionPanel.add(clear);

        //Adding Panels to Window
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
    public void actionPerformed(ActionEvent e) { //im Falle eines gedrückten Buttons muss angegeben werden,was passieren soll --> if für jeden Button / Gruppe von Buttons

        //Wir erzeugen ein Objekt vom Typ Calculations, über das die Rechenoperationen aufgerufen werden
        Calculations calc = new Calculations();

        //Es wird quasi das Objekt der Ursache zurückgegeben und gegen alle möglichen Objekte (Buttons) verglichen
        //Umgesetzt wird die entsprechende Behandlung im Falle von Objekt (Button) XY

        //Überprüfen auf Number Buttons
        for (JButton numberbutton : numberButtons) { //eine for-each Schleife iteriert durch jeden numberButton
            if (e.getSource() == numberbutton) { // verglichen wird das ActionEvent e mit jedem Objekt des Arrays numberButtons (via getSource, welches das Objekt der Ursache von dem ActionEvent e zurückgibt)
                textfield.setText(textfield.getText().concat(numberbutton.getText())); //das Textfeld holt seinen bereits vorhandenen Text und den Text des gedrückten Buttons, und fügt diesen mit concat hinten an
            }
        }

        //Random und Ans
        if (e.getSource() == randomNumber) {
            textfield.setText(String.valueOf(calc.random())); //dann wandeln wir den Wert in einen String und geben ihn aus
        }
        if (e.getSource() == answer) {
            textfield.setText(String.valueOf(result));
        }

        //als nächstes implementieren wir die Aktionen der einzelnen Funktionsbuttons (Rechenoperatoren)
        //Wird ein operation button (exklusive crossSum) gedrückt so wird der Wert des Tetfeldes der ersten Variable übergeben. Das textfeld wird anschließend geleert
        if (e.getSource() == addButton) {
            number1 = Integer.parseInt(textfield.getText()); //wir weisen der Instanzvariable den ersten Userinput zu
            operator = addButton.getText(); //Operatoren für die switch Anweisung hinzufügen
            textfield.setText(""); //und clearen den Inhalt des Textfeldes
        } else if (e.getSource() == subtractButton) {
            number1 = Integer.parseInt(textfield.getText());
            operator = subtractButton.getText();
            textfield.setText("");
        } else if (e.getSource() == multiplyButton) {
            number1 = Integer.parseInt(textfield.getText());
            operator = multiplyButton.getText();
            textfield.setText("");
        } else if (e.getSource() == divideButton) {
            number1 = Integer.parseInt(textfield.getText());
            operator = divideButton.getText();
            textfield.setText("");
        } else if (e.getSource() == moduloButton) {
            number1 = Integer.parseInt(textfield.getText());
            operator = moduloButton.getText();
            textfield.setText("");
        } else if (e.getSource() == totalSumButton) {
            number1 = Integer.parseInt(textfield.getText());
            operator = totalSumButton.getText();
            textfield.setText("");
        } else if (e.getSource() == crossSumButton) { //bei cross sum und total sum wird die Rechnenoperation sofort ausgeführt, weil diese nur einen einzigen Input haben
            textfield.setText(String.valueOf(calc.cross(Integer.parseInt(textfield.getText()))));
            result=Integer.parseInt(textfield.getText()); //auch bei Quersumme soll die Answer wiederverwendbar sein
        }

        if (e.getSource() == equalsButton) {
            number2 = Integer.parseInt(textfield.getText()); //bei euqals wird der zweiten Variablen ein Wert zugeschrieben. Bis dahin wird immer die erste pberschrieben

            switch (operator) { //Rechenoperationen durchführen mittels Lambda expressions
                case "+" -> result = calc.add(number1, number2);
                case "-" -> result = calc.sub(number1, number2);
                case "*" -> result = calc.multi(number1, number2);
                case "/" -> result = calc.div(number1, number2);
                case "%" -> result = calc.mod(number1, number2);
                case "sum" -> result = calc.sum(number1, number2);
            }
            textfield.setText(String.valueOf(result)); //Wir wandeln das Ergebnis wieder in einen String, den wir dann im Textfeld ausgeben
        }

        //nun kümmenrn wir uns noch um ans, del und clear
        if (e.getSource() == clear) {
            textfield.setText(""); //wir setzten das Eingabefeld als leer
        }

        if (e.getSource() == delete) {
            textfield.setText(textfield.getText().substring(0, textfield.getText().length()-1));
        }
    }
}

/* Check
Action listener (this) das this verstehen
Warum kann ich in der Klasse nicht auf die dort angelegte Länge eines Arrays zugreifen, aber untergeordnet im Konstruktor schon?
 */