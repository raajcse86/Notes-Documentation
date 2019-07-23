package com.section3.bst;

public class App {
	public static void main(String[] args) {
		Tree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(-1);
		tree.insert(1);
		tree.insert(0);
		tree.insert(1000);
		tree.insert(-22);

		System.out.println("MAx value "+tree.getMax());
		System.out.println("Min value "+tree.getMin());
		
		
		tree.traversal();
		
	}

}
