package com.tutorial.join;

public class StringReverse {

	public static void main(String[] args) {
	 String str = "hello123IamRajasekar";
	  System.out.println("Actual str:  "+str);
	  System.out.println("Reverse str: "+reverseStrNumeric(str));

	}

	public static String reverseStrNumeric(String strValue) {
		//get the length of the string.
	   int length = strValue.length();
	   //declaring the reverse string as same as size of original.
	   char[] reverseStrArray = new char[length];
	   int jIndex = length-1;
	   for (int iIndex=0; iIndex <= jIndex; ) {
	       if(Character.isDigit(strValue.charAt(iIndex))) {
	    	   //check for i index
	    	   //put the digit at the same index in the reverse string.
	           reverseStrArray[iIndex] = strValue.charAt(iIndex);
	           //increment i
	           iIndex++;
	       } else if (Character.isDigit(strValue.charAt(jIndex))) {
	    	   //now check for j index
	    	   //put the digit at the same index in the reverse string.
	           reverseStrArray[jIndex] = strValue.charAt(jIndex);
	           jIndex--;
	       } else {
	    	   //if other than digit then swap and assign it to the reverse string.
	           reverseStrArray[jIndex] = strValue.charAt(iIndex);
	           reverseStrArray[iIndex] = strValue.charAt(jIndex);
	           jIndex--;
	           iIndex++;
	       }
	   }

	   return new String(reverseStrArray);
	}
	}


