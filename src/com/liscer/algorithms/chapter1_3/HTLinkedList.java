package com.liscer.algorithms.chapter1_3;

import java.util.NoSuchElementException;

public class HTLinkedList<Item> {
	
	private Node<Item> first;
	private Node<Item> last;
	private int N;
	
	public HTLinkedList(){
		first = null;
		last = null;
		N = 0;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	private static class Node<Item>{
		Node<Item> next;
		Item item;
		
		public Node(Item item){
			this.item = item;
		}
		
	}
	
	public void add(Item item){
		Node<Item> oldNode = last;
		last = new Node<>(item);
		last.next = null;
		if (isEmpty()) {
			first = last;
		}else {
			oldNode.next = last;
		}
		N++;
	}
	
	public void add(Item item,int index){
		
	}
	
	public void remove(){
		if (isEmpty()) {
			throw new NoSuchElementException("under");
		}
		if (N == 1) {
			first = null;
			last = null;
			N--;
		}else {
			Node<Item> current = first;
			while (current != null) {
				if (current.next == last) {
					current.next = null;
					last = current;
					N--;
				}
				current = current.next;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sbBuilder = new StringBuilder();
		if (N == 0) {
			sbBuilder.append("没有任何元素了,你还打印他干什么");
		}else {
			Node<Item> current = first;
			while (current != null) {
				sbBuilder.append(" ");
				sbBuilder.append(current.item);
				current = current.next;
			}
		}
		return sbBuilder.toString();
	}

	public static void main(String[] args) {
		HTLinkedList<String> htLinkedList = new HTLinkedList<>();
		htLinkedList.add("aaa");
		//htLinkedList.add("bbb");
		htLinkedList.remove();
		//htLinkedList.remove();
		//htLinkedList.add("ccc");
		System.out.println(htLinkedList.toString());
		//System.out.println(htLinkedList.first.item);
		//System.out.println(htLinkedList.last.item);
		System.out.println(htLinkedList.N);

	}

}
