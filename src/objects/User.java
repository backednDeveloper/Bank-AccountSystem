package objects;

public class User {
    private String name;
    private String surname;
    private int age;
    private int password;
    private String ID;
    private int balance;

    public User(String name, String surname, int age, int password, String ID) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
        this.ID = ID;
    }

    public String getInfo() {
        System.out.println(
                "İstifadəçi Məlumatları : " + "\n" +
                        "Ad : " + getName() + "\n" +
                        "Soyad : " + getSurname() + "\n" +
                        "Yaş : " + getAge() + "\n" +
                        "ID : " + getID() + "\n"
        );

        return null;
    }

    public String getName() {

        return name;
    }

    public int getBalance() {
        System.out.println("Sizin balansınız " + balance + " azn təşkil edir");
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getID() {
        return ID;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}

