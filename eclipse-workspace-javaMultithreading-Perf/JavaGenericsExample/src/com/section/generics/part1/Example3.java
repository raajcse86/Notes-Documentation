package com.section.generics.part1;

class Storage<T>{
	private T item;
	
	public void setItem(T item) {
		this.item=item;
	}
	public T getItem() {
		return this.item;
	}
	
}

class Hashtable<K, V>{
	K key;
	V value;
	
	public Hashtable(K k, V v) {
		this.key = k;
		this.value = v;
	}
	
	@Override
	public String toString() {
		return "key = "+key.toString() + " value = "+value.toString();
	}
}

class HashMap<K,V>{
	K key;
	V value;
	
	public HashMap(K k, V v) {
		this.key = k;
		this.value = v;
	}
	
	@Override
	public String toString() {
		return "key = "+key.toString() + " value = "+value.toString();
	}
}

public class Example3 {

	
	public static void main(String[] args) {
		Storage<Integer> store = new Storage<Integer>();
		store.setItem(45);
		System.out.println(store.getItem());
		
		///no need to do explicit casting.
		
		Storage<String> storeStr = new Storage<String>();
		storeStr.setItem("Helloworld");
		System.out.println(storeStr.getItem());
		
		
		Hashtable<String,Integer> ht = new Hashtable<String, Integer>("Hello", 25);
		System.out.println(ht);
		
		
		HashMap<String,Integer> hm = new HashMap<String, Integer>("raj", 100);
		System.out.println(hm);
		
		
		
	}
}
