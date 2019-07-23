package com.section3.bst;

public class Node<T> {
	
	//this is the actual data.
	private T data;
	//reference to left child. // left child data will be smaller than current node data.
	private Node<T> leftChild;
	
	//reference to left child. // left child data will be greater than current node data.
	private Node<T> rightChild;
	
	public Node(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}
	

}
