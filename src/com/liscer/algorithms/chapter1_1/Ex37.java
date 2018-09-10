package com.liscer.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdRandom;

public class Ex37 {
	
	public static void shuffle(int[]a) {
		int N = a.length;
		for (int i = 0; i < a.length; i++) {
			int r=StdRandom.uniform(N);
			int temp = a[i];
			a[i] =a[r];
			a[r] = temp;
		}
	}
	public static void main(String[] args) {
		int M = 5,N = 10;
		int[]a = new int[M];
		int[][] num = new int[M][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < num.length; j++) {
				a[j] = j;
			}
			shuffle(a);
			for (int j = 0; j < num.length; j++) {
				num[a[j]][j]++;
			}
		}
		for (int i = 0; i < num[0].length; i++) {
			for (int j = 0; j < num.length; j++) {
				System.out.print(num[i][j]+" " );
			}
			System.out.println();
		}

	}

}
