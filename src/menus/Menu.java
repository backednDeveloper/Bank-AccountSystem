package menus;

import AccountSystem.Allmethods2;
import Allmethods.Prints;

import java.util.InputMismatchException;

public class Menu {
    public static int menu() {
        while (true) {
            try {
                Allmethods2 methods = new Allmethods2();
                int choose = Prints.inputRequiredInt(
                        " " + "\n" +
                                "1 - Register " + "\n" +
                                "2 - Login " + "\n" +
                                "3 - Exit " + "\n" +
                                "         " + "\n" +
                                "Choose one of the above : "
                );
                switch (choose) {
                    case 1:
                        System.out.println("\n" + "-----------Register-------------");
                        methods.register();
                        break;
                    case 2:
                        System.out.println("\n" + "-----------Login-------------");
                        methods.login();
                        break;
                    case 3:
                        System.out.println("\n" + "-----------Exit System-------------");
                        System.exit(-1);
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("!!!");
                System.out.println(" You have entered incorrect information. You have been redirected to the menu. Start again. " + "\n");
            }
        }
    }
}
