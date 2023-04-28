package AccountSystem;

import Allmethods.Prints;
import datas.Globaldata;
import menus.Loginmenu;
import menus.Menu;
import objects.User;

import java.util.Locale;


public class Allmethods2 implements Allmethods {

    @Override
    public int register() {
        int accountnumbers = Prints.inputRequiredInt("Girmek istediyiniz account sayini yazin : ");
        Globaldata.data = new User[accountnumbers];
        for (int i = 0; i < accountnumbers; i++) {
            System.out.println("Məlumatların daxil edilməsi : ");
            String name = Prints.inputRequiredString("\nAdınızı daxil edin : ");
            String surname = Prints.inputRequiredString("Soyadınızı daxil edin : ");
            int age = Prints.inputRequiredInt("Yaşınızı qeyd edin : ");
            int passwordin = Prints.inputRequiredInt("Şifrənizi daxil edin : ");
            int passwordin2 = Prints.inputRequiredInt("Şifrəni yenidən daxil edin : ");
            System.out.println("-----------------------------");
            boolean password = false;
            if (passwordin == passwordin2) {
                System.out.println("Şifrəniz təsdiqləndi ");
                password = true;
            }
            if (!password) {
                System.out.println("Yalnış şifrə girdiniz " + "\n");
                return register();
            }
            String ID = Prints.inputRequiredString("ID zi daxil edin : ");
            User user = new User(name, surname, age, passwordin2, ID);

            boolean isDuplicateID = false;
            for (int j = 0; j < i; j++) {
                if (Globaldata.data[j].getID().equals(ID)) {
                    isDuplicateID = true;
                    break;
                }
            }
            if (isDuplicateID) {
                System.out.println(ID + " qeydiyyat nömrəli istifadəçi mövcuddur.\n");
                return register();
            } else {
                Globaldata.data[i] = user;
                System.out.println("\nQeydiyyata alınan yeni istifadəçi məlumatları : ");
                Globaldata.data[i].getInfo();
            }
        }
        return Menu.menu();
    }

