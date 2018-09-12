package com.liscer.algorithms.chapter1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex03 {
	/**
	 * 随机N个矩形在指定min和max中,打印有几个矩形相交intersects,有几个矩形完全包涵contains
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * int N = 5; double min = 0.1; double max = 0.5; StdDraw.setXscale(min,
		 * max); StdDraw.setYscale(min, max); Point2D[] leftTopPoints = new
		 * Point2D[N]; Point2D[] rightBottomPoints = new Point2D[N];
		 * Interval2D[] intervals = new Interval2D[N]; for (int i = 0; i < N;
		 * i++) { double a = StdRandom.uniform(min, max); double b =
		 * StdRandom.uniform(min, max); double left, right, top, bottom;
		 * Interval1D x, y; if (a < b) { left = a; right = b; } else { left = b;
		 * right = a; } x = new Interval1D(left, right); a =
		 * StdRandom.uniform(min, max); b = StdRandom.uniform(min, max); if (a <
		 * b) { top = a; bottom = b; } else { top = b; bottom = a; } y = new
		 * Interval1D(top, bottom); leftTopPoints[i] = new Point2D(left, top);
		 * rightBottomPoints[i] = new Point2D(right, bottom); intervals[i] = new
		 * Interval2D(x, y); intervals[i].draw(); } int containNum = 0,
		 * intervalNum = 0; for (int i = 0; i < N - 1; i++) { for (int j = 0; j
		 * < N; j++) { if (j > i && intervals[i].intersects(intervals[j])) {
		 * intervalNum++; } if (j != i &&
		 * intervals[i].contains(leftTopPoints[j]) &&
		 * intervals[i].contains(rightBottomPoints[j])) { containNum++; } } }
		 * System.out.println("Interval count: " + intervalNum);
		 * System.out.println("Contain count: " + containNum);
		 */

		/*
		 * int N = 5; double min=0.1,max=0.5; StdDraw.setXscale(min, max);
		 * StdDraw.setYscale(min, max); Interval2D[] interval2ds = new
		 * Interval2D[N]; Point2D[] lefttopPoints = new Point2D[N]; Point2D[]
		 * rightbottomPoints = new Point2D[N]; for (int i = 0; i < N; i++) {
		 * double a = StdRandom.uniform(min, max); double b =
		 * StdRandom.uniform(min,max); double left,right,top,bottom; Interval1D
		 * x,y; if (a< b) { left = a; right = b; }else { left = b; right = a; }
		 * x = new Interval1D(left, right); a = StdRandom.uniform(min,max); b =
		 * StdRandom.uniform(min,max); if (a < b) { top =a; bottom = b; }else {
		 * top = b; bottom = a; } y = new Interval1D(top, bottom);
		 * lefttopPoints[i] = new Point2D(left, top); rightbottomPoints[i] = new
		 * Point2D(right, bottom); interval2ds[i]=new Interval2D(x, y);
		 * interval2ds[i].draw(); } int intersects=0,contains=0; for (int i = 0;
		 * i < N-1; i++) { for (int j = 0; j < N; j++) { if (j>
		 * 1&&interval2ds[i].intersects(interval2ds[j])) { intersects++; } if (j
		 * != 1 && interval2ds[i].contains(lefttopPoints[j]) &&
		 * interval2ds[i].contains(rightbottomPoints[j])){ contains++; } }
		 * 
		 * } System.out.println("intersects" + intersects);
		 * System.out.println("contains" + contains);
		 */
//		int N = 5;
//		double min = 0.1,max = 0.5;
//		StdDraw.setXscale(min, max);
//		StdDraw.setYscale(min, max);
//		
//		Interval2D[] interval2ds = new Interval2D[N];
//		Point2D[] lefttopPoints = new Point2D[N];
//		Point2D[] rightbottomPoints = new Point2D[N];
//		for (int i = 0; i < interval2ds.length; i++) {
//			double a,b,left,right,top,bottom;
//			a = StdRandom.uniform(min, max);
//			b = StdRandom.uniform(min,max);
//			Interval1D x,y;
//			if (a < b) {
//				left =a;
//				right = b;
//			}else {
//				right = a;
//				left = b;
//			}
//			x = new Interval1D(left, right);
//			a = StdRandom.uniform(min,max);
//			b = StdRandom.uniform(min,max);
//			if (a<b) {
//				top = a;
//				bottom = b;
//			}else {
//				bottom = a;
//				top = b;
//			}
//			y = new Interval1D(top, bottom);
//			lefttopPoints[i] = new Point2D(left, top);
//			rightbottomPoints[i] = new Point2D(right, bottom);
//			System.out.println(left+" "+top+" "+right+" "+bottom);
//			interval2ds[i] =new Interval2D(x, y);
//			interval2ds[i].draw();
//		}
//		int intersects=0;
//		int contains=0;
//		for (int i = 0; i < N-1; i++) {
//			for (int j = 0; j <N; j++) {
//				if (j >i&&interval2ds[i].intersects(interval2ds[j])) {
//					intersects++;
//				}
//				if (j != i&&interval2ds[i].contains(lefttopPoints[j])&&interval2ds[i].contains(rightbottomPoints[j])) {
//					contains++;
//				}
//			}
//		}
//		System.out.println("intersects" + intersects);
//		System.out.println("contains"+contains);
//		
		int N = 5;
		double min = 0.1;
		double max = 1.0;
		StdDraw.setXscale(min, max);
		StdDraw.setYscale(min, max);
		Point2D[] leftTopPoints = new Point2D[N];
		Point2D[] rightBottomPoints = new Point2D[N];
		Interval2D[] intervals = new Interval2D[N];
		for (int i = 0; i < N; i++) {
			double a = StdRandom.uniform(min, max);
			double b = StdRandom.uniform(min, max);
			double left, right, top, bottom;
			Interval1D x, y;
			if (a < b) {
				left = a;
				right = b;
			} else {
				left = b;
				right = a;
			}
			x = new Interval1D(left, right);
			a = StdRandom.uniform(min, max);
			b = StdRandom.uniform(min, max);
			if (a < b) {
				top = a;
				bottom = b;
			} else {
				top = b;
				bottom = a;
			}
			y = new Interval1D(top, bottom);
			leftTopPoints[i] = new Point2D(left, top);
			rightBottomPoints[i] = new Point2D(right, bottom);
			intervals[i] = new Interval2D(x, y);
			intervals[i].draw();
		}
		int containNum = 0, intervalNum = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N; j++) {
				if (j > i && intervals[i].intersects(intervals[j])) {
					intervalNum++;
				}
				if (j != i && intervals[i].contains(leftTopPoints[j]) && intervals[i].contains(rightBottomPoints[j])) {
					containNum++;
				}
			}
		}
		System.out.println("Interval count: " + intervalNum);
		System.out.println("Contain count: " + containNum);
	}

}
