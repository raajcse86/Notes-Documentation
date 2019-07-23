package com.section.recursive;

class Algorithm{
	public void buildLayer(int height) {
		if(height == 0) return;
		System.out.println(height);
		buildLayer(height-1);
	}
}

public class BuildLayer {

	public static void main(String[] args) {
		Algorithm algorithm = new Algorithm();
		algorithm.buildLayer(4);
	}
	
}
