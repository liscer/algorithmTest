package com.liscer.algorithms.chapter1_3;

public class LinkedQueueOfStrings {
	
	private Node first;
	private Node last;
	
	private class Node{
		String item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void enqueue(String item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}else {
			oldlast.next = last;
		}
	}
	
	public String dequeue() {
		String olditem = first.item;
		first= first.next;
		if (isEmpty()) {
			last =null;
		}
		return olditem;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
