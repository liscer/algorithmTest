package com.liscer.algorithms.chapter1_3;

import java.util.NoSuchElementException;

public class CircularLinkedList<Item> {
	
	private Node head;
	private int N;
	
	class Node{
		Item item;
		Node next;
		public Node(Item item){
			this.item = item;
		}
	}
	public CircularLinkedList(){
		head = new Node(null);
		head.next = head;//没有节点的时候head的下一个是自己
		N = 0;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int size(){
		return N;
	}
	
	public void add(Item item){
		Node newNode = new Node(item);
		if (head.next == head) {
			head.next = newNode;
			newNode.next = head;
			N++;
		}else {
			Node current = head;
			while (current.next!= head) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;
			N++;
		}
	}
	
	public void remove(){
		if (N == 0) {
			throw new NoSuchElementException();
		}
		if (N == 1) {
			head.next = head;
		}else {
			Node current= head ;
			while (current.next.next!= head) {
				current = current.next;
			}
			current.next = head;
			N--;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sbBuilder = new StringBuilder();
		Node current = head;
		while(current.next != head){
			sbBuilder.append(current.next.item);
			sbBuilder.append(" ");
			current = current.next;
		}
		return sbBuilder.toString();
	}

	public static void main(String[] args) {
		CircularLinkedList<String> circularLined = new CircularLinkedList<>();
		circularLined.add("aaa");
		circularLined.add("aaa");
		circularLined.add("aaa");
		circularLined.add("aaa");
		circularLined.remove();
		System.out.println(circularLined.size());
		System.out.println(circularLined.toString());
	}

}
