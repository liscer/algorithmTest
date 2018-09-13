package com.liscer.algorthms.chapter1_3;

public class LinkedStackOfStrings {
	
	private Node first = null;
	private class Node{
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
