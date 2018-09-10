package com.liscer.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdRandom;

public class Ex36 {
	/**
	 * 乱序检查 将一个int数组[5],打乱M次,每次打乱可能出现在同一位置,有可能有点位置一次都没出现
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * int M = 5, N = 10; int[] a = new int[M]; int[][] num = new int[M][M];
		 * for (int i = 0; i < N; i++) { for (int j = 0; j < M; j++) { a[j] = j;
		 * } StdRandom.shuffle(a); for (int j = 0; j < M; j++) { num[a[j]][j]++;
		 * } } for (int i = 0; i < M; i++) { for (int j = 0; j < M; j++) {
		 * System.out.print(num[i][j] + " "); } System.out.println(); }
		 */

		/*
		 * int M = 5, N = 10; int[][] num = new int[M][M]; int[] a = new int[M];
		 * for (int i = 0; i < N; i++) { for (int j = 0; j < M; j++) { a[j] = j;
		 * } StdRandom.shuffle(a); for (int j = 0; j < a.length; j++) {
		 * num[a[j]][j]++; } } for (int i = 0; i < M; i++) { for (int j = 0; j <
		 * M; j++) { System.out.print(num[i][j] + " "); } System.out.println();
		 * }
		 */
		int M = 5,N = 10;
		int[]a = new int[M];
		int[][] num = new int[M][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[j] = j;
			}
			StdRandom.shuffle(a);//以一定概率打乱数组元素顺序
			for (int j = 0; j < M; j++) {
				num[a[j]][j]++;//二维数组的意思是第i行 i在数组j列出现的次数
							   //eg 第0行,元素0在数组第0列出现几次,在第1列出现几次...
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(num[i][j]+" ");
				
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
