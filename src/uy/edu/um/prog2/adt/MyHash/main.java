package uy.edu.um.prog2.adt.MyHash;

import uy.edu.um.prog2.adt.Exceptions.KeyNotFound;

public class main {
    public static void main(String[] args) throws KeyNotFound {
        HashTableCerradoImpl<Integer, String> htc = new HashTableCerradoImpl<>(10);
        htc.insert(10, "1");
        htc.insert(3, "2");
        htc.insert(20, "3");
        htc.insert(30, "4");
        htc.insert(3, "5");
        htc.insert(40, "6");
        htc.delete(40);
        htc.insert(400, "7");
        htc.insert(90, "8");
        htc.insert(8, "9");
        htc.insert(23, "10");
        htc.insert(25, "11");
        htc.insert(60, "12");
        htc.insert(62, "13");
        htc.insert(256, "14");
        htc.insert(1020, "15");
        htc.insert(104, "16");
        System.out.println(htc.search(40));
    }
}
