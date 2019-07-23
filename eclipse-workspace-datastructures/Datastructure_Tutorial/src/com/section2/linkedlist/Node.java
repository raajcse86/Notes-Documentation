package com.section2.linkedlist;

public class Node<T extends Comparable<T>> {
	
	T data;
	Node<T> node;
	
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNode() {
		return node;
	}
	public void setNode(Node<T> node) {
		this.node = node;
	}

}
