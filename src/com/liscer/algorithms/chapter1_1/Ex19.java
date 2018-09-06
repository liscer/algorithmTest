package com.liscer.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

public class Ex19 {
	/**
	 * 斐波那契额数列实现
	 * @param N
	 * @return
	 */
	public static long[] F(int N) {
		long[] fibonacci = new long[N + 1];
		if (N == 0) {
			return fibonacci;
		}
		fibonacci[1] = 1;
		if (N == 1) {
			return fibonacci;
		}
		for (int i = 2; i <= N; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		return fibonacci;
	}

	public static void main(String[] args) {
		long[] fibonacci = F(99);
		for (int N = 0; N < fibonacci.length; N++) {
			StdOut.println(N + " " + fibonacci[N]);
		}
	}
	
/*	public static long[] F1(int N) {
		long[] fibonacci = new long[N+1];
		if(N == 0){
			return fibonacci;
		}
		fibonacci[1] = 1;
		if(N==1){
			return fibonacci;
		}
		for (int i = 2; i < N; i++) {
			fibonacci[i] = fibonacci[i -1]+fibonacci[i-2];
		}
		return fibonacci;
	}*/
}
