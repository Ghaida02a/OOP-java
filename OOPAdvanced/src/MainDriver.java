import java.util.Scanner;

public class MainDriver {
    static ScientificCalculator calculator = new ScientificCalculator();
    static Scanner scanner = new Scanner(System.in);
    public static Integer mainMenuOption = 0;
    public static void main(String[] args) {
        while (mainMenuOption != 13){
            showMainMenu();
            mainMenuOption = scanner.nextInt();
            scanner.nextLine();
            if(mainMenuOption == 1){
                performAddition();
            } else if (mainMenuOption == 2) {
                performSubtraction();
            } else if (mainMenuOption == 3) {
                performMultiplication();
            } else if (mainMenuOption == 4) {
                performDivision();
            } else if (mainMenuOption == 5) {
                performPower();
            } else if (mainMenuOption == 6) {
                performSquareRoot();
            } else if (mainMenuOption == 7) {
                performSine();
            } else if (mainMenuOption == 8) {
                performCosine();
            } else if (mainMenuOption == 9) {
                performTangent();
            } else if (mainMenuOption == 10) {
                performLogarithm();
            } else if (mainMenuOption == 11) {
                performNaturalLog();
            } else if (mainMenuOption == 12) {
                displayLastResult();
            } else if (mainMenuOption ==13) {
                System.out.println("Exiting...");
            }
            else{
                System.out.print("Invalid option, re-enter another valid option: ");
                mainMenuOption = scanner.nextInt();
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("===== Scientific Calculator Menu =====");
        System.out.print("""
                1. Add
                2. Subtract
                3. Multiply
                4. Divide
                5. Power
                6. Square Root
                7. Sine
                8. Cosine
                9. Tangent
                10. Logarithm (base 10)
                11. Natural Log (ln)
                12. Show Last Result
                13. Exit
                """);
        System.out.println("===============");
        System.out.print("Please enter your choice: ");
    }

    public static void performAddition(){
        System.out.println("To Add");
        System.out.print("Please enter first number: ");
        Double firstNumber = scanner.nextDouble();
        System.out.print("Please enter second number: ");
        Double secondNumber = scanner.nextDouble();
        Double addFunction = calculator.add(firstNumber, secondNumber);
        System.out.println("The Addition Result is: " + addFunction);
        calculator.setLastResult(addFunction);
    }

    public static void performSubtraction(){
        System.out.println("To Subtract");
        System.out.print("Please enter first number: ");
        Double firstNumber = scanner.nextDouble();
        System.out.print("Please enter second number: ");
        Double secondNumber = scanner.nextDouble();
        Double subtractFunction = calculator.subtract(firstNumber, secondNumber);
        System.out.println("The Subtraction Result is: " + subtractFunction);
        calculator.setLastResult(subtractFunction);

    }

    public static void performMultiplication(){
        System.out.println("To Multiply");
        System.out.print("Please enter first number: ");
        Double firstNumber = scanner.nextDouble();
        System.out.print("Please enter second number: ");
        Double secondNumber = scanner.nextDouble();
        Double multiplyFunction = calculator.multiply(firstNumber, secondNumber);
        System.out.println("The Multiply Result is: " + multiplyFunction);
        calculator.setLastResult(multiplyFunction);
    }

    public static void performDivision(){
        System.out.println("To Divide");
        System.out.print("Please enter a number to divide it: ");
        Double divideTo = scanner.nextDouble();
        System.out.print("Please enter a number to divide by: ");
        Double divideBy = scanner.nextDouble();
        while (divideTo == 0 || divideTo < divideBy || divideTo == null){
            System.out.print(divideTo + " Invalid number, please re-enter a valid number: ");
            divideTo = scanner.nextDouble();
        }
        Double divide = calculator.divide(divideTo, divideBy);
        System.out.println("The Division Result is: " + divide);
        calculator.setLastResult(divide);
    }

    public static void performPower(){
        System.out.println("To Power");
        System.out.print("Please enter base number: ");
        Double baseNumber = scanner.nextDouble();
        System.out.print("Please enter power number: ");
        Double powerNumber = scanner.nextDouble();
        Double power = calculator.power(baseNumber, powerNumber);
        System.out.println("The Power Result is: " + power);
        calculator.setLastResult(power);
    }

    public static void performSquareRoot(){
        System.out.println("To perform Square Root");
        System.out.print("Please enter number: ");
        Double numberToSquare = scanner.nextDouble();
        Double squareRoot = calculator.squareRoot(numberToSquare);
        System.out.println("The SquareRoot Result of " + numberToSquare + " is " + squareRoot);
        calculator.setLastResult(squareRoot);
    }

    public static void performSine(){
        System.out.println("To perform Sine");
        System.out.print("Please enter an angle in Degrees: ");
        Double userInput = scanner.nextDouble();
        Double sine = calculator.sine(userInput);
        System.out.println("The Sine of " + userInput + "is: " + sine);
        calculator.setLastResult(sine);
    }

    public static void performCosine(){
        System.out.println("To perform Cosine");
        System.out.print("Please enter an angle in Degrees: ");
        Double userInput = scanner.nextDouble();
        Double cos = calculator.cosine(userInput);
        System.out.println("The Cosine of " + userInput + "is: " + cos);
        calculator.setLastResult(cos);
    }

    public static void performTangent(){
        System.out.println("To perform Tangent");
        System.out.print("Please enter an angle in Degrees: ");
        Double userInput = scanner.nextDouble();
        Double tan = calculator.tangent(userInput);
        System.out.println("The Tangent of " + userInput + "is: " + tan);
        calculator.setLastResult(tan);
    }

    public static void performLogarithm(){
        System.out.println("To perform Logarithm");
        System.out.print("Please enter a number: ");
        Double userInput = scanner.nextDouble();
        Double log = calculator.logarithm(userInput);
        System.out.println("The Logarithm of " + userInput + "is: " + log);
        calculator.setLastResult(log);
    }

    public static void performNaturalLog(){
        System.out.println("To perform Natural Log");
        System.out.print("Please enter a number: ");
        Double userInput = scanner.nextDouble();
        Double naturalLog = calculator.naturalLog(userInput);
        System.out.println("The Natural Log of " + userInput + "is: " + naturalLog);
        calculator.setLastResult(naturalLog);
    }

    public static void displayLastResult(){
        System.out.println("Display Last Result in calculator: " + calculator.getLastResult());
    }
}