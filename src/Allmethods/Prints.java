package Allmethods;

import java.util.Scanner;

public class Prints {
    public static String inputRequiredString(String title) {
        Scanner input = new Scanner(System.in);
        System.out.print(title);
        return input.nextLine();
    }

    public static int inputRequiredInt(String title) {
        Scanner input = new Scanner(System.in);
        System.out.print(title);
        return input.nextInt();
    }
}
