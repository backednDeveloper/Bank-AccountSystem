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
                                "1 - Qeydiyyat " + "\n" +
                                "2 - Giriş " + "\n" +
                                "3 - Exit " + "\n" +
                                "         " + "\n" +
                                "Yuxarıdakılardan birini seçin : "
                );
                switch (choose) {
                    case 1:
                        System.out.println("\n" + "-----------Qeydiyyat-------------");
                        methods.register();
                        break;
                    case 2:
                        System.out.println("\n" + "-----------Giriş-------------");
                        methods.login();
                        break;
                    case 3:
                        System.out.println("\n" + "-----------Sistemdən Çıxış-------------");
                        System.exit(-1);
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("!!!");
                System.out.println("Yalnış məlumat qeyd etdiniz. Menuya yönləndirildiniz. Yenidən başlayın " + "\n");
            }
        }
    }
}
