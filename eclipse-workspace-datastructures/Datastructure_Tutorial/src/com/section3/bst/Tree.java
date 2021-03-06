package com.section3.bst;

public interface Tree<T> {

	public void traversal();
	public void insert(T data);
	public void delete(T data);
	public T getMax();
	public T getMin();
}
