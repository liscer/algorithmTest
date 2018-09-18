package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * 动态数组实现栈 有泛型和迭代器
 * @author libaojia
 *
 * @param <Item>
 */
//第三次练习

public class ResizingStack<Item> implements Iterable<Item>{
	
	private Item[] a;
	private int N;
	
	public ResizingStack(){
		a = (Item[])new Object[2];
		N = 0;
	}
	
	public boolean isEmpty(){
		return N <0;
	}
	
	public int size(){
		return N;
	}
	
	private void resize(int caption){
		Item[] temp = (Item[])new Object[caption];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void push(Item item){
		if (N==a.length) {
			resize(a.length*2);
		}
		a[N++]=item;
	}
	
	public Item pop(){
		if (isEmpty()) {
			throw new NoSuchElementException("stack underfolw");
		}
		Item item = a[--N];
		a[N] = null;
		if (N == a.length/4){
			resize(a.length/2);
		}
		return item;
	}
	
	public Item peek(){
		if (isEmpty()) {
			throw new NoSuchElementException("stack underflow");
		}
		return a[N-1];
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		for (Item item : this) {
			sBuilder.append(item + " ");
		}
		return sBuilder.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private int index = N-1;

		@Override
		public boolean hasNext() {
			return index>=0;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return a[index--];
		}
		
	}
	
	public static void main(String[] args) {
		ResizingStack<String> a = new ResizingStack<>();
		a.push("q");
		a.push("w");
		a.push("e");
		a.pop();
		a.push("r");
		System.out.println("peek = " + a.peek());

		System.out.println(a.toString() + "size = " + a.size());
	}
	
}










/*public class ResizingStack<Item> implements Iterable<Item> {

	private Item[] a;
	private int N;

	public ResizingStack() {
		a = (Item[]) new Object[2];
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int caption) {
		Item[] temp = (Item[]) new Object[caption];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void push(Item item) {
		if (N == a.length) {
			resize(a.length * 2);
		}
		a[N++] = item;
	}

	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("queue underflow");
		}
		// int v = N-1;
		return a[N - 1];
	}

	public Item pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack underflow");
		}
		Item item = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		for (Item item : this) {
			sBuilder.append(item + " ");
		}
		return sBuilder.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private int index = 0;

		public ListIterator() {
			index = N - 1;
		}

		@Override
		public boolean hasNext() {
			return index >= 0;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return a[index--];
		}

	}

	public static void main(String[] args) {
		ResizingStack<String> a = new ResizingStack<>();
		a.push("q");
		a.push("w");
		a.push("e");
		a.push("r");
		System.out.println("peek = " + a.peek());

		System.out.println(a.toString() + "size = " + a.size());
	}

}*/

/*
 * public class ResizingStack<Item> implements Iterable<Item>{
 * 
 * private Item[] s; private int N; public ResizingStack() { s = (Item[])new
 * Object[2]; N= 0; }
 * 
 * public boolean isEmpty() { return N==0; }
 * 
 * public void push(Item item) { if (N == s.length) { resize(s.length * 2); }
 * s[N++]=item; } public Item pop() {
 * 
 * Item item = s[--N]; s[N] = null;//考虑对象游离 if (N>0 &&N == s.length/4) {
 * resize(s.length/2); } return item; }
 * 
 * private void resize(int max){ Item[] copy = (Item[])new Object[max]; for (int
 * i = 0; i < N; i++) { copy[i]= s[i]; } s = copy; }
 * 
 * @Override public String toString() { StringBuilder string = new
 * StringBuilder(); for (Item item : this) { string.append(item); } return
 * string.toString(); }
 * 
 * 
 * @Override public Iterator<Item> iterator() { return new ResizingArrayStack();
 * }
 * 
 * private class ResizingArrayStack implements Iterator<Item>{ private int
 * index; public ResizingArrayStack(){ index = N-1; }
 * 
 * @Override public boolean hasNext() { return index>=0; }
 * 
 * @Override public Item next() { if (!hasNext()) { throw new
 * NoSuchElementException(); } return s[index--]; } }
 * 
 * public static void main(String[] args) { ResizingStack<String> a = new
 * ResizingStack<>(); a.push("q"); a.push("w"); a.push("e"); a.push("r");
 * System.out.println(a.toString()); } }
 */
