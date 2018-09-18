package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链表实现栈 有泛型和迭代器
 * @author libaojia
 *
 * @param <Item>
 */
//第三次练习
public class LinkedStack<Item> implements Iterable<Item>{
	
	private Node first;
	private int N;
	
	public LinkedStack(){
		first = null;
		N = 0;
	}
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public int size(){
		return N;
	}
	
	public void push(Item item) {
		Node oldNode = first;
		first = new Node();
		first.item = item;
		first.next = oldNode;
		N++;
	}
	
	public Item pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack underflow");
		}
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack underflow");
		}
		return first.item;
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
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		LinkedStack<String> a = new LinkedStack<>();
		a.push("q");
		a.push("w");
		a.push("e");
		a.push("r");
		a.pop();
		a.push("l");
		System.out.println("peek = " + a.peek());

		System.out.println(a.toString() + "size = " + a.size());
	}
}













/*public class LinkedStack<Item> implements Iterable<Item> {

	private Node first;
	private int N;

	public LinkedStack() {
		first = null;
		N = 0;
	}

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		Node oldNode = first;
		first = new Node();
		first.item = item;
		first.next = oldNode;
		N++;
	}

	public Item pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack underflow");
		}
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack underflow");
		}
		return first.item;
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
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

	}

	public static void main(String[] args) {
		LinkedStack<String> a = new LinkedStack<>();
		a.push("q");
		a.push("w");
		a.push("e");
		a.push("r");
		a.pop();
		a.push("l");
		System.out.println("peek = " + a.peek());

		System.out.println(a.toString() + "size = " + a.size());
	}

}*/

/*
 * public class LinkedStack<Item> implements Iterable<Item> {
 * 
 * private Node first; private int n;
 * 
 * public LinkedStack() { first = null; n = 0; }
 * 
 * private class Node { Item item; Node next; }
 * 
 * public boolean isEmpty() { return first == null; }
 * 
 * public int size() { return n; }
 * 
 * public void push(Item item) { Node oldNode = first; first = new Node();
 * first.item = item; first.next = oldNode; n++; }
 * 
 * public Item pop() { if (isEmpty()) { throw new
 * NoSuchElementException("Stack underflow"); } Item item = first.item; first =
 * first.next; n--; return item; }
 * 
 * public Item peek() { if (isEmpty()) { throw new
 * NoSuchElementException("Stack underflow"); } return first.item; }
 * 
 * // public void display() { // Node node = first; // while (first != null) {
 * // System.out.println("data: " + first.item); // first = first.next; // } //
 * first = node; // node = null; // }
 * 
 * @Override public String toString() { StringBuilder s = new StringBuilder();
 * for (Item item : this) s.append(item + " "); return s.toString(); }
 * 
 * public static void main(String[] args) { LinkedStack<String> linkedStack =
 * new LinkedStack<>(); linkedStack.push("abc"); linkedStack.push("def");
 * linkedStack.push("def"); System.out.println(linkedStack.toString()); }
 * 
 * @Override public Iterator<Item> iterator() { return new ListIterator(); }
 * 
 * private class ListIterator implements Iterator<Item> { private Node current =
 * first;
 * 
 * @Override public boolean hasNext() { return current != null; }
 * 
 * @Override public Item next() { if (!hasNext()) { throw new
 * NoSuchElementException(); } Item item = current.item; current = current.next;
 * return item; }
 * 
 * }
 * 
 * }
 */
