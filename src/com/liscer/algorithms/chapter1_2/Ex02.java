package com.liscer.algorithms.chapter1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;

public class Ex02 {
	/**
	 * 间隔,就是一个线段从min到max
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * int N = 3; Interval1D[] intervals = new Interval1D[N]; for (int i =
		 * 0; i < N; i++) { intervals[i] = new Interval1D(StdIn.readDouble(),
		 * StdIn.readDouble()); } if (N > 2) { for (int i = 0; i < N - 1; i++) {
		 * for (int j = i + 1; j < N; j++) { if
		 * (intervals[i].intersects(intervals[j])) {
		 * System.out.println(intervals[i] + " intersects " + intervals[j]); } }
		 * } }
		 */
		int N = 3;
		Interval1D[] interval1ds = new Interval1D[N];
		for (int i = 0; i < interval1ds.length; i++) {
			interval1ds[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
		}
		if (N > 2) {
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1 ;j < N; j++) {
					if (interval1ds[i].intersects(interval1ds[j])) {
						System.out.println(interval1ds[i]+"intersects"+interval1ds[j]);
					}
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
