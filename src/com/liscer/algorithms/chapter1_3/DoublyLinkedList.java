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
		Node(Node<Item> prev,Item item,Node<Item> next){
			this.item = item;
			this.prev = prev;
			this.next = next;
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
	
	void linkLast(Item item){
		Node<Item> l = last;
		Node<Item> newNode = new Node<>(l,item,null);
		last = newNode;
		if (l == null) {
			first = newNode;
		}else {
			l.next = newNode;
		}
		N++;
	}
	/**
	 * 高手的思路,通过Node构造方法解决前后指针的指向,
	 * @param item
	 */
	void addLast1(Item item){
		Node<Item> l = last;
		Node<Item> newNode = new Node<>(l, item, null);
		last = newNode;
		if (l == null) {
			first = newNode;
		}else {
			l.next = newNode;
		}
		N++;
	}
	
	public void add(Item item,int index){
		if (index < 0 || index > N-1) {
			throw new IndexOutOfBoundsException("out");
		}
		if (index == N) {
			linkLast(item);
		} else {
			linkBefore(item,node(index));
		}
	}
	/**
	 * 先解决新增节点的前后指向,记住原来的前节点,修改node的前节点为新加入的节点,
	 * 修改原来的前节点的后节点为新节点,考虑第一次增加节点的情况,让新节点为first节点
	 * @param item
	 * @param node
	 */
	void linkBefore(Item item,Node<Item> node){
		Node<Item> pred = node.prev;
		Node<Item> newNode = new Node<>(pred, item, node);
		node.prev = newNode;
		if (pred == null) {
			first = newNode;
		}else {
			pred.next = newNode;
		}
		N++;
	}
	
	Node<Item> node(int index){
		if (index < (N >>1)) {//相当于N / 2 取整
			Node<Item> current = first;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current;
		} else {
			Node<Item> current = last;
			for (int i = N-1; i > index; i--) {
				current = current.next;
			}
			return current;
		}
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
		Node<Item> current = this.first;
		for(int i = 0;i < N;i++){
			if (index == i) {
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
	
	public Item get(int index){
		if (index < 0 || index > N -1) {
			throw new IndexOutOfBoundsException("越界了");
		}
		Node<Item> current = this.first;
		for(int i = 0;i < N;i++){
			if (index == i) {
				return current.item;
			}
			current = current.next;
		}
		return null;
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
//		DoublyLinkedList<String> linked = new DoublyLinkedList<>();
//		linked.addLast("aaa");
//		linked.addLast("bbb");
//		linked.addFirst("ccc");
		//linked.remove();
		//linked.remove();
		//linked.remove();
//		linked.delete(3);
//		System.out.println(linked.N);
//		System.out.println(linked.toString());
		System.out.println(500 >> 3);
		System.out.println(-500/8);
	}

}
