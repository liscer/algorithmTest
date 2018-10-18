package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 单向链表实现 从后面添加,从后面删除  
 * 一.head new了,第一个head节点只是为了指向第一个节点,他不能算节点
 * 二.head初始化为null,add的时候要判空
 * @author libaojia
 * 
 */
public class SinglyLinkedList<Item> implements Iterable<Item>{
	
	private Node head;
	private int N;
	
	public SinglyLinkedList(){
		head = new Node(null);
		N = 0;
	}
	private class Node{
		Item item;
		Node next;
		
		public Node(Item item) {
			this.item = item;
		}
	}
	
	public boolean isEmpty() {
		return head.next == null;
	}
	
	public int size(){
		return N;
	}
	
	public void add(Item item) {
		Node node = new Node(item);
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		N++;
	}
	
	public void addhead(Item item) {
		Node node = new Node(item);
		node.next = head.next;
		head.next = node;
	}
	/**
	 * 节点后增加
	 * @param item
	 * @param index
	 */
	public void add(Item item,int index){
		if (index < 0 || index > N -1) {
			throw new IndexOutOfBoundsException();
		}else {
			Node temp = head;//游标跟移动是同时的
			int counter = -1;
			while (temp != null) {
				if (index == counter++) {
					Node node = new Node(item);
					Node back = temp.next;
					temp.next = node;
					node.next = back;
					N++;
					return;
				}
				temp = temp.next;
			}
		}
	}
	
	public void remove() {
		if (N == 0) {
			throw new NoSuchElementException();
		}
		if (N == 1) {
			head.next = null;
			N--;
		}else {
			for(Node n = head;n!=null;n = n.next){
				if (n.next.next==null) {
					n.next = null;
				}
			}
			N--;
		}
	}
	
	public void delete(int index) {
		if (index<0||index>N-1) {
			throw new IndexOutOfBoundsException();
		}else {
			Node temp = head;
			int counter = -1;
			while (temp != null) {
				if ((index-1) == counter++) {
					temp.next = temp.next.next;
					N--;
					return;
				}
				temp = temp.next;
			}
		}
	}
	/**1.3.26
	 * 神级逻辑,当前节点的下一个元素为key值要移动当前节点的下一个的下一个,当前节点下一个元素不为key
	 * 的要移动到 当前节点的下一个,head节点肯定不为空,但是head.item为空
	 * @param key
	 */
	public void removeAllKey(String key) {
		if (N ==0) {
			throw new NoSuchElementException();
		}
		Node temp = head;
		while (temp.next != null) {
			if (temp.next.item.equals(key)) {
				temp.next = temp.next.next;
				N--;
			}else {
				temp = temp.next;	
			}
		}
	}
	
	public Item get(int index){
		if (index<0||index> N-1) {
			throw new IndexOutOfBoundsException();
		} else {
			Node temp = head;
			int counter = -1;
			while (temp!=null) {
				if(index == counter++){
					return temp.item;
				}
				temp = temp.next;
			}
		}
		return null;
	}
	
