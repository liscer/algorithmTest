package com.liscer.algorithms.chapter1_3;

public class ResizingStackOfStrings {
	
	private String[] s;
	private int N=0;
	public ResizingStackOfStrings(int capacity) {
		s = new String[capacity];
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public void push(String item) {
		if (N == s.length) {
			resize(s.length * 2);
		}
		s[N++]=item;
	}
	public String pop() {
		//考虑对象游离
		String item = s[--N];
		s[N] = null;
		if (N>0 &&N == s.length/4) {
			resize(s.length/2);
		}
		return item;
	}
	
	private void resize(int max){
		String[] copy = new String[max];
		for (int i = 0; i < N; i++) {
			copy[i]= s[i];
		}
		s = copy;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
