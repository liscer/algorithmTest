package com.liscer.algorithms.chapter1_1;

public class Ex15 {
	/**
	 * 通过数组表现柱状图,参数数组的值决定了第几个返回数组的值加一
	 * @param a int型数组
	 * @param N 参数的数组的值小于N
	 * @return
	 */
	public static int[] histogram(int[] a,int N) {
		int []b = new int[N];
		for (int i = 0; i < a.length; i++) {
			if(a[i] >= 0 && a[i] < N-1){
				b[a[i]]++;
			}
		}
		return b;
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 3, 1, 7, 5, 3, 2, 2, 2 };
		int[] result = histogram(a, 8);
		for (int i = 0; i < result.length; i++) {
			System.out.printf("%3d", result[i]);
		}
	}

// 自己写的复杂写法低级
//	public static void main(String[] args) {
//		int a1[] = {1,2,3,4,1,2,5,4,1};
//		int b2[] = histogram(a1, 6);
//		int c = 0;
//		for (int i = 0; i < b2.length; i++) {
//			System.out.println(b2[i]);
//			c +=b2[i];
//		}
//		System.out.println(c);
//
//	}
//	
//	public static int[] histogram(int a[],int M) {
//		int []b = new int[M];
//		int temp = 0;
//		for (int i = 0; i < b.length; i++) {
//			for (int j = 0; j < a.length; j++) {
//				if(i == a[j]){
//					temp ++;
//				}
//			}
//			b[i] = temp;
//			temp =0;
//		}
//		return b;
//		
//	}

}
