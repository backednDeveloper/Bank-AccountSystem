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
                        User foundID = Globaldata.accountMapString.put(ID, informatin);
                        User foundPassword = Globaldata.accountMapInteger.put(password, informatin);
                        if (foundID != null) {
                            boolean checkpassword = false;
                            if (foundPassword != null) {
                                Globaldata.accounts.remove(informatin);
                                System.out.println("Your account has been deleted. ");
                                checkpassword = true;
                                return Menu.menu();
                            }
                            if (checkpassword != true) {
                                System.out.println("Your enter wrong password. ");
                            }
                        }
                        found = true;
                        return Menu.menu();
                    }
                    if (found != true) {
                        System.out.println("This account is not available");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Somethings gets wrong. Please enter again.");
                }
            case 2:
                System.out.println("\n" + "-----------Return Menu-------------");
                return Loginmenu.menu();
        }
        return Menu.menu();
    } //++

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
                    User foundID = Globaldata.accountMapString.put(ID, information);
                    User foundPassword = Globaldata.accountMapInteger.put(password, information);
                    if (foundID != null) {
                        boolean checkpassword = false;
                        if (foundPassword != null) {
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
        int choose1 = Prints.inputRequiredInt("For continue - 1 " + "\n" +
                "Return back - 2 " + "\n" +
                "Choose one of the above : " + "\n"
        );
        switch (choose1) {
            case 1:
                if (Globaldata.accounts.size() > 0) {
                    String name1 = Prints.inputRequiredString("Enter your name : ");
                    String name2 = name1.trim().toLowerCase();
                    String surname1 = Prints.inputRequiredString("Enter your surname : ");
                    String surname2 = surname1.trim().toLowerCase();
                    boolean correct = false;
                    int trypassword = 3;
                    do {
                        for (int j = trypassword; j > 0; j--) {
                            for (User information : Globaldata.accounts) {
                                User foundname = Globaldata.accountMapString.put(name2, information);
                                User foundsurname = Globaldata.accountMapString.put(surname2, information);
                                if (foundname != null
                                        ||
                                        foundsurname != null
                                ) {
                                    System.out.println("\n" + " Welcome " + information.getName());
                                    int password1 = Prints.inputRequiredInt("Enter your password  : ");
                                    if (information.getPassword() == password1) {
                                        System.out.println("Your password aprroved ");
                                        correct = true;
                                        return Loginmenu.menu();
                                    }
                                    if (!correct) {
                                        if (trypassword > 0) {
                                            System.out.println("Wrong password. you have : " + trypassword + "attempt. Please try again.");
                                            trypassword--;
                                        }
                                        if (trypassword == 0) {
                                            System.out.println("Your enter passwords is wrong. So we returned you to home page.");
                                            trypassword--;
                                        }
                                    }
                                }
                            }
                        }
                    } while (trypassword >= 0);
                } else {
                    System.out.println("\n" + "Please firstable registered." + "\n");
                    return register();
                }
            case 2:
                System.out.println("\n" + "-----------Return Menu-------------");
                return Menu.menu();

        }
        return Menu.menu();
    } //++

    @Override
    public int medaxil() {
        int choose1 = Prints.inputRequiredInt("For continue - 1 " + "\n" +
                "Return back - 2 " + "\n" +
                "Choose one of the above : " + "\n"
        );
        switch (choose1) {
            case 1:
                if (Globaldata.accounts.size() > 0) {
                    String accountİD = Prints.inputRequiredString("\n" + "Enter ID : ");
                    for (User information : Globaldata.accounts) {
                        User found = Globaldata.accountMapString.put(accountİD, information);
                        if (found != null) {
                            System.out.println("Approved ID " + "\n" + "Acoount information : ");
                            information.getInfo();
                            int choose2 = Prints.inputRequiredInt("For continue - 1 " + "\n" +
                                    "Return back - 2 " + "\n" +
                                    "Choose one of the above : " + "\n"
                            );
                            switch (choose2) {
                                case 1:
                                    int total = information.getBalance();
                                    int moneyin = Prints.inputRequiredInt("Enter price : ");
                                    System.out.println("\n" + accountİD.toUpperCase(Locale.ROOT) +
                                            "-ID acoount : "
                                    );
                                    total += moneyin;
                                    information.setBalance(total);
                                    System.out.println("Your added balance is " + moneyin + " Azn . New Balnace is - " + total + " Azn");
                                    return Loginmenu.menu();
                                case 2:
                                    return Loginmenu.menu();
                                default:
                                    System.out.println("Yalnış seçim etdiniz!!!");
                                    break;
                            }

                        }
                    }
                } else {
                    System.out.println("\n" + "You need first Login !!");
                    return register();
                }
            case 2:
                System.out.println("\n" + "-----------Return Menu-------------");
                return Loginmenu.menu();
        }
        return Loginmenu.menu();
    } //++

    @Override
    public int mexaric() {
        int choose1 = Prints.inputRequiredInt("For continue - 1 " + "\n" +
                "Return back - 2 " + "\n" +
                "Choose one of the above : " + "\n"
        );
        switch (choose1) {
            case 1:
                if (Globaldata.accounts.size() > 0) {
                    String accountİD = Prints.inputRequiredString("\n" + "Enter ID : ");
                    for (User information : Globaldata.accounts) {
                        User found = Globaldata.accountMapString.put(accountİD, information);
                        if (found != null) {
                            System.out.println("Hesab məlumatları : ");
                            information.getInfo();
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
                                            int password = Prints.inputRequiredInt("Enter your password : ");
                                            boolean passwordaccount = false;
                                            User foundpassword = Globaldata.accountMapInteger.put(password, information);
                                            if (foundpassword != null) {
                                                int total = information.getBalance();
                                                int moneyout = Prints.inputRequiredInt("Enter the amount you want to withdraw : ");
                                                if (moneyout < total) {
                                                    System.out.println("\n" + accountİD.toUpperCase(Locale.ROOT) +
                                                            "-ID account : "
                                                    );
                                                    total -= moneyout;
                                                    information.setBalance(total);
                                                    System.out.println(moneyout + " Azn is out your account. New balance - " + total + " Azn");
                                                    return Loginmenu.menu();
                                                }
                                                if (moneyout > total) {
                                                    System.out.println("You don't have enough money in your account." + "\n" + "Your balance is : " + total + " Azn");
                                                    return Loginmenu.menu();
                                                }
                                                passwordaccount = true;
                                            }
                                            if (!passwordaccount) {
                                                System.out.println("You have entered an incorrect password. Remaining number to retry : " + deneme);
                                                deneme--;
                                            }
                                        }
                                    } while (deneme > 0);
                                case 2:
                                    System.exit(-1);
                                    break;
                                default:
                                    System.out.println("You made the wrong choice!!!");
                                    break;
                            }

                        } else {
                            System.out.println("No user matching the ID information you specified was found." + "\n" + "Try again. ");
                        }
                    }
                } else {
                    System.out.println("\n" + "Not included in the account!!");
                    return mexaric();

                }
        }
        return Loginmenu.menu();
    } //++
}





