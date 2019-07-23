package com.test.example;

import java.util.ArrayList;
import java.util.List;

class Animal {
    private String name;

    //whether it is a class or abstract class and if did not define a default constructor, then it will throw error in subclass,
    //when subclass constructor did not call super class constructor explicitly.
    
    Animal(){
    	
    }
    
    Animal(String name) {
       this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
}

class Dog extends Animal {
    private String breed;
    Dog(String breed) {
    	//super(breed);
        this.breed = breed;
    }

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }
}

public class Q10 {
    public static void main(String[] args) {
//        Dog dog1 = new Dog("Beagle");
//        Dog dog2 = new Dog("Bubbly", "Poodle");
//        System.out.println(dog1.getName() + ":" + dog1.getBreed() + ":" + 
//                            dog2.getName() + ":" + dog2.getBreed());
        
        int [] arr = {2, 1, 13};
//        for(int i : arr) {
//            System.out.println(arr[i]);
//        }
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
        
        
//        StringBuilder sb = new StringBuilder();
//        System.out.println(sb.append(null).length());
        
        
        
        String s = new String("Hello");
        List<String> list = new ArrayList<>();
        list.add(s);
        list.add(new String("Hello"));
        list.add(s);
        s.replace("l", "55");

        System.out.println(list);
        
        
        List<Dog> dogList = new ArrayList();
        Dog d1 = new Dog("jimmy","breed1");
        dogList.add(d1);
        Dog d2 = new Dog("jonny","breed2");
        dogList.add(d2);
        
        //d1.setName("new-jimmy");
        d1 = null;
        
        
        
        System.out.println("List contains");
        for(Dog d: dogList) {
        	System.out.println(""+d.getName());
        }
        
    }
}