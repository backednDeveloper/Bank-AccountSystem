package menus;

import AccountSystem.Allmethods2;
import Allmethods.Prints;
import datas.Globaldata;
import objects.User;


import java.util.InputMismatchException;

public class Loginmenu {
    public static int menu() {
        while (true) {
            try {
                for (int i = 0; i < Globaldata.data.length; i++) {
                    User user = Globaldata.data[i];
                    Allmethods2 methods = new Allmethods2();
                    System.out.println("--------- Profile -------------");
                    int choose = Prints.inputRequiredInt(
                            " " + "\n" +
                                    "1 - Adding money to the balance" + "\n" +
                                    "2 - Withdraw money to the balance " + "\n" +
                                    "3 - Update " + "\n" +
                                    "4 - Menu " + "\n" +
                                    "5 - Delete " + "\n" +
                                    "6 - Balance " + "\n" +
                                    "7 - Exit " + "\n" +
                                    "         " + "\n" +
                                    "Choose one of the above : "
                    );
                    switch (choose) {
                        case 1:
                            System.out.println("\n" + "-----------In Money-------------");
                            methods.medaxil();
                            break;
                        case 2:
                            System.out.println("\n" + "-----------Out Money-------------");
                            methods.mexaric();
                            break;
                        case 3:
                            System.out.println("\n" + "-----------Update-------------");
                            methods.update();
                            break;
                        case 4:
                            System.out.println("\n" + "-----------Return Menu-------------");
                            return Menu.menu();
                        case 5:
                            System.out.println("\n" + "-----------Delete-------------");
                            methods.delete();
                            break;
                        case 6:
                            System.out.println("\n" + "-----------Balance-------------");
                            user.getBalance();
                            return Loginmenu.menu();
                        case 7:
                            System.exit(-1);
                            break;

                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("!!!");
                System.out.println(" You have entered incorrect information. You have been redirected to the menu. Start again. " + "\n");
            }
        }
    }
}
