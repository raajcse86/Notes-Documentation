

package com.test.example;

import java.time.LocalDate;
import java.time.LocalTime;

class Student {
    String name;
    int age;

    void Student() {
        Student("James", 25);
    }

    void Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

interface Printable {
    public void setMargin();
    public void setOrientation();
}

abstract class Paper implements Printable { //Line 7
    public void setMargin() {}
    //Line 9
}

abstract class NewsPaper extends Paper { //Line 12
    public void setMargin() {}
    //Line 14
    public void setOrientation() {}
    
}

public class Q26 {
	
	public static void main(String[] args) {
//		LocalDateTime obj = LocalDateTime.now();
//        System.out.println(obj.getSecond());
//        
//        LocalDate date = LocalDate.of(2020, 10, 31);
//        System.out.println(date);
//        
//        
//        char var = '7';
//        switch(var) {
//            case 7:
//                System.out.println("Lucky no. 7");
//                break;
//            default:
//                System.out.println("DEFAULT");
//        }
        
        
//        String str = "java";
//        StringBuilder sb = new StringBuilder("java");
//
//        System.out.println(str.equals(sb) + ":" + sb.equals(str));
        
        
//		 LocalDate date = LocalDate.parse("1947-08-14");
//         LocalTime time = LocalTime.MAX;
//         System.out.println(date.atTime(time));
//        
//         
//         Student s = new Student();
//         System.out.println(s.name + ":" + s.age);
//         
//         double [] arr = new int[2];
	
		 do {
             System.out.println(100);
         } while (false);
         System.out.println("Bye");
	
	}
	
	

}
