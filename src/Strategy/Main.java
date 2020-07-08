package Strategy;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setOperation(new OperationAdd());
        int result = calculator.doOperation(3,2);
        System.out.println(result);
    }
}
