package com.test.example;

import java.util.ArrayList;

class Counter {
	
	 static {
         System.out.println(1/0);
     }
 
    int count;
    Counter(int count) {
        this.count = count;
    }

    public String toString() {
        return "Counter-" + count;
    }
}
public class Q66 {
	 public static void main(String[] args) {
//         ArrayList<Counter> original = new ArrayList<>();
//         original.add(new Counter(10));
// 
//         ArrayList<Counter> cloned = (ArrayList<Counter>) original.clone();
//         cloned.get(0).count = 5;
// 
//         System.out.println(original);
         
//         int a = 100;
//         System.out.println(-a++);
         
         //System.out.println("HELLO");
		 System.out.println(1/0);
     }

}
