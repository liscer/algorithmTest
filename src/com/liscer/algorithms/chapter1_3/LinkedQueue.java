package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;



public class LinkedQueue<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;
	private int n;
	
	public LinkedQueue() {
		first = null;
		last = null;
		n = 0;
	}
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size() {
		return n;
	}
	
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}else {
			oldlast.next = last;
		}
		n++;
	}
	
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		Item olditem = first.item;
		first= first.next;
		if (isEmpty()) {
			last =null;
		}
		n--;
		return olditem;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Item item : this) {
			stringBuilder.append(item+" ");
		}
		return stringBuilder.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		
		private Node current =first;

		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current=current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		LinkedQueue<String> linkedQueue = new LinkedQueue<>();
		linkedQueue.enqueue("asd");
		linkedQueue.enqueue("eee");
		linkedQueue.enqueue("rrrr");
		System.out.println(linkedQueue.toString());

	}


}
