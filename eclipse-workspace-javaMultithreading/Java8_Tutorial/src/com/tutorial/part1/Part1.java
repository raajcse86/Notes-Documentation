package com.tutorial.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Part1 {

	
	public static void main(String[] args) {
		List<String> stringlist = new ArrayList<>();
		stringlist.add("I went to hotel yesterday");
		stringlist.add("I went to movie last week");
		stringlist.add("I will go to tour next month");
		
//		stringlist.stream().flatMap((values)->{
//			
//			String[] arr = values.split(" ");
//			return Arrays.asList(arr).stream();
//		}).forEach(System.out::println);
		
		Optional<String> optStr = stringlist.stream().reduce((value,combinedvalue)->{
			return value+","+combinedvalue;	
		} );
		
		System.out.println(optStr.get());
		
		
	}
}
