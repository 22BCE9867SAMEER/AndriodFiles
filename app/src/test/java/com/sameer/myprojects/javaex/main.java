package com.sameer.myprojects.javaex;

public class main {
    public static void main(String [] args) {
        Example2 ex = new Example2();
        ex.message();
        //use of lammda
        Example e = () ->{System.out.println("messageed");};
        e.message();
    }
}
