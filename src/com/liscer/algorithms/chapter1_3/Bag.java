package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
	
	private Node first;
	private int n;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public Bag(){
		first = null;
		n =0;
	}
	
	public void add(Item item){
		Node oldNode = first;
		first = new Node();
		first.item = item;
		first.next = oldNode;
		n++;
	}
	
	public boolean isEmpty(){
		return first ==null;
	}
	
	public int size(){
		return n;
	}
	@Override
	public String toString() {
		StringBuilder sBuilder =new StringBuilder();
		for (Item item : this) {
			sBuilder.append(item);
		}
		return sBuilder.toString();
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current=first;

		@Override
		public boolean hasNext() {
			return current !=null ;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item= current.item;
			current = current.next;
			return item;
		}
		
	}

	public static void main(String[] args) {
		Bag<String> bag = new Bag<>();
		bag.add("qwe");
		bag.add("rty");
		bag.add("asd");
		System.out.println(bag.size());
		System.out.println(bag.isEmpty());
		System.out.println(bag.toString());
	}


}
