package com.test.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Period;

abstract class Super {
    public abstract void m1() throws IOException;
}

class Sub extends Super {
    @Override
    public void m1() throws IOException {
        throw new FileNotFoundException();
    }
}
public class Q35 {
	char c;
    double d;
    float f;
	
	public static void main(String[] args) {
//		Super s = new Sub();
//	    try {
//	        s.m1();
//	    } catch (FileNotFoundException e) {
//	        System.out.print("M");
//	    } finally {
//	        System.out.print("N");
//	    }
	    
	    
//	    try {
//            main(args);
//        } catch (Exception ex) {
//            System.out.println("CATCH-");
//        }
//            System.out.println("OUT");
            
            
//		Q35 obj = new Q35();
//            System.out.println(">" + obj.c);
//            System.out.println(">" + obj.d);
//            System.out.println(">" + obj.f);
//            
            
            
//            LocalDate date = LocalDate.of(2012, 1, 11);
//            Period period = Period.ofMonths(2);
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
//            System.out.print(formatter.format(date.minus(period)));
            
            
//            List<String> list1 = new ArrayList<>();
//            list1.add("A");
//            list1.add("D");
//    
//            List<String> list2 = new ArrayList<>();
//            list2.add("B");
//            list2.add("C");
//    
//            list1.addAll(1, list2);
//    
//            System.out.println(list1);
//            
            
            Period period = Period.of(0, 0, 0);
            System.out.println(period);
	
	
	}
	

}
