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
        int choose1 = Prints.inputRequiredInt("For continue - 1 " + "\n" +
                "Return back - 2 " + "\n" +
                "Choose one of the above : " + "\n"
        );
        switch (choose1) {
            case 1:
                System.out.println("Informations additionals : ");
                String name = Prints.inputRequiredString("\nEnter your name : ");
                String surname = Prints.inputRequiredString("Enter your surname : ");
                int age = Prints.inputRequiredInt("Enter your age : ");
                int passwordin = Prints.inputRequiredInt("Enter your password : ");
                int checkpassword = Prints.inputRequiredInt("Enter your password again : ");
                System.out.println("-----------------------------");
                boolean password = false;
                if (passwordin == checkpassword) {
                    System.out.println("Your password approved ");
                    password = true;
                }
                if (!password) {
                    System.out.println("Wrong password " + "\n");
                    return register();
                }
                String ID = Prints.inputRequiredString("Enter your id : ");
                User user = new User(name, surname, age, checkpassword, ID);
                boolean isDuplicateID = false;
                for (User informations : Globaldata.accounts)
                    if (informations.getID().equals(ID)) {
                        System.out.println(ID + " this account not available.\n");
                        isDuplicateID = true;
                        return register();
                    }
                if (isDuplicateID == false) {
                    Globaldata.accounts.add(user);
                }
                System.out.println("\n------------Approved-----------" + "\nYour account has been resgistered" + "\n");
                user.getInfo();
            case 2:
                System.out.println("\n" + "-----------Return Menu-------------");
                return Menu.menu();
        }
        return Menu.menu();
    } //+

    @Override
    public int delete() {
        int choose1 = Prints.inputRequiredInt("For continue - 1 " + "\n" +
                "Return back - 2 " + "\n" +
                "Choose one of the above : " + "\n"
        );
        switch (choose1) {
            case 1:
                try {
                    String ID = Prints.inputRequiredString("Enter your ID : ");
                    int password = Prints.inputRequiredInt("Enter your password : ");
                    boolean found = false;
                    for (User informatin : Globaldata.accounts) {
                        if (informatin.getID().contains(ID)) {
                            boolean checkpassword = false;
                            if (informatin.getPassword() == password) {
                                Globaldata.accounts.remove(informatin);
                                System.out.println("Your account has been deleted. ");
                                checkpassword = true;
                                return Menu.menu();
                            }
                            if (checkpassword != true) {
                                System.out.println("Your enter wrong password. ");
                            }
                            found = true;
                            return Menu.menu();
                        }
                        if (found != true) {
                            System.out.println("This account is not available");
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Somethings gets wrong. Please enter again.");
                }
            case 2:
                System.out.println("\n" + "-----------Return Menu-------------");
                return Loginmenu.menu();
        }
        return Menu.menu();
    } //+


    @Override
    public int update() {
        int choose1 = Prints.inputRequiredInt("For continue - 1 " + "\n" +
                "Return back - 2 " + "\n" +
                "Choose one of the above : " + "\n"
        );
        switch (choose1) {
            case 1:
                String ID = Prints.inputRequiredString("Enter your ID : ");
                int password = Prints.inputRequiredInt("Enter your password : ");
                boolean found = false;
                for (User information : Globaldata.accounts) {
                    if (information.getID().contains(ID)) {
                        boolean checkpassword = false;
                        if (information.getPassword() == password) {
                            int choose = Prints.inputRequiredInt(
                                    " 1 - Change your name " + "\n" +
                                            " 2 - Change Your Surname " + "\n" +
                                            " 3 - Change Your Password " + "\n" +
                                            " 4 - Change Your ID " + "\n" +
                                            " 5 - Change Your Age " + "\n" +
                                            " 6 - Return Menu " + "\n" +
                                            "Choose one of the above : "
                            );
                            switch (choose) {
                                case 1:
                                    String newName = Prints.inputRequiredString("Enter your new name : ");
                                    information.setName(newName);
                                    break;
                                case 2:
                                    String newSurname = Prints.inputRequiredString("Enter your new surname : ");
                                    information.setSurname(newSurname);
                                    break;
                                case 3:
                                    int newPassword = Prints.inputRequiredInt("Enter your new password : ");
                                    information.setPassword(newPassword);
                                    break;
                                case 4:
                                    String newID = Prints.inputRequiredString("Enter your new ID : ");
                                    information.setID(newID);
                                    break;
                                case 5:
                                    int newAge = Prints.inputRequiredInt("Enter your new age : ");
                                    information.setAge(newAge);
                                case 6:
                                    System.out.println("\n" + "-----------Return Menu-------------");
                                    return Loginmenu.menu();
                            }
                            checkpassword = true;
                            return Loginmenu.menu();
                        }
                        if (checkpassword != true) {
                            System.out.println("Wrong password. ");
                            return Loginmenu.menu();
                        }
                        found = true;
                    }
                    if (!found) {
                        System.out.println("This account not available.");
                    }
                }
            case 2:
                System.out.println("\n" + "-----------Return Menu-------------");
                return Loginmenu.menu();

        }
        return update();
    } //+

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





