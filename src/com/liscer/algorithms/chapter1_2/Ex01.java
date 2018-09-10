package com.liscer.algorithms.chapter1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdIn;

public class Ex01 {
	/**
	 * N个点中距离最短的线段
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * int N = StdIn.readInt(); Point2D[] points = new Point2D[N]; for (int
		 * i = 0; i < N; i++) { points[i]=new Point2D(Math.random(),
		 * Math.random()); points[i].draw(); } if (N >1) { double min =
		 * points[0].distanceTo(points[1]); for (int i = 0; i < N-1; i++) { for
		 * (int j = i+1; j < N; j++) { if (points[i].distanceTo(points[j])<min)
		 * { min= points[i].distanceTo(points[j]); } } }
		 * System.out.println("最小距离"+min); }
		 */
		int N = StdIn.readInt();
		Point2D[] points = new Point2D[N];
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point2D(Math.random(), Math.random());
			points[i].draw();
		}
		if (N >1) {
			double min = points[0].distanceTo(points[1]);
			for (int i = 0; i < N -1; i++) {
				for (int j = i+1; j < N; j++) {
					if (points[i].distanceTo(points[j])<min) {
						min = points[i].distanceTo(points[j]);
					}
				}
			}
			System.out.println("min" + min);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
