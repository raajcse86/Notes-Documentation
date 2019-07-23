package com.test.example;

import java.util.function.Predicate;

class SpecialString {
    String str;
    SpecialString(String str) {
        this.str = str;
    }
}


public class Q8 {
	 public static void main(String[] args) {
//         String [] arr = {"A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab"};
//         Predicate<String> p = s -> s.toUpperCase().substring(0,1).equals("A");
//         processStringArray(arr, p);
		 
		 
		 System.out.println(new String("Java"));
         System.out.println(new StringBuilder("Java"));
         System.out.println(new SpecialString("Java"));
     }
 
     private static void processStringArray(String [] arr, 
                                                Predicate<String> predicate) {
         for(String str : arr) {
             if(predicate.test(str)) {
                 System.out.println(str);
             }
         }
     }
}
