package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ResizingStack<Item> implements Iterable<Item>{
	
	private Item[] s;
	private int N=0;
	public ResizingStack(int capacity) {
		s = (Item[])new Object[capacity];
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public void push(Item item) {
		if (N == s.length) {
			resize(s.length * 2);
		}
		s[N++]=item;
	}
	public Item pop() {
		//考虑对象游离
		Item item = s[--N];
		s[N] = null;
		if (N>0 &&N == s.length/4) {
			resize(s.length/2);
		}
		return item;
	}
	
	private void resize(int max){
		Item[] copy = (Item[])new Object[max];
		for (int i = 0; i < N; i++) {
			copy[i]= s[i];
		}
		s = copy;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (Item item : this) {
			string.append(item);
		}
		return string.toString();
	}


	@Override
	public Iterator<Item> iterator() {
		return new ResizingArrayStack();
	}
	
	private class ResizingArrayStack implements Iterator<Item>{
		private int index;
		public ResizingArrayStack(){
			index = N-1;
		}
		@Override
		public boolean hasNext() {
			return index>=0;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return s[index--];
		}
		
	}
	public static void main(String[] args) {
		ResizingStack<String> a = new ResizingStack<>(5);
		a.push("q");
		a.push("w");
		a.push("e");
		a.push("r");
		System.out.println(a.toString());
		
	}

}
