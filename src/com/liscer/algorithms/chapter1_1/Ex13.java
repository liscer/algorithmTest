package com.liscer.algorithms.chapter1_1;

public class Ex13 {

	public static void main(String[] args) {
		int[][] a = { { 100, 200, 300 }, { 400, 500, 600 } };
		ArrayTransposed(a);

	}
	/**
	 * 三位数整型二维数组转置
	 * 思路 接受一个二维数组,主要是打印他,第一个for是行,是输入数组的列数inArray[0].length,
	 * 第二个for为列,是输入数组的行数inArray.length.这样输出不会越界,不会改变数组的值,就是先列后行
	 * @param mic 二维数组整型
	 */
	public static void ArrayTransposed(int [][]mic) {
		for (int i = 0; i < mic[0].length; i++) {
			for (int j = 0; j < mic.length; j++) {
				System.out.printf("%4d",mic[j][i]);
			}
			System.out.println();
		}
	}

}
