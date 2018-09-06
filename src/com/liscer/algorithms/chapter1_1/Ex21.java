package com.liscer.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex21 {

	public static void main(String[] args) {
//		System.out.print("Please input count:");
//		int n = StdIn.readInt();
//		String[] nameArray = new String[n];
//		int[] integerArray1 = new int[n];
//		int[] integerArray2 = new int[n];
//		for (int i = 0; i < n; i++) {
//			nameArray[i] = StdIn.readString();
//			integerArray1[i] = StdIn.readInt();
//			integerArray2[i] = StdIn.readInt();
//		}
//		System.out.println("庚----房----房----房------庖");
//		for (int i = 0; i < n; i++) {
//			System.out.printf("|%4s|%4d|%4d|%6.3f|\n", nameArray[i], integerArray1[i], integerArray2[i],
//					(float) integerArray1[i] / integerArray2[i]);
//			if (i != n - 1) {
//				System.out.println("念----拈----拈----拈------怕");
//			}
//		}
//		System.out.println("弩----拂----拂----拂------彼");
		System.out.println("输入录入信息条数");
		int n = StdIn.readInt();
		String[] nameArray = new String[n];
		int[] intArray1 = new int[n];
		int[] intArray2 = new int[n];
		for (int i = 0; i < n; i++) {
			nameArray[i] = StdIn.readString();
			intArray1[i]= StdIn.readInt();
			intArray2[i]= StdIn.readInt(); 
		}
		System.out.println("===========head=====================");
		for (int i = 0; i < n; i++) {
			System.out.printf("|%4s|%4d|%4d|%6.3f|\n", nameArray[i],intArray1[i],
					intArray2[i],(float)intArray1[i]/intArray2[i]);
			if (i!=n-1) {
				System.out.println("===============body===============");
			}
		}
		System.out.println("==============last===================");
	}

}
