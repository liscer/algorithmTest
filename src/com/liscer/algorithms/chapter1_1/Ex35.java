package com.liscer.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Ex35 {
	/**
	 * 模拟投骰子
	 * @param args
	 */
	public static void main(String[] args) {
		/*int SIDES = 6;
		double[] dist = new double[2 * SIDES + 1];
		for (int i = 1; i <= SIDES; i++) {//2,3,4,5,6,7,8,9,10,11,12,出现次数
			for (int j = 1; j <= SIDES; j++) {
				dist[i + j] += 1.0;
			}
		}
		System.out.print("Probability:");
		for (int k = 2; k <= 2 * SIDES; k++) {
			dist[k] /= 36.0;
			System.out.printf("%6.3f", dist[k]);
		}
		System.out.println();
		int[] num = new int[2 * SIDES + 1];
		int N = StdIn.readInt();
		for (int i = 0; i < N; i++) {
			num[StdRandom.discrete(dist)]++;
		}
		double frequency;
		boolean isAccurate = true;
		System.out.print("Frequency:");
		for (int i = 2; i <= 2 * SIDES; i++) {
			frequency = (double) num[i] / N;
			System.out.printf("%6.3f", frequency);
			if (Math.abs(frequency - dist[i]) > 0.001) {
				isAccurate = false ;
			}
		}
		System.out.println();
		System.out.println("Is accurate? " + isAccurate);//100万次
*/ 
		/*int SIDES = 6;
		double[] disk = new double[SIDES *2 +1];
		for (int i = 1; i <= SIDES; i++) {
			for (int j = 1; j <= SIDES; j++) {
				disk[i+j] += 1.0;
			}
		}
		System.out.print("Probability");
		for (int i = 2; i <=SIDES *2 ; i++) {
			disk[i] /= 36.0;
			System.out.printf("%6.3f",disk[i]);
		}
		System.out.println();
		int N =StdIn.readInt();
		int[] num = new int[SIDES*2 + 1];
		for (int i = 0; i <= N; i++) {
			num[StdRandom.discrete(disk)]++;
			
		}
		double frequency;
		boolean isAccurate = true;
		System.out.print("Frequency");
		for (int i = 2; i <= SIDES*2; i++) {
			frequency = (double)num[i]/N;
			System.out.printf("%6.3f", frequency);
			if (Math.abs(frequency-disk[i]) > 0.001) {
				isAccurate = false;
			}
		}
		System.out.println();
		System.out.println("Is accurate? " + isAccurate);*/
		/*int SIDES = 6;
		double [] disk = new double[SIDES * 2 + 1];
		for (int i =1 ; i <= SIDES ; i++) {
			for (int j = 1; j <=SIDES; j++) {
				disk[i+j] += 1.0;	
			}
		}
		System.out.println("理论概率");
		for (int i = 2; i <= SIDES *2; i++) {
			disk[i] /= 36.0;
			System.out.printf("%6.3f",disk[i]);
		}
		System.out.println();
		System.out.print("实验");
		int N = StdIn.readInt();
		int[] num = new int[SIDES *2 +1];
		for (int i = 0; i < N ;i++) {
			num[StdRandom.discrete(disk)]++ ;
		}
		double temp;
		boolean isAccurate =true;
		for (int i = 2; i <= SIDES* 2 ; i++) {
			temp = (double)num[i]/N;
			System.out.printf("%6.3f",temp);
			if (Math.abs(temp-disk[i])> 0.001) {
				isAccurate = false;
			}
		}
		System.out.println();
		System.out.println("Accurate:" + isAccurate);*/
		/*int SIDES = 6;
		double[] disk= new double[SIDES* 6 +1];
		for (int i = 1; i <= SIDES; i++) {
			for (int j = 1; j <= SIDES; j++) {
				disk[i+j] += 1.0;
			}
		}
		System.out.println("理论数据");
		for (int i = 2; i <=SIDES*2; i++) {
			disk[i] /= 36.0;
			System.out.printf("%6.3f",disk[i]);
		}
		System.out.println();
		int N = StdIn.readInt();
		int [] sum = new int[SIDES*2+1];
		for (int i = 0; i < N; i++) {
			sum[StdRandom.discrete(disk)]++;
		}
		System.out.print("实验数据");
		double temp;
		boolean isAccurate = true;
		for (int i = 2; i <= SIDES*2; i++) {
			temp = (double)sum[i]/N;
			System.out.printf("%6.3f",temp);
			if (Math.abs(temp-disk[i])>0.001) {
				isAccurate = false;
			}
		}
		System.out.println();
		System.out.println("实验数据是否精确到了小数点后三位" + isAccurate);*/
		int SIDES = 6;
		double[] disk = new double[SIDES*2 +1];
		for (int i = 1; i <=SIDES; i++) {
			for (int j = 1; j <= SIDES; j++) {
				disk[i+j] += 1.0;
				
			}
		}
		System.out.print("理论数据");
		for (int i = 2; i <= SIDES*2; i++) {
			disk[i] /=36.0;
			System.out.printf("%6.3f",disk[i]);
			
		}
		System.out.println();
//============分界线上面是理论数据,下面是实验=======================
		int N = StdIn.readInt();//N 扔多少次骰子,100万次
		int[] num = new int[SIDES*2+1];
		for (int i = 0; i < N; i++) {
			num[StdRandom.discrete(disk)]++;//从指定的离散分布返回一个随机整数。
		}
		double temp;
		boolean isAcc = true;//是否吻合到三位小数
		System.out.print("实验数据");
		for (int i = 2; i <= SIDES*2; i++) {
			temp = (double)num[i]/N;
			System.out.printf("%6.3f",temp);
			if (Math.abs(temp-disk[i])>0.001) {
				isAcc =false;
			}
		}
		System.out.println();
		System.out.println("实验数据是否精确到了小数点后三位" + isAcc);
		
	} 

}
