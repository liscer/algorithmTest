package com.liscer.algorithms.chapter1_2;

public class Ex07 {
	/**
	 * 字符串反转 三种方法
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverse3("qwerty"));
	}
	
	public static String reverse1(String s) {
		String back = "";
		for (int i = 0; i < s.length(); i++) {
			back = s.charAt(i)+back;
		}
		return back;
	}
	
	public static String reverse2(String s){
		char[] back = s.toCharArray();
		String reString = "";
		for (int i = back.length-1; i >=0; i--) {
			reString += back[i];
		}
		return reString;
	}
	
/*	public static String reverse3(String s) {
		int N = s.length();
		if (N <=1) {
			return s;
		}
		String a = s.substring(0, N/2);
		String b = s.substring(N/2,s.length());
		return reverse3(b)+ reverse3(a);
	}*/
	
	public static String reverse3(String s) {
		int N = s.length();
		if (N <= 1) {
			return s;
		}
		String left = s.substring(0, N/2);
		String right = s.substring(N/2, N);
		return reverse3(right)+ reverse3(left);
	}
}
