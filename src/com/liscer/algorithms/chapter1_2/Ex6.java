package com.liscer.algorithms.chapter1_2;

import edu.princeton.cs.algs4.StdIn;


public class Ex6 {
	/**
	 * 回环变位检测 写的很巧妙 string中的字符按从头到尾或者从尾到头按顺序移动为真
	 * 首先判断两个字符是否相等,然后让s字符concat自己,再用indexOf判断t是否在s
	 * 中出现
	 * @param args
	 */
	public static void main(String[] args) {
		String string1 = "hello";
		String string2 = string1;
		string1 = "world";
		System.out.println(string1);//world
		System.out.println(string2);//hello
		String s = "qwerty";
		String t = "yqwert";
		if (s.length() == t.length() && s.concat(s).indexOf(t) >= 0) {
			System.out.println(s + " is the circular rotation of " + t);
		} else {
			System.out.println(s + " is not the circular rotation of " + t);
		}
		
		System.out.println(mystery(StdIn.readLine()));

	}
	
	public static String mystery(String s) {
		int N = s.length();
		if (N <= 1) {
			return s;
		}
		String a = s.substring(0, N / 2);
		String b = s.substring(N / 2, N);
		return mystery(b) + mystery(a);
	}

}