    @Override
    public int delete() {
        try {
            String ID = Prints.inputRequiredString("ID nizi qeyd edin : ");
            int password = Prints.inputRequiredInt("Şifrənizi qeyd edin : ");
            boolean found = true;
            for (int i = 0; i < Globaldata.data.length; i++) {
                User user = Globaldata.data[i];
                if (user.getPassword() == password && user.getID().contains(ID)) {
                    Globaldata.data[i] = null;
                    found = true;
                }
                if (found) {
                    User[] usersaccounts = new User[Globaldata.data.length - 1];
                    int indexof = 0;
                    for (int j = 0; j < Globaldata.data.length; j++) {
                        if (Globaldata.data[i] != null) {
                            usersaccounts[indexof] = Globaldata.data[i];
                            indexof++;
                        }
                    }
                    Globaldata.data = usersaccounts;
                    System.out.println("Hesabiniz silinmistir.");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Qeyd etdiyiniz məlumatlar yalnıştır.");
        }
        return Menu.menu();
    }

    @Override
    public int update() {
        int choose1 = Prints.inputRequiredInt("Davam etmek ucun - 1 " + "\n" +
                "Geri qayitmaq ucun - 2 " + "\n" +
                "Yuxaridakilardan birini seciniz :  " + "\n"
        );
        switch (choose1) {
            case 1:
                String ID = Prints.inputRequiredString("ID nizi qeyd edin : ");
                int password = Prints.inputRequiredInt("Sifrenizi qeyd edin : ");
                boolean found = false;
                for (int i = 0; i < Globaldata.data.length; i++) {
                    User user = Globaldata.data[i];
                    if (user.getID().contains(ID) && user.getPassword() == password) {
                        int choose = Prints.inputRequiredInt(
                                " 1 - Ad dəyişimi " + "\n" +
                                        " 2 - Soyad dəyişimi " + "\n" +
                                        " 3 - Şifrə dəyişimi " + "\n" +
                                        " 4 - ID dəyişimi " + "\n" +
                                        " 5 - Yas dəyişimi " + "\n" +
                                        " 6 - Profile menyusuna qayidis " + "\n" +
                                        " Yuxarıdakılardan birini seçin : "
                        );
                        switch (choose) {
                            case 1:
                                String newName = Prints.inputRequiredString("Yeni adinizi qeyd edin : ");
                                user.setName(newName);
                                break;
                            case 2:
                                String newSurname = Prints.inputRequiredString("Yeni soyadinizi qeyd edin : ");
                                user.setSurname(newSurname);
                                break;
                            case 3:
                                int newPassword = Prints.inputRequiredInt("Yeni sifrenizi qeyd edin : ");
                                user.setPassword(newPassword);
                                break;
                            case 4:
                                String newID = Prints.inputRequiredString("Yeni ID nizi qeyd edin : ");
                                user.setID(newID);
                                break;
                            case 5:
                                int newAge = Prints.inputRequiredInt("Yeni yasinizi qeyd edin : ");
                                user.setAge(newAge);
                            case 6:
                                System.out.println("\n" + "-----------Menyuya Qayıdış-------------");
                                return Loginmenu.menu();
                        }
                        return update();
                    }
                    found = true;
                }
                if (!found) {
                    System.out.println("Girdiyiniz melumatlar yalnistir.");
                }
            case 2:
                System.out.println("\n" + "-----------Menyuya Qayıdış-------------");
                return Loginmenu.menu();
        }
        return update();
    }

    @Override
    public int login() {
        if (Globaldata.data.length > 0) {
            String name1 = Prints.inputRequiredString("Adınızı daxil edin : ");
            String name2 = name1.trim().toLowerCase();
            String surname1 = Prints.inputRequiredString("Soyadınızı daxil edin : ");
            String surname2 = surname1.trim().toLowerCase();
            boolean correct = false;
            int trypassword = 3;
            do {
                for (int j = trypassword; j > 0; j--) {
                    for (int i = 0; i < Globaldata.data.length; i++) {
                        User user = Globaldata.data[i];
                        if (user.getName().trim().toLowerCase().contains(name2)
                                ||
                                user.getSurname().trim().toLowerCase().contains(surname2)
                        ) {
                            System.out.println("\n" + " Xoş gəldin " + user.getName());
                            int password1 = Prints.inputRequiredInt("Şifrənizi girin  : ");
                            if (user.getPassword() == password1) {
                                System.out.println("Şifrəniz təsdiqləndi ");
                                correct = true;
                                return Loginmenu.menu();
                            }
                            if (!correct) {
                                if (trypassword > 0) {
                                    System.out.println("Yalnış şifrə qeyd etdiniz. Qalan cəhd : " + trypassword);
                                    trypassword--;
                                }
                                if (trypassword == 0) {
                                    System.out.println("Şifrəniz doğru deyil. Bizimlə əlaqə saxlayın.");
                                    System.out.println("Sizi ana menyuya qaytaririq");
                                    trypassword--;
                                }
                            }
                        }
                    }
                }
            } while (trypassword >= 0);
        } else {
            System.out.println("\n" + "Xahiş olunur qeydiyyatdan keçin." + "\n");
            return register();
        }
        return Menu.menu();
    }

    @Override
    public int medaxil() {
        if (Globaldata.data.length > 0) {
            String accountİD = Prints.inputRequiredString("\n" + "Balansini artıracağınız hesabın ID - ni qeyd edin : ");
            for (int i = 0; i < Globaldata.data.length; i++) {
                User user = Globaldata.data[i];
                if (user.getID().contains(accountİD)) {
                    System.out.println("Balansını artırmaq istədiyiniz hesabı təsdiqləyin   " + "\n" + "Hesab məlumatları : ");
                    Globaldata.data[i].getInfo();
                    int confirm = Prints.inputRequiredInt(
                            "Davam etmək üçün - 1  " + "\n" +
                                    "Sistemdən çıxmaq üçün - 2  " + "\n" +
                                    "Seçiminizi qeyd edin : "
                    );
                    switch (confirm) {
                        case 1:
                            int total = user.getBalance();
                            int moneyin = Prints.inputRequiredInt("Daxil edəcəyiniz miqdarı girin : ");
                            System.out.println("\n" + accountİD.toUpperCase(Locale.ROOT) +
                                    "-ID nömrəli hesab : "
                            );
                            total += moneyin;
                            user.setBalance(total);
                            System.out.println("Artırılan məbləğ " + moneyin + " Azn təşkil edir. Yeni balans - " + total + " Azn");
                            return Loginmenu.menu();
                        case 2:
                            System.exit(-1);
                            break;
                        default:
                            System.out.println("Yalnış seçim etdiniz!!!");
                            break;
                    }

                }
            }
        } else {
            System.out.println("\n" + "Hesaba daxil olunmayıb!!");
            return register();
        }

        return Loginmenu.menu();
    }

    @Override
    public int mexaric() {
        if (Globaldata.data.length > 0) {
            String accountİD = Prints.inputRequiredString("\n" + "Hesabınizin ID - ni qeyd edin : ");
            for (int i = 0; i < Globaldata.data.length; i++) {
                User user = Globaldata.data[i];
                if (user.getID().contains(accountİD)) {
                    System.out.println("Hesab məlumatları : ");
                    Globaldata.data[i].getInfo();
                    int confirm = Prints.inputRequiredInt(
                            "Davam etmək üçün - 1  " + "\n" +
                                    "Sistemdən çıxmaq üçün - 2  " + "\n" +
                                    "Seçiminizi qeyd edin : "
                    );
                    switch (confirm) {
                        case 1:
                            int deneme = 3;
                            do {
                                for (int j = deneme; j >= 0; j--) {
                                    int password = Prints.inputRequiredInt("Şifrənizi daxil edin : ");
                                    boolean passwordaccount = false;
                                    if (Globaldata.data[i].getPassword() == password) {
                                        int total = user.getBalance();
                                        int moneyout = Prints.inputRequiredInt("Çıxartmaq istədiyiniz miqdarı girin : ");
                                        if (moneyout < total) {
                                            System.out.println("\n" + accountİD.toUpperCase(Locale.ROOT) +
                                                    "-ID nömrəli hesab : "
                                            );
                                            total -= moneyout;
                                            user.setBalance(total);
                                            System.out.println("Hesabınızdan " + moneyout + " Azn çıxılmışdır. Yeni balans - " + total + " Azn");
                                            return Loginmenu.menu();
                                        }
                                        if (moneyout > total) {
                                            System.out.println("Hesabınızda kifayət qədər məbləğ yoxdur." + "\n" + "Balansınız : " + total);
                                            return Loginmenu.menu();
                                        }
                                        passwordaccount = true;
                                    }
                                    if (!passwordaccount) {
                                        System.out.println("Yalnış şifrə girdiniz. Yenidən cəhd üçün qalan say : " + deneme);
                                        deneme--;
                                    }
                                }
                            } while (deneme > 0);
                        case 2:
                            System.exit(-1);
                            break;
                        default:
                            System.out.println("Yalnış seçim etdiniz!!!");
                            break;
                    }

                } else {
                    System.out.println("Qeyd etdiyiniz ID məlumatına uyğun istifadəçi taplmadı." + "\n" + "Yenidən yoxlayın. ");
                }
            }
        } else {
            System.out.println("\n" + "Hesaba daxil olunmayıb!!");
            return mexaric();

        }

        return Loginmenu.menu();
    }
}





