package com.liscer.algorithms.chapter1_1;

import java.util.Stack;

public class Ex09 {

	public static void main(String[] args) {
		//System.out.println(toBinaryString(6));
		int N = 6;
		Stack<Integer> stack = new Stack<>();
		while (N >0){
			stack.push(N%2);
			N /=2;
		}
		for (Integer integer : stack) {
			System.out.println(integer + " ");
		}

	}
	
	/**
	 * 十进制转换二进制1.1.9 for和while都行
	 * @param N 整形 大于0
	 * @return 字符串
	 */
	public static String toBinaryString(int N) {
		String s = "";
//		for (int i = N; i > 0 ; i /= 2) {
//			s = (i %2) + s;
//		}
//		return s;
		while(N >0){
			s = (N%2) + s;
			N /= 2;
		}
		return s;
	}
	
	public static String toBinaryString1(int N){
		Stack<Integer> stack = new Stack<>();
		while (N >0){
			stack.push(N%2);
			N /=2;
		}
		for (Integer integer : stack) {
			
		}
		return stack.toString();
	}

}
