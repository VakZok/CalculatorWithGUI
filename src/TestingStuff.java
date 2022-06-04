import javax.swing.*;

public class TestingStuff {
    public static void main(String[] args){
        JButton[] numberButtons = new JButton[12];
        //Buttons von 0-9 erzeugen
        for (int i=0; i<numberButtons.length-2; i++){ //
            numberButtons[i] = new JButton(String.valueOf(i)); //die Buttons werden mit dem Wert als Text erzeugt und dem Array hinzugefügt
            System.out.println(numberButtons[i].getText());
        }
    }
}
