package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 单向链表实现 从后面添加,从后面删除
 * @author libaojia
 *
 */
public class SinglyLinkedList<Item> implements Iterable<Item>{
	
	private Node head;
	private int N;
	
	private class Node{
		Item item;
		Node next;
		
		Node(Item item){
			this.item = item;
		}
	}
	
	public SinglyLinkedList(){
		head = null;
		N = 0;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int size(){
		return N;
	}
	
	public void add(Item item){
		Node node = new Node(item);
		if (head == null) {
			head = node;
		}else {
			Node temp= head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
		}
		N++;
	}
	
	public void remove(){
		if (N== 0) {
			throw new NoSuchElementException("Linked underflow");
		}
		if (N== 1) {
			head = null;
		}else {
			for(Node n = head;n!=null;n = n.next){
				if (n.next.next == null)
                    n.next = null;
			}
		}
		N--;
	}
	
	public void delete(int k) {
		if (k==0 || k >=N) {
			throw new NoSuchElementException("k out");
		}
		int n = 1;
		Node temp = head;
		while(temp!=null){
			if (k == n++) {
				temp.next = temp.next.next;
				N--;
				return;
			}
			temp = temp.next;
		}
	}
	
	public  boolean find(SinglyLinkedList<Item> linked, Item key) {
		Node temp = linked.head;
		while(temp!=null){
			if (key.equals(temp.item)) {
				return false;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public Item peek(){
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		for (Item item : this) {
			sBuilder.append(item + " ");
		}
		return sBuilder.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current = head ;

		@Override
		public boolean hasNext() {
			return current!= null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;//必须是current,而不是first,循环改变的是current
			current = current.next;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
		linkedList.add("aaa");
		linkedList.add("bbb");
		linkedList.add("ccc");
		linkedList.add("ddd");
		linkedList.add("eee");
		//linkedList.remove();
		linkedList.delete(3);
		System.out.println(linkedList.N);
		System.out.println(linkedList.toString());
	}

}