	public boolean find(SinglyLinkedList<Item> linked,Item key) {
		Node temp = linked.head;
		while (temp!=null) {
			if(key.equals(temp.item)){
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	/**1.3.24
	 * 删除指定坐标后的所有节点,从0开始计数
	 * @param index
	 */
	public void removeAfter(int index){
		if (index < 0 || index > N-1) {
			throw new IndexOutOfBoundsException();
		}
		if (index == N -1) {
			return;
		}
		Node temp = head;
		int counter = -1;
		while (temp != null) {
			if (index == counter++) {
				temp.next = null;
				break;
			}
			temp = temp.next;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		for (Item item:this) {
			sBuilder.append(item+" ");
		}
		return sBuilder.toString();
	}


	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		
		Node current = head.next;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
		linkedList.add("aaa");
		//linkedList.add("aaa");
		//linkedList.add("aaa");
		linkedList.add("bbb");
		//linkedList.add("fff", 1);
		//linkedList.add("bbb");
		//linkedList.add("aaa");
		//linkedList.add("aaa");
		linkedList.add("ccc");
	    //linkedList.remove();
	    //linkedList.remove();
	    //linkedList.remove();
		//linkedList.delete(0);
		//System.out.println("之前"+linkedList.N);
		//System.out.println(linkedList.get(0));
		//System.out.println(linkedList.find(linkedList, "ccc"));
		//System.out.println(linkedList.find(linkedList, "eee"));
		//linkedList.removeAfter(2);
		//linkedList.removeAllKey("aaa");
		System.out.println("之后"+linkedList.N);
		linkedList.add("ddd", 2);
		System.out.println(linkedList.toString());
		//System.out.println(linkedList.isEmpty());
		//System.out.println(linkedList.find(linkedList, "aaa"));
	}
}














/*public class SinglyLinkedList<Item> implements Iterable<Item> {

	private Node head;
	private int N;

	private class Node {
		Item item;
		Node next;

		Node(Item item) {
			this.item = item;
		}
	}

	public SinglyLinkedList() {
		head = new Node(null);
		N = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return N;
	}
	*//**
	 * 从头增加元素
	 * @param item 
	 *//*
	public void add(Item item) {
		Node node = new Node(item);

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		N++;
	}
	*//**
	 * 从指定位置增加元素,从0开始计数
	 * @param item
	 * @param index
	 *//*
	public void add(Item item,int index){
		if (index < 0 || index > N - 1) {
			throw new ArrayIndexOutOfBoundsException("index 越界");
		}else {
			Node temp = head;
			int counter = -1;
			while(temp.next != null){
				if ((index-1) == counter) {
					Node node = new Node(item);
					Node back = temp.next;
					temp.next = node;
					node.next = back;
					N++;
				}
				temp = temp.next;
				counter++;
			}
		}
	}
	*//**
	 * 移除最后一个元素
	 *//*
	public void remove() {
		if (N == 0) {
			throw new NoSuchElementException("Linked underflow");
		}
		if (N == 1) {
			head = null;
		} else {
			for (Node n = head; n != null; n = n.next) {
				if (n.next.next == null)
					n.next = null;
			}
		}
		N--;
	}
	*//**1.3.20
	 * 移除指定位置元素,从0开始计数
	 * @param k
	 *//*
	public void delete(int k) {
		if (k < 0 || k > N) {
			throw new ArrayIndexOutOfBoundsException("k out");
		}
		int n = -1;
		Node temp = head;
		while (temp != null) {
			if ((k-1) == n++) {//删除节点只能定位到前一个节点才能删除需要删除的节点
				temp.next = temp.next.next;
				N--;
				return;
			}
			temp = temp.next;
		}
	}
	*//**
	 * 获得指定位置元素,从零开始计数
	 * @param index
	 * @return
	 *//*
	public Item get(int index) {
		if (index < 0 || index > N - 1) {
			throw new ArrayIndexOutOfBoundsException("index 越界");
		} else {
			Node temp = head;
			int counter = -1;
			while (temp != null) {
				if (counter == index) {
					return temp.item;
				}
				temp = temp.next;
				counter++;
			}
		}
		return null;
	}
	*//**1.3.21
	 * 这个单链表是否存在这个元素
	 * @param linked
	 * @param key
	 * @return
	 *//*
	public boolean find(SinglyLinkedList<Item> linked, Item key) {
		Node temp = linked.head;
		while (temp != null) {
			if (key.equals(temp.item)) {
				return false;
			}
			temp = temp.next;
		}
		return false;
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

	private class ListIterator implements Iterator<Item> {
		private Node current = head.next;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;// 必须是current,而不是first,循环改变的是current
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
		// linkedList.remove();
		linkedList.delete(0);
		System.out.println(linkedList.N);
		System.out.println(linkedList.toString());
		System.out.println(linkedList.get(0));
	}

}*/
