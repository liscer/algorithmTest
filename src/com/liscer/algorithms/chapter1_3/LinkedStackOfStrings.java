package com.liscer.algorithms.chapter1_3;

import java.util.NoSuchElementException;

public class LinkedStackOfStrings <Item>{

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

	
	public void display() {
		Node node = first;
		while (first != null) {
			System.out.println("data: " + first.item);
			first = first.next;
		}
		first = node;
		node = null;
	}

	public static void main(String[] args) {
		LinkedStackOfStrings linkedStack = new LinkedStackOfStrings();
		linkedStack.push("abc");
		linkedStack.push("def");
		linkedStack.push("def");
		linkedStack.display();

	}

}
