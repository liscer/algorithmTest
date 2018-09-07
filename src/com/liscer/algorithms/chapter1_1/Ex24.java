package com.liscer.algorithms.chapter1_1;

public class Ex24 {

	public static void main(String[] args) {
		System.out.println("result: " + Euclid(0, 24));
		//System.out.println("result: " + Euclid(1111111, 1234567));
		System.out.println("===" + gcd(0, 15));
	}
	/**
	 * 欧几里得算法辗转相除求最大公约数,如果p大于q交换数值,进行递归直到p%q==0,递归的时候q是第一参数,p%q为第二参数
	 * @param p
	 * @param q
	 * @return
	 */
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
	
	public static int gcd(int p,int q) {
//		if(q == 0) return p;
//		int r = p %q;
//		return gcd(q, r);
		if(p %q == 0){
			return q;
		}else {
			return gcd(q, p%q);
		}
	}
	//自己练习
	public static int Euclid1(int p,int q) {
		System.out.println("p" + p +"q"+q);
		if (p == 0 || q ==0) {
			return 1;
		}
		if(p < q){
			int temp = p;
			p = q;
			q = temp;
		}
		if (p % q == 0) {
			return q;
		}else {
			return Euclid(q, p%q);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
