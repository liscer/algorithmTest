package com.liscer.algorithms.chapter1_1;

public class Ex30 {
	/**
	 * 一个二维Boolean数组,行列互质时数组值为true
	 * @param args
	 */
	public static void main(String[] args) {
		arrays(5);

	}
	/**
	 * 两个数是否互质,除了1意外是否还有其他因数,即判断最大公因数是否>1,大于1不互质
	 * @param N
	 * @return
	 */
	public static boolean[][] arrays(int N) {
		boolean[][] a = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j<N; j++) {
				a[i][j]= Euclid(i, j) ==1; 
				System.out.println(a[i][j] + "");
			}
			System.out.println();
		}
		return a;
	}
	
	public static int Euclid(int p,int q) {
		System.out.println("p = " + p + ", q = " + q);
		if (p == 0 || q == 0) {
			return 1;
		}
		if (p < q) {
			int t = p;
			p = q;
			q = t;
		}
		if (p % q == 0) {
			return q;
		} else {
			return Euclid(q, p % q);
		}
	}

}
