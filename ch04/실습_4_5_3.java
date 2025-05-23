package com.ruby.java.ch04;

import java.util.Random;

public class 실습_4_5_3 {

	static Random rd = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] A = setMatrix(3, 5);
		printMatrix(A, "Matrix A");
		int[][] B = setMatrix(3, 5);
		printMatrix(B, "Matrix A");
	}

	private static int[][] setMatrix(int row, int col){
		int[][]	a = new int[row][col];
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				a[i][j]=rd.nextInt(11);
			}
		}
	return a;
	}
	private static void printMatrix(int [][]a, String msg) {
		System.out.println(msg);
		System.out.println("-".repeat(10));
		for (int i=0; i<a.length;i++) {
			for (int j=0; j<a[0].length;j++) {
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("=".repeat(20));
	} 
}