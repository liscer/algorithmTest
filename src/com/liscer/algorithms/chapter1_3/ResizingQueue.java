package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import edu.princeton.cs.algs4.Queue;

/**
 * 数组实现队列,出列操作如果每次都去掉第一个元素,每次每个元素都要移位,解决方案是纪录第一个元素,出列时first指向下一个元素,
 * 所以a[first]可能不是数组的第一个元素.带来了一个问题就是增长数组的时候,拷贝给新数组的下标(first+i)%a.length解决
 * @author libaojia
 *
 * @param <Item>
 */
public class ResizingQueue<Item> implements Iterable<Item>{
	
	private Item[] a;
	private int first;
	private int last;
	private int N;
	
	public ResizingQueue(){
		a = (Item[])new Object[2];
		first= 0;
		last = 0;
		N= 0;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void resize(int caption){
		Item[] temp = (Item[])new Object[caption];
		for (int i = 0; i < N; i++) {
			temp[i] = a[(first+i)%a.length];	
		}
		a = temp;
		first = 0;
		last = N;
	}
	
	public void enqueue(Item item){
		if (N == a.length) {
			resize(a.length*2);
		}
		a[last++] = item;
		N++;
		if (last == a.length) {
			last = 0;
		}
	}
	
	public Item dequeue(){
		if (isEmpty()) {
			throw new NoSuchElementException("queue underflow");
		}
		Item item = a[first];
		a[first] = null;
		first++;
		N--;
		if (first == a.length) {
			first =0;
		}
		if (N >0 && N==a.length/4) {
			resize(a.length/2);
		}
		return item;
	}
	
	public Item peek(){
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return a[first];
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
	
	private class ListIterator implements Iterator<Item> {
		private int i = 0;

		@Override
		public boolean hasNext() {
			return i < N;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException("o");
			}
			Item item = a[(first+i)%a.length];
			i++;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		ResizingQueue<String> resizingQueue = new ResizingQueue<>();
		resizingQueue.enqueue("asd");
		resizingQueue.enqueue("eee");
		resizingQueue.enqueue("vvvv");
		resizingQueue.enqueue("uuuu");
		resizingQueue.enqueue("qqqqqq");
		resizingQueue.enqueue("qqqqqq");
		resizingQueue.enqueue("qqqqqq");
		//resizingQueue.enqueue("qqqqqq");
		resizingQueue.dequeue();
		resizingQueue.dequeue();
		resizingQueue.dequeue();
		resizingQueue.dequeue();
		resizingQueue.enqueue("bbbbbb");
		resizingQueue.enqueue("rrrr");
		System.out.println(resizingQueue.toString());
	}
	
}








/*public class ResizingQueue<Item> implements Iterable<Item>{
	
	private Item[] a;
	private int first;
	private int last;
	private int N;
	
	public ResizingQueue() {
		a = (Item[])new Object[2];
		first = 0;
		last = 0;
		N = 0;
	}
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	private void resize(int capacity){
		Item[] temp = (Item[])new Object[capacity];
		for (int i = 0; i < N; i++) {
			temp[i] = a[(first+ i)%a.length];
		}
		a = temp;
		last = N;
	}
	
	public void enqueue(Item item){
		if(N == a.length){
			resize(a.length*2);
		}
		a[last++]=item;
		if (last == a.length) {
			last = 0;
		}
		N++;
	}
	
	public Item dequeue(){
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		Item item = a[first];
		a[first]=null;
		first++;
		if (first == a.length) {
			first = 0;
		}
		N--;
		if (N>0 && N == a.length/4) {
			resize(a.length/2);
		}
		return item;
	}
	
	public Item peek(){
		if (isEmpty()) {
			throw new NoSuchElementException("Queue overflow");
		}
		return a[first];
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this) {
			s.append(item +" ");
		}
		return s.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private int i = 0;

		@Override
		public boolean hasNext() {
			return i<N;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = a[(i+first)%a.length];
			i++;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		ResizingQueue<String> resizingQueue = new ResizingQueue<>();
		resizingQueue.enqueue("asd");
		resizingQueue.enqueue("eee");
		resizingQueue.enqueue("vvvv");
		resizingQueue.enqueue("uuuu");
		resizingQueue.enqueue("qqqqqq");
		resizingQueue.enqueue("qqqqqq");
		resizingQueue.enqueue("qqqqqq");
		//resizingQueue.enqueue("qqqqqq");
		resizingQueue.dequeue();
		resizingQueue.dequeue();
		resizingQueue.dequeue();
		resizingQueue.dequeue();
		resizingQueue.enqueue("bbbbbb");
		resizingQueue.enqueue("rrrr");
		System.out.println(resizingQueue.toString());
	}
	
}*/









/*public class ResizingQueue<Item> implements Iterable<Item> {
	
	private Item[] a ;
	private int first;
	private int last;
	private int N;
	
	public ResizingQueue() {
		a = (Item[])new Object[2];
		first = 0;
		last = 0;
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		Item[] temp = (Item[])new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[(first +i)%a.length];//执行出列操作的时候,first会移动,进行数组扩充的时候,temp数组即要复制到的数组
		}                                    //temp[0]=temp[first+0],temp[1]=temp[first+1]...
		a = temp;                        
		first = 0;                       
		last = N; 
	}

	public void enqueue(Item item) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[last++] = item;
		if (last == a.length) {         //last和first不能等于a.length,否则会越界,当last=length的时候就要扩充数组了,
			last = 0;                   //第二种情况,多次dequeue直到first到了N/2+1时,后面的元素也都被占满再进行enqueue时,
		}                               //借用a[0]也就是被dequeue的归零的元素进行保存数据
		N++;
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		Item item = a[first];
		a[first]=null;
		N--;
		first++;
		if (first == a.length) {        //first=length的时候是数组没有元素的时候,需要归零
			first =0;
		}
		if (N > 0&& N==a.length/4) {
			resize(a.length/2);
		}
		return item;
	}
	
	public Item peek() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		return a[first];
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
		private int i = 0;
		@Override
		public boolean hasNext() {
			return i < N;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = a[(i+first)%a.length];
			i++;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		ResizingQueue<String> resizingQueue = new ResizingQueue<>();
		resizingQueue.enqueue("asd");
		resizingQueue.enqueue("eee");
		resizingQueue.enqueue("vvvv");
		resizingQueue.enqueue("uuuu");
		resizingQueue.enqueue("qqqqqq");
		resizingQueue.enqueue("qqqqqq");
		resizingQueue.enqueue("qqqqqq");
		//resizingQueue.enqueue("qqqqqq");
		resizingQueue.dequeue();
		resizingQueue.dequeue();
		resizingQueue.dequeue();
		resizingQueue.dequeue();
		resizingQueue.enqueue("bbbbbb");
		resizingQueue.enqueue("rrrr");
		System.out.println(resizingQueue.toString());
	}

}*/
