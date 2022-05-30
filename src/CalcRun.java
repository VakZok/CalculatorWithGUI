public class CalcRun {
    public static void main (String[] args) {
        // generate new object from class calculator
        Calculator calc = new Calculator();
        int result = 0;
        boolean continueCalculation = true;

        // initializing a loop so that calculations can be made over and over again - optional: until the user decides to stop
        do {
            // read from user - choose an operation
            String operation = calc.chooseOperation();

            // testing for valid operation
            // if valid, user input for number 1 and 2 follows
            if (operation.equals("add") | operation.equals("subtract") | operation.equals("multiply")
                    | operation.equals("divide") | operation.equals("modulo") | operation.equals("sum total")
                    | operation.equals("cross sum")) {

                // user input for number one and two
                int number1 = calc.userInput();
                System.out.println("First number: " + number1);
                // if the operation "cross sum" is chosen, input of one number is enough
                if (operation.equals("cross sum")) {
                    result = calc.cross(number1);
                    System.out.println("The cross sum of " + number1 + " = " + result);
                } else {
                    int number2 = calc.userInput();
                    System.out.println("Second number: " + number2);

                    // if-statements to start calculation functions, based on the chosen operation
                    if (operation.equals("add")) {
                        result = calc.add(number1, number2);
                        System.out.println("The sum of " + number1 + " + " + number2 + " = " + result);
                    } else if (operation.equals("subtract")){
                        result = calc.sub(number1, number2);
                        System.out.println("The difference of " + number1 + " - " + number2 + " = " + result);
                    } else if (operation.equals("multiply")) {
                        result = calc.multi(number1, number2);
                        System.out.println("The product of " + number1 + " * " + number2 + " = " + result);
                    } else if (operation.equals("divide")) {
                        result = calc.div(number1, number2);
                        System.out.println("The quotient of " + number1 + " / " + number2 + " = " + result);
                    } else if (operation.equals("modulo")) {
                        result = calc.mod(number1, number2);
                        System.out.println("The modulo of " + number1 + " % " + number2 + " = " + result);
                    } else if (operation.equals("sum total")) {
                        result = calc.sum(number1, number2);
                        System.out.println("The total sum of " + number1 + " till " + number2 + " = " + result);
                    }
                }
            } else {
                System.out.println("Your input is invalid.");
            }

            // asking the user, whether or not he wants to continue calculating
            // continueCalculation=calc.continueCalculation(continueCalculation);
        } while (continueCalculation==true);

    }

}
