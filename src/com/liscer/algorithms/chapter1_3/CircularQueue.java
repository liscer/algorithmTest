package com.liscer.algorithms.chapter1_3;

import java.util.NoSuchElementException;

public class CircularQueue<Item> {
	
	private Node head;
	private int N;
	
	public CircularQueue(){
		head = new Node(null);
		head.next = head;
		N = 0;
	}
	
	class Node{
		Item item;
		Node next;
		public Node(Item item){
			this.item = item;
		}
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	/**
	 * 从尾增加
	 */
	public void enqueue(Item item) {
		Node newNode = new Node(item);
		Node current = head;
		while (current.next != head) {
			current = current.next;
		}
		current.next = newNode;
		newNode.next = head;
		N++;
	}
	/**
	 * 从头删除
	 * @return
	 */
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item item = head.next.item;
		head.next = head.next.next;
		if (isEmpty()) {
			head.next = head;
		}
		N--;
		return item;
	}

	public static void main(String[] args) {
		CircularQueue<String> circularQueue = new CircularQueue<>();
		circularQueue.enqueue("aaa");
		circularQueue.enqueue("bbb");
		circularQueue.enqueue("cccc");
		System.out.println(circularQueue.dequeue());
		System.out.println(circularQueue.dequeue());
		System.out.println(circularQueue.dequeue());

	}

}
