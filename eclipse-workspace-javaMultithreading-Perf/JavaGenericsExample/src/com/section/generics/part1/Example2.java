package com.section.generics.part1;

class Store{
	private Object item;
	
	public void setItem(Object incomingItem) {
		this.item = incomingItem;
	}
	
	public Object getItem() {
		return this.item;
	}
	
	@Override
	public String toString() {
		return this.item.toString();
	}
}


public class Example2 {

	
	public static void main(String[] args) {
		Store store = new Store();
		store.setItem(45);
		//store.setItem("HelloWorld");
		Integer in = (Integer)store.getItem();
		//we have to use casting whenever we get
		System.out.println(store);
	}
}
