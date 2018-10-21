package com.liscer.algorithms.chapter1_3;

import java.util.NoSuchElementException;
/**
 * 双向链表有头和尾,头和尾都是链表中的元素
 * @author libaojia
 *
 * @param <Item>
 */
public class DoublyLinkedList<Item> {
	
	private Node<Item> first;
	private Node<Item> last;
	private int N;
	
	public DoublyLinkedList(){
		first = null;
		last = null;
		N = 0;
	}
	
	private static class Node<Item>{
		Node<Item> prev;
		Item item;
		Node<Item> next;
		public Node(Item item){
			this.item = item;
		}
	}
	
	public boolean isEmpty(){
		return N ==0;
	}
	
	public int size(){
		return N;
	}
	
	public void addLast(Item item) {
		Node<Item> node = new Node<>(item);
		if (N == 0) {
			this.first = node;
			this.last = node;
		}else {
			this.last.next = node;
			node.prev = this.last;
			this.last = node;
		}
		N++;
	}
	
	public void addFirst(Item item) {
		Node<Item> node = new Node<>(item);
		if (N == 0) {
			this.first = node;
			this.last = node;
		}else {
			node.next = this.first;
			this.first.prev = node;
			this.first = node;
		}
		N++;
	}
	
	public void remove() {
		if (N == 0) {
			throw new NoSuchElementException("什么都没有了不能再移除元素了");
		}
		if (N == 1) {
			first = null;
			last = null;
		}else {
			last.prev.next = null;
			last = last.prev;
		}
		N--;
	}
	
	public void delete(int index){
		if (index < 0 || index > N -1) {
			throw new IndexOutOfBoundsException("越界了");
		}
		
	}
	
	public void delete(Item item){
		Node<Item> current = this.first;
		while (current!= null) {
			if (current.item.equals(item)) {
				break;
			}
			current = current.next;
		}
		if (current == first) {
			first = current.next;
			first.prev = null;
		}else if (current == last) {
			last = current.prev;
			last.next = null;
		}else {
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}
		N--;
		System.out.println("我厉害吧,我删除了一个节点他是: " + current.item);
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
		DoublyLinkedList<String> linked = new DoublyLinkedList<>();
		linked.addLast("aaa");
		linked.addLast("bbb");
		linked.addFirst("ccc");
		//linked.remove();
		//linked.remove();
		//linked.remove();
		linked.delete("ccc");
		System.out.println(linked.N);
		System.out.println(linked.toString());
	}

}
