package com.liscer.algorithms.chapter1_2;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {
	private int n,count,N,max;
	public  VisualCounter(int N,int max) {
		n = 0;
		count = 0;
		this.N = N;
		this.max = max;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(-max,max);
		StdDraw.setPenRadius(0.01);
		StdDraw.point(0, 0);
	}
	
	public void increment() {
		if (n + 1 > N) {
			System.out.println("Operate too much!");
			return;
		}
		if (count +1 > max) {
			System.out.println("exceed the max");
			return;
		}
		n++;
		count++;
		StdDraw.point(n, count);
	}
	
	public void decrement(){
		if (n+ 1>N) {
			System.out.println("Operate too much!");
			return;
		}
		if (count -1 < -max) {
			System.out.println("exceed the max");
		}
		n++;
		count--;
		StdDraw.point(n, count);
	}
	
	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		VisualCounter visualCounter = new VisualCounter(20, 5);
		for (int i = 0; i < 10; i++) {
			visualCounter.increment();
		}
		for (int i = 0; i < 15; i++) {
			visualCounter.decrement();
			
		}
		for (int i = 0; i < 10; i++) {
			visualCounter.increment();
		}
		System.out.println(visualCounter.getCount());
	}

}
