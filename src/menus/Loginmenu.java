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
                    System.out.println("--------- Profil -------------");
                    int choose = Prints.inputRequiredInt(
                            " " + "\n" +
                                    "1 - Hesaba medaxil " + "\n" +
                                    "2 - Hesabdan mexaric " + "\n" +
                                    "3 - Update " + "\n" +
                                    "4 - Menu " + "\n" +
                                    "5 - Delete " + "\n" +
                                    "6 - Balans " + "\n" +
                                    "7 - Exit " + "\n" +
                                    "         " + "\n" +
                                    "Yuxarıdakılardan birini seçin : "
                    );
                    switch (choose) {
                        case 1:
                            System.out.println("\n" + "-----------Medaxil-------------");
                            methods.medaxil();
                            break;
                        case 2:
                            System.out.println("\n" + "-----------Mexaric-------------");
                            methods.mexaric();
                            break;
                        case 3:
                            System.out.println("\n" + "-----------Update-------------");
                            methods.update();
                            break;
                        case 4:
                            System.out.println("\n" + "-----------Menyuya Qayıdış-------------");
                            return Menu.menu();
                        case 5:
                            System.out.println("\n" + "-----------Delete-------------");
                            methods.delete();
                            break;
                        case 6:
                            System.out.println("\n" + "-----------Balans-------------");
                            user.getBalance();
                            return Loginmenu.menu();
                        case 7:
                            System.exit(-1);
                            break;

                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("!!!");
                System.out.println("Yalnış məlumat qeyd etdiniz. Profil menyusuna yönləndirildiniz. " + "\n");
            }
        }
    }
}
