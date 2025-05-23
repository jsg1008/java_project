package com.ruby.java.ch04;

import java.util.Random;

public class 실습_4_4_배열생성최대값 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 난수 배열 최대, 최소, 평균 구하기
		int []arr = new int [10];
		Random rd = new Random();

		int max = 0 ;
		int min = 999 ;
		int sum = 0 ;
		System.out.print("[");
		for ( int i = 0; i < 10 ; i++) {
			arr[i] = rd.nextInt(100);	
			if (i == 9) {
				System.out.print(arr[i]+"");
			} else if (i < 9) {
				System.out.print(arr[i]+", ");
			}						
			if (max < arr[i]) max = arr[i] ;
			if (min > arr[i]) min = arr[i] ;
			sum += arr[i] ;	
		}
		System.out.print("]");
		System.out.println("");
		System.out.println("최댓값 = "+max);
		System.out.println("최솟값 = "+min);
		System.out.println("평균값 = "+sum/arr.length);
	}
}
