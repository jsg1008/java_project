package com.ruby.java.ch04;

import java.util.Random;

public class 실습_4_5_행렬연산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = new int[3][5];
		int[][] B = new int[3][5];
		int[][] C = new int[3][5];
		int[][] D = new int[5][4];
		int[][] E = new int[3][4];
		int[][] F = new int[4][5];
		int[][] G = new int[3][4];

		Random rd = new Random();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				A[i][j] = rd.nextInt(100);
				System.out.print(A[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				B[i][j] = rd.nextInt(100);
				System.out.print(B[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.println("");
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[i].length; j++) {
				C[i][j] = A[i][j] + B[i][j];
				System.out.print(C[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				D[i][j] = rd.nextInt(100);
				System.out.print(D[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < D[0].length; j++) {
				for (int k = 0; k < A[0].length; k++) {
					E[i][j] += A[i][k] * D[k][j];
				}
				System.out.print(E[i][j] + "\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		for (int i = 0; i < F.length; i++) {
			for (int j = 0; j < F[i].length; j++) {
				F[i][j] = D[j][i];
				System.out.print(F[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
