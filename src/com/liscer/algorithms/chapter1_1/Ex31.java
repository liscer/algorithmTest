package com.liscer.algorithms.chapter1_1;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex31 {
	
	static class Point {
		double x;
		double y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	/**
	 * 随机连接 创建一个圆,并指定圆上有N个点,有p概率连接这些点
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 5;//Integer.parseInt(args[0]);
		double p = 0.35;//Double.parseDouble(args[1]);
		if (p < 0 || p > 1) {
			System.out.println("p is not valid!");
			return;
		}
		Point[] points = new Point[N];
		double angle = 360.0 / N;//每个点的角度
		StdDraw.circle(0.5, 0.5, 0.5);//画一个x =0.5,y = 0.5的圆,半径为0.5
		StdDraw.setPenRadius(0.05);//画笔的粗细
		for (int i = 0; i < N; i++) {//点的位置
			points[i] = new Point(0.5 + 0.5 * Math.cos(angle * i * Math.PI / 180),
					0.5 + 0.5 * Math.sin(angle * i * Math.PI / 180));
			StdDraw.point(points[i].x, points[i].y);
		}
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(Color.GRAY);
		for (int i = 0; i < N - 1; i++) {//连线
			for (int j = i + 1; j < N; j++) {
				if (StdRandom.bernoulli(p)) {
					StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
				}
			}
		}
		/*
		 * 自己练习
		 */
		/*int N = 20;
		double p = 0.15;
		Point[] points = new Point[N];
		if (p <0 || p >1) {
			System.out.println("请输入0到 1的数");
		}
		StdDraw.circle(0.5, 0.5, 0.5);
		StdDraw.setPenRadius(0.05);
		double angle = 360.0 / N;
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point(0.5 + 0.5 * Math.cos(angle * i * Math.PI/180), 
					0.5 + 0.5 *Math.sin(angle * i * Math.PI/180));
			StdDraw.point(points[i].x, points[i].y);
		}
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(Color.RED);
		for (int i = 0; i < points.length -1; i++) {
			for (int j = 0; j < points.length; j++) {
				if (StdRandom.bernoulli(p)) {
					StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
				}
			}
			
		}*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
