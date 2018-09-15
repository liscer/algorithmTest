package com.liscer.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
			temp[i] = a[(first +i)%a.length];
		}
		a = temp;
		first = 0;
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
		resizingQueue.enqueue("rrrr");
		System.out.println(resizingQueue.toString());
	}

}
