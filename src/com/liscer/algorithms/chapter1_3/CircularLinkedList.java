package com.liscer.algorithms.chapter1_3;

import java.util.NoSuchElementException;

public class CircularLinkedList<Item> {

	private Node head;
	private int N;

	class Node {
		Item item;
		Node next;

		public Node(Item item) {
			this.item = item;
		}
	}

	public CircularLinkedList() {
		head = new Node(null);
		head.next = head;// 没有节点的时候head的下一个是自己
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void add(Item item) {
		Node newNode = new Node(item);
		Node current = head;
		while (current.next != head) {
			current = current.next;
		}
		current.next = newNode;
		newNode.next = head;
		N++;
	}

	public void add(Item item, int index) {
		if (index < 0 || index > N - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			Node current = head.next ;
			int counter = 0;
			while (current != head) {// 游标先去,移动在后,在while里只能操作前一个
				if (index == counter++) {
					Node newNode = new Node(item);
					newNode.next = current.next;
					current.next = newNode;
					N++;
					return;
				}
				current = current.next;
			}
		}
	}

	public void remove() {
		if (N == 0) {
			throw new NoSuchElementException();
		}
		if (N == 1) {
			head.next = head;
			N--;
		} else {
			Node current = head;
			while (current.next.next != head) {
				current = current.next;
			}
			current.next = head;
			N--;
		}
	}
	
	public void delete(int index){
		if (index < 0 || index>N-1) {
			throw new IndexOutOfBoundsException();
		}else if (index == N-1) {
			remove();
		}else {
			int counter = 0;
			for(Node current = head;current != null;current = current.next){
				if (index == counter++) {
					current.next = current.next.next;
					N--;
					return;
				}
			}
		}
	}

	public Item get(int index) {
		if (index < 0 || index > N - 1) {
			throw new IndexOutOfBoundsException();
		}
		int counter = 0;
		Node current = head.next;
		while (current != head) {
			if (index == counter++) {
				return current.item;
			}
			current = current.next;
		}
		return null;
	}

	public boolean find(CircularLinkedList<Item> linked, Item key) {
		Node current = linked.head;
		while (current.next != head) {
			if (key.equals(current.item)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sbBuilder = new StringBuilder();
		Node current = head;
		while (current.next != head) {
			sbBuilder.append(current.next.item);
			sbBuilder.append(" ");
			current = current.next;
		}
		return sbBuilder.toString();
	}

	public static void main(String[] args) {
		CircularLinkedList<String> circularLined = new CircularLinkedList<>();
		circularLined.add("aaa");
		circularLined.add("bbb");
		// circularLined.add("aaa");
		// circularLined.add("aaa");
		// circularLined.remove();
		// circularLined.remove();
		// circularLined.remove();
		circularLined.add("ccc");
		// circularLined.add("bbb");
		//System.out.println(circularLined.size());
		//circularLined.add("ddd",1);
		circularLined .delete(0);
		System.out.println(circularLined.toString());
		System.out.println(circularLined.isEmpty());
		System.out.println(circularLined.size());
		//System.out.println(circularLined.get(2));
		//System.out.println(circularLined.find(circularLined, "aaa"));
	}

}
