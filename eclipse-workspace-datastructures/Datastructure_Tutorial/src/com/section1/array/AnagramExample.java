package com.section1.array;

import java.util.Arrays;

public class AnagramExample {

	
	public static void main(String[] args) {
		String s1 = "restful";
		String s2 = "fluster";
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		if(c1.length == c2.length) {
			System.out.println(" -- >"+IsAnagram(c1,c2));
		}else {
			System.out.println("given String not anagram");
		}
	}

	private static boolean IsAnagram(char[] c1, char[] c2) {
		Arrays.sort(c1);
		Arrays.sort(c2);
		boolean flag = true;
		for(int i=0;i<c1.length-1;i++) {
			if(c1[i] != c2[i]) {
				flag = false;
			}
		}
		return flag;
	}
}
