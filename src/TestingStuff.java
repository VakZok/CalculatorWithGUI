import javax.swing.*;

public class TestingStuff extends Calculations{
    public static void main(String[] args){
        int a = 10;
        int b = 15;
        Calculations calc = new Calculations();
        System.out.println(calc.sum(a, b));
        System.out.println(calc.cross(b));
    }
}
