package com.test.example;

public class Q22 {

	private static void m(int x) {
        System.out.println("int version");
    }

    private static void m(char x) {
        System.out.println("char version");
    }

    public static void main(String [] args) {
//        int i = '5';
//        m(i);
//        m('5');
        
        
        
//        byte var = 100;
//        switch(var) {
//            case 100:
//                System.out.println("var is 100");
//                break;
//            case 128:
//                System.out.println("var is 200");
//                break;
//            default:
//                System.out.println("In default");
//        }
        
        
        String s1 = "OCAJP";
        String s2 = "OCAJP" + "";
        System.out.println(s1 == s2);
        
    }
}
