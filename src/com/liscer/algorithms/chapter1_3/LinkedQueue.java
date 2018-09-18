package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链表实现队列 有泛型和迭代器
 * @author libaojia
 *
 * @param <Item>
 */
//第三次练习
public class LinkedQueue<Item> implements Iterable<Item>{
	
	private Node first;
	private Node last;
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public LinkedQueue(){
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
	
	public void enqueue(Item item){
		Node oldNode = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}else {
			oldNode.next = last;
		}
		N++;
	}
	
	public Item dequeue(){
		if (isEmpty()) {
			throw new NoSuchElementException("queue underflow");
		}
		Item item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;//!!!!!!!!!!!!!!!!!!!!!栈底出栈后,没有元素的情况first肯定为空,需要管last为null,避免游离
		}
		N--;
		return item;
	}
	
	public Item peek(){
		if (isEmpty()) {
			throw new NoSuchElementException("queue underflow");
		}
		return first.item;
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
		private Node current = first;

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
		LinkedQueue<String> linkedQueue = new LinkedQueue<>();
		linkedQueue.enqueue("asd");
		linkedQueue.enqueue("eee");
		linkedQueue.enqueue("rrrr");
		linkedQueue.dequeue();
		linkedQueue.enqueue("iiiiiii");
		System.out.println("peek:"+linkedQueue.peek()+" size:"+linkedQueue.size());
		System.out.println(linkedQueue.toString());
	}
	
}












/*public class LinkedQueue<Item> implements Iterable<Item>{

	private Node first;
	private Node last;
	private int N;
	
	public LinkedQueue(){
		first = null;
		last = null;
		N = 0;
	}
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public void enqueue(Item item){
		Node oldNode= last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}else {
			oldNode.next = last;
		}
		N++;
	}
	
	public Item dequeue(){
		if (isEmpty()) {
			throw new NoSuchElementException("queue underfolw");
		}
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) {
			last  = null;
		}
		return item;
	}
	
	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("queue underflow");
		}
		return first.item;
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		for (Item item : this) {
			sBuilder.append(item+" ");
		}
		return sBuilder.toString();
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			current = current.next;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		LinkedQueue<String> linkedQueue = new LinkedQueue<>();
		linkedQueue.enqueue("asd");
		linkedQueue.enqueue("eee");
		linkedQueue.enqueue("rrrr");
		linkedQueue.dequeue();
		linkedQueue.enqueue("iiiiiii");
		System.out.println("peek:"+linkedQueue.peek()+" size:"+linkedQueue.size());
		System.out.println(linkedQueue.toString());
	}
	
}*/

















/*public class LinkedQueue<Item> implements Iterable<Item> {
	
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
	
	LinkedQueue<String> linkedQueue = new LinkedQueue<>();
		linkedQueue.enqueue("asd");
		linkedQueue.enqueue("eee");
		linkedQueue.enqueue("rrrr");
		linkedQueue.dequeue();
		System.out.println("peek:"+linkedQueue.peek()+" size:"+linkedQueue.size());
		System.out.println(linkedQueue.toString());

	}
}*/
