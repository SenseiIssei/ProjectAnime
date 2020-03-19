package projectanime.util;

import java.util.Scanner;

public class InputCheck {
    private InputCheck() {
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String readConsole() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println();
        return input;
    }

    public static char getFirstChar(String input) {
        return input.charAt(0);
    }

    public static int readInt() {
        String input = readConsole();
        while (!isNumeric(input)) {
            System.out.println("Number expected!");
            input = readConsole();
        }
        return Integer.parseInt(input);
    }
}
