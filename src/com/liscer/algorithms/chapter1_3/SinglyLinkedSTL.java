package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
/**
 * 单向链表的标准库,注重于API设计,是有头结点
 * @author libaojia
 *
 * @param <Item>每个节点所储存的元素类型
 */
public class SinglyLinkedSTL<Item> implements Iterable<Item> {
	
	private Node head;
	private int N;
	
	class Node{
		Item item;
		Node next;
		public Node(Item item) {
			this.item = item;
		}
	}
	
	public SinglyLinkedSTL() {
		head = new Node(null);
		N = 0;
	}
	
	public boolean isEmpty(){
		return N ==0;
	}
	
	public int size(){
		return N;
	}
	 //找到第index个结点前的结点
	private Node location(int index) {
		Node current = head;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}
	
	public void add(Item item) {
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		Node node = new Node(item);
		node.next = current.next;
		current.next = node;
		N++;
	}
	//在第index结点前插入结点
	public void addBefore(Item item,int index){
		if (index < 0 || index > N) {
			throw new IndexOutOfBoundsException("outof");
		}
		Node current = location(index);
		Node newNode = new Node(item);
		newNode.next = current.next;
		current.next = newNode;
		N++;
	}
	//在第index结点后插入结点
	public void addAfter(Item item,int index){
		if (index < 0 || index > N-1) {
			throw new IndexOutOfBoundsException("outof");
		}
		addBefore(item, index + 1);
	}
	//永远插入第一个节点,连续插入式头插法
	public void addFirst(Item item) {
		addBefore(item, 0);
	}
	//永远插入最后一个节点
	public void addLast(Item item) {
		addBefore(item, N);
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		Node current = head;
		while (current.next!=null) {
			sBuilder.append(" ");
			sBuilder.append(current.next.item);
			current = current.next;
		}
		return sBuilder.toString();
	}

	public static void main(String[] args) {
		SinglyLinkedSTL<String> SLinked = new SinglyLinkedSTL<>();
//		SLinked.add("aaa");
//		SLinked.add("bbb");
//		SLinked.add("ccc");
//		SLinked.add("ddd");
		//SLinked.addFirst("eee");
		//SLinked.addBefore("fff", 5);
		//SLinked.addLast("eee");
		SLinked.addLast("a");
		SLinked.addLast("b");
		System.out.println(SLinked);
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
