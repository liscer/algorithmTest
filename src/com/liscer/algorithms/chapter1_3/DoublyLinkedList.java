package com.liscer.algorithms.chapter1_3;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
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
		public Node(Item item) {
			this(null, item, null);
		}
	}
	
	public boolean isEmpty(){
		return N ==0;
	}
	
	public int size(){
		return N;
	}
	
	public void addFirst1(Item item){
		linkFirst(item);
	}
	/**
	 * 这个思路很难掌握呀 ,先记住第一个,初始化新加入节点,新节点为first,第一次插入节点last也是新加入节点
	 * 不是第一次添加,修改以前的头结点的前驱为新节点
	 * @param item
	 */
	private void linkFirst(Item item){
		Node<Item> f = first;
		Node<Item> newNode = new Node<>(null, item, f);
		first = newNode;
		if (f == null) {
			last = newNode;
		} else {
			f.prev = newNode;
		}
		N++;
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
	
	public Item get(int index){
		if (index < 0 || index > N-1) {
			throw new IndexOutOfBoundsException("out");
		}
		return node(index).item;
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
	
	public boolean contains(Object o){
		return indexOf(o)!= -1;
	}
	
	/**
	 * 根据对象获得匹配的第一个索引,对象可以是null,从头遍历找
	 * @param o
	 * @return
	 */
	public int indexOf(Object o){
		int index=0;
		if (o == null) {
			for (Node<Item> current = first;current!=null;current = current.next) {
				if (current.item == null) {
					return index;
				}
				index++;
			}
		}else {
			for(Node<Item> current = first;current!=null;current = current.next){
				if (current.item.equals(o)) {
					return index;
				}
				index++;
			}
		}
		return -1;
	}
	/**
	 * 根据对象获得匹配的第一个索引,对象可以是null,从尾遍历找
	 * @param o
	 * @return
	 */
	public int lastIndexOf(Object o){
		int index=N;
		if (o == null) {
			for (Node<Item> current = last;current!=null;current = current.prev) {
				index--;
				if (current.item == null) {
					return index;
				}
			}
		}else {
			for(Node<Item> current = last;current!=null;current = current.prev){
				index--;
				if (current.item.equals(o)) {
					return index;
				}
			}
		}
		return -1;
	}
	/**
	 * 删除第一个节点实现方法,
	 * @param f
	 * @return 返回删除的节点元素
	 */
	private Item unlinkFirst(Node<Item> f){
		final Item item = f.item;
		final Node<Item> next = f.next;
		f.item = null;//消除游离,帮助垃圾回收器回收
		f.next = null;
		first = next;//如果只剩一个节点删除,他的下一个是null,first也就是空了
		if (next == null) {//如果first为空那么last也为null
			last = null;
		}else {//否则切断第二个节点的前驱
			next.prev = null;
		}
		N--;
		return item;
	}
	
	public Item removeFirst(){
		final Node<Item> f = first;
		if (f==null) {
			throw new NoSuchElementException();
		}
		return unlinkFirst(f);
	}
	
	public Item removeLast() {
		final Node<Item> l = last;
		if (l == null) {
			throw new NoSuchElementException();
		}
		return unlinkLast(l);
	}
	/**
	 * 删除最后一个节点
	 * @param l
	 * @return
	 */
	private Item unlinkLast(Node<Item> l){
		final Item item = l.item;
		final Node<Item> prev = l.prev;
		l.item = null;
		l.prev = null;
		last = prev;
		if (prev == null) {
			first = prev;
		}else {
			prev.next = null;
		}
		N--;
		return item;
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
		System.out.println("我删除了一个节点他是: " + current.item);
	}
	/**
	 * 官方代码写的真NB,两个ifelse解决了指针指向和游离,更厉害的是,首尾删除和中间删除有重合操作,删头节点的前驱为空可以
	 * 通过第二个ifelse解决,删除尾节点的后驱为空可以通过第一个ifelse解决.删除中间节点在两个else里完成
	 * @param x
	 * @return 删除节点元素
	 */
	Item unlink(Node<Item> x){
		final Item item = x.item;
		final Node<Item> next= x.next;
		final Node<Item> prev = x.prev;
		if (prev ==null) {
			first = next;
		}else {
			prev.next = next;
			x.prev = null;
		}
		if (next ==null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}
		x.item = null;
		N--;
		return item;
	}
	
	public boolean delete2(Object o) {
		if (o == null) {
			for(Node<Item> current = first;current != null;current = current.next){
				if (current.item == null) {
					unlink(current);
					return true;
				}
			}
		}else {
			for(Node<Item> current = first;current != null;current = current.next){
				if (current.item.equals(o)) {
					unlink(current);
					return true;
				}
			}
		}
		return false;
	}
	
	public Item delete1(int index){
		if (index < 0 || index > N-1) {
			throw new IndexOutOfBoundsException();
		}
		return unlink(node(index));
	}
	
	public Item get1(int index){
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
	/**
	 * 将集合从指定位置开始插入,第一种情况,尾部插入.第二种情况头中部插入
	 * 1.检查index范围是否在size之内
		2.toArray()方法把集合的数据存到对象数组中
		3.得到插入位置的前驱和后继节点
		4.遍历数据，将数据插入到指定位置
	 * @param index
	 * @param c
	 * @return
	 */
	public boolean addAll(int index,Collection<? extends Item> c) {
		if (index < 0 || index > N) {
			throw new IndexOutOfBoundsException();
		}
		Object[] o = c.toArray();
		int numnew = o.length;
		if(numnew == 0){
			return false;
		}
		Node<Item> pred,nextd;//得到插入位置的前驱后驱
		if (index == N) {//如果插入位置是尾部,前驱是last,后驱为null;
			pred = last;
			nextd = null;
		}else {			//否则调用node(index)得到后驱节点
			nextd = node(index);
			pred = nextd.prev;//前驱节点是后驱节点的prev
		}
		for (Object object : o) {
			Item item = (Item) object;
			Node<Item> newNode = new Node<>(pred, item, null);//初始化就已经完成新节点的前驱
			if (pred == null) {//如果插入位置是头部
				first = newNode;
			}else {//前置节点的下一个是新节点
				pred.next = newNode;
			}
			pred = newNode;//将前置节点指向新节点进行下一次循环
		}
		if (nextd ==null) {//如果是尾部插入
			last = pred;
		}else {				//插入链表与原来的链表连接
			pred.next = nextd;
			nextd.prev = pred;
		}
		N += numnew;
		return true;
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
	}

}
