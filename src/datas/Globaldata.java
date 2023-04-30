package datas;

import objects.User;

import java.util.HashMap;
import java.util.LinkedList;

public class Globaldata {
    public static LinkedList<User> accounts = new LinkedList<>();
    public static HashMap<String,User> accountMapString = new HashMap<>();
   public static HashMap<Integer,User> accountMapInteger = new HashMap<>();

}
