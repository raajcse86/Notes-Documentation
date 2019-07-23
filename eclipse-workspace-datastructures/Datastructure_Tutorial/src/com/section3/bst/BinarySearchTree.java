package com.section3.bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	
	
	
	@Override
	public void insert(T data) {
		if(root == null) {
			root = new Node<T>(data);
		}else {
			insertNode(data,root);
		}
		
	}
	
	@Override
	public void traversal() {
		if(root != null) {
			inOrderTraversal(root);	
		}
		
		
	}

	
	private void inOrderTraversal(Node<T> node) {
		if(node.getLeftChild() != null) {
			inOrderTraversal(node.getLeftChild());
		}
		
		System.out.println(" "+node.getData()+ " -->");
		
		if(node.getRightChild() != null) {
			inOrderTraversal(node.getRightChild());
		}
		
	}

	public void insertNode(T newData, Node<T> node) {
		//this if condition is for comparing root with data, if it is less than 0, then traverse by left.
		if(newData.compareTo(node.getData()) < 0) {
			if(node.getLeftChild() != null) {
				insertNode(newData,node.getLeftChild());
			}else {
				Node<T> newNode = new Node<T>(newData);
				node.setLeftChild(newNode);
			}
		}else {
			// if new data is greater than the root, then traverse to the right sub child.
			if(node.getRightChild() != null) {
				insertNode(newData,node.getRightChild());
			}else {
				Node<T> newNode = new Node<T>(newData);
				node.setRightChild(newNode);
			}
		}
		
	}

	@Override
	public void delete(T data) {
		delete(root,data);
		
	}
	
	private Node<T> delete(Node<T> node,T data) {
		if(root == null) return node;
		
		if(data.compareTo(node.getData()) < 0) {
			node.setLeftChild(delete(node.getLeftChild(),data));
		}else if(data.compareTo(node.getData()) > 0) {
			node.setRightChild(delete(node.getRightChild(),data));
		}else {
			//we have the node that we want to remove.
			// if it is leaf node, both left child and right child are not present.
			if(node.getLeftChild() == null && node.getRightChild() == null) {
				System.out.println("Removing leaf node....");
				return null;
			}
			
			//if only right child is present.
			if(node.getLeftChild() == null) {
				Node<T> tempNode = node.getRightChild();
				node = null;
				return tempNode;
			}
			
			//if only left child is present.
			if(node.getRightChild() == null) {
				Node<T> tempNode = node.getLeftChild();
				node = null;
				return tempNode;
			}
			
			//if there is node with both left and right child node.
			Node<T> tempNode = getPredecesor(node.getLeftChild());
			
			//this where we swap the value of the node with the root
			node.setData(tempNode.getData());
			
			
			node.setLeftChild((delete(node.getLeftChild(),tempNode.getData())));
			
			
		}
		
		return node;
	}
	
	

	private Node<T> getPredecesor(Node<T> node) {
		if(node.getRightChild() != null) {
			getPredecesor(node.getRightChild());
		}
		
		return node;
	}

	@Override
	public T getMax() {
		if(root == null)return null;
		
		return getMaxValue(root);	
		
	}

	@Override
	public T getMin() {
		if(root == null)
			return null;
		return getMinValue(root);
	}
	
	public T getMinValue(Node<T> node) {
		if(node.getLeftChild() != null) {
			return getMinValue(node.getLeftChild());
		}
		return node.getData();
	}

	
	public T getMaxValue(Node<T> node) {
		if(node.getRightChild() != null) {
			return getMaxValue(node.getRightChild());	
		}
		return node.getData();
	}
}
