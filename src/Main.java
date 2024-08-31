import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Introduzca una operacion:");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        Operation op = new Operation(sentence);

        try {
            op.parseInput();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }

        System.out.println(op.getResult());
    }
}