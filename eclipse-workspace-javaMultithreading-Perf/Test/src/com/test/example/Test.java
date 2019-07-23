package com.test.example;

public class Test {
    public static void main(String[] args) {
    	 String fruit = "mango";
         switch (fruit) {
             default:
                 System.out.println("ANY FRUIT WILL DO");
                 break;
                 
             case "Apple":
                 System.out.println("APPLE");
                 
             case "Mango":
                 System.out.println("MANGO");
                 break;
             case "Banana":
                 System.out.println("BANANA");
                 break;
         }
    }

    private static void m1() throws Exception { //Line 6
        System.out.println("NOT THROWING ANY EXCEPTION"); //Line 7
    }
}
