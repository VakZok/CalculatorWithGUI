public class Calculations {
    //Instanzvariable
    int result = 0;

    //Methoden
    public int add(int number1, int number2) {
        result = number1 + number2;	// this.result refers to the attribute of the current class (Calculator) and gives the local variable 'result' (from function 'add') to the attribute
        return result;
    }

    // function to subtract two numbers
    public int sub(int number1, int number2) {
        result=number1-number2;
        return result;
    }

    // function to multiply two numbers
    public int multi(int number1, int number2) {
        result=number1*number2;
        return result;
    }

    // function to divide two numbers
    public int div(int number1, int number2) {
        result=number1/number2;
        return result;
    }

    // function to calculate the residual value (Restwert) [modulo]
    public int mod(int number1, int number2) {
        result=number1%number2;
        return result;
    }

    // function to calculate the total sum of all number from the first to the last number
    public int sum(int number1, int number2) {
        result=number1;
        while(number1<number2) {
            number1++;
            result += number1;
        }
        return result;
    }

    // function to calculate the cross sum (Quersumme); Warning: Is not programmed for negative numbers!
    public int cross(int number) {
        int digit = 0;
        int quer = 0;
        while (number>0) {
            digit=number%10; 		// through modulo 10, the last digit is always split of as a rest
            quer=quer+digit; 	// the split of (last) digit is added to the result (cross sum)
            number=number/10; 		// because the variable "number" is an integer, dividing by 10 cuts of the last digit (it is not rounded)
        } // local variable number is not reset after while. Is it only reset after a function ends?
        return result = quer;
    }
}
