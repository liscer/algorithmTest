package com.liscer.algorithms.chapter1_3;

public class LinkedStackOfStrings {

	private Node first = null;

	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String item) {
		Node oldNode = first;
		first = new Node();
		first.item = item;
		first.next = oldNode;
	}

	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
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
