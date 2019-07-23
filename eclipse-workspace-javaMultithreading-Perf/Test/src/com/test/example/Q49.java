package com.test.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class A {
	  public int i1 = 1;
	     protected int i2 = 2;
    public void print() {
        System.out.println("A");
    }
}
class B extends A {
    public void print1() {
        System.out.println("B");
    }
    public void print() {
    	
        A obj = new A();
        System.out.println(obj.i1); //Line 8
        System.out.println(obj.i2); //Line 9
        System.out.println(this.i2); //Line 10
        System.out.println(super.i2); //Line 11
    }
}


public class Q49 {
	 public static void main(String[] args) {
//         B obj1 = new B();
//         A obj2 = (A)obj1;
//         obj2.print();
		 
		 
//		 List<String> dryFruits = new ArrayList<>();
//         dryFruits.add("Walnut");
//         dryFruits.add("Apricot");
//         dryFruits.add("Almond");
//         dryFruits.add("Date");
// 
//         Iterator<String> iterator = dryFruits.iterator();
//         while(iterator.hasNext()) {
//             String dryFruit = iterator.next();
//             if(dryFruit.startsWith("A")) {
//                // dryFruits.remove(dryFruit);
//                 iterator.remove();
//             }
//         }
//        
//         System.out.println(dryFruits);
         
         
//         double price = 90;
//         String model;
//         if(price > 100000) {
//             model = "Tesla Model X";
//         } else if(price <= 100000) {
//             model = "Tesla Model S";
//         }
//           System.out.println(model);
           
           
           
//           String str1 = new String("Core");
//           String str2 = new String("CoRe");
//           System.out.println(str1 = str2);
           
           
//           StringBuilder sb = new StringBuilder("Java");
//           String s1 = sb.toString();
//           String s2 = sb.toString();
//   
//           System.out.println("s1 "+s1);
//           System.out.println("s2 "+s2);
//           
//           String s3 = "test";
//           String s4 = "test";
//           
//           System.out.println(s3 == s4);
//           
//           System.out.println(s1 == s2);
//           
           
//           System.out.println("Output is: " + 10 != 5);
           
           
//           StringBuilder sb = new StringBuilder(100);
//           System.out.println(sb.length() + ":" + sb.toString().length());
           
         //  new B().print();
           
//           List<Integer> list = new ArrayList<Integer>();
//           list.add(new Integer(2));
//           list.add(new Integer(1));
//           list.add(new Integer(0));
//   
//           list.remove(list.indexOf(0));
//   
//           System.out.println(list);
           
//           Double [] arr = new Double[2];
//           System.out.println(arr[0] + arr[1]);
           
           
           String [] fruits = {"apple", "banana", "mango", "orange"};
           for(String fruit : fruits) {
               System.out.print(fruit + " ");
               if(fruit.equals("mango")) {
                   continue;
               }
               System.out.println("salad!");
               break;
           }        
     }
	 
	 

}
