package com.ruby.java.ch04_1;

import java.util.Random;

public class Test38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];
		Random rnd = new Random();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = rnd.nextInt(100);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
				System.out.print("\t");
			}
			System.out.println();
		}

	// 2차원 배열에서 확장형 for 문 사용
	for (int [] row : arr) { // int[] row는 각 행을 나타냄
		for (int f : row) { // row변수가 각 행이므로 1차원 배열
			System.out.print(f+ " ");
		}
		System.out.println();
	}
}
}
