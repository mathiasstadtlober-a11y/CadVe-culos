import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String readln(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static int readInt(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(readln(mensagem));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    public static void close() {
        scanner.close();
    }
}
