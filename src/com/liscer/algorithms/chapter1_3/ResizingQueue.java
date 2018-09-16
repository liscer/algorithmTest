package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * 数组实现队列,出列操作如果每次都去掉第一个元素,每次每个元素都要移位,解决方案是纪录第一个元素,出列时first指向下一个元素,
 * 所以a[first]可能不是数组的第一个元素.带来了一个问题就是增长数组的时候
 * @author libaojia
 *
 * @param <Item>
 */
public class ResizingQueue<Item> implements Iterable<Item> {
	
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
		a = temp;                        //到了a[temp[a.length-first]元素时,需要元素值为零,用a[(first +i)%a.length]
		first = 0;                       //刚好满足,因为a[a.length-first]之前的元素都进型出列操作,都被赋值为0;
		last = N; 
	}

	public void enqueue(Item item) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[last++] = item;
		if (last == a.length) {
			last = 0;
		}
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
		if (first == a.length) {
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
		resizingQueue.dequeue();
		resizingQueue.enqueue("vvvv");
		resizingQueue.enqueue("uuuu");
		System.out.println(resizingQueue.toString());
	}

}
