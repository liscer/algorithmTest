package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStackOfStrings <Item> implements Iterable<Item>{

	private Node first;
	private int n;
	
	public LinkedStackOfStrings(){
		first = null;
		n = 0;
	}

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	public int size(){
		return n;
	}

	public void push(Item item) {
		Node oldNode = first;
		first = new Node();
		first.item = item;
		first.next = oldNode;
		n++;
	}

	public Item pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		Item item = first.item;
		first = first.next;
		n--;
		return item;
	}
	
	public Item peek(){
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		return first.item;
	}

	
//	public void display() {
//		Node node = first;
//		while (first != null) {
//			System.out.println("data: " + first.item);
//			first = first.next;
//		}
//		first = node;
//		node = null;
//	}
	@Override
	public String toString() {
		StringBuffer sBuffer = new StringBuffer();
		for (Item item : this) {
			sBuffer.append(item+" ");
		}
		return sBuffer.toString();
	}

	public static void main(String[] args) {
		LinkedStackOfStrings linkedStack = new LinkedStackOfStrings();
		linkedStack.push("abc");
		linkedStack.push("def");
		linkedStack.push("def");
		linkedStack.display();

	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current =first;

		@Override
		public boolean hasNext() {
			return current !=null;
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

}
