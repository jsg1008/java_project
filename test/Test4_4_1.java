package com.ruby.java.test;

public class Test4_4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = { 49, 91, 87, 67, 73 };
		System.out.print("[");
		for (int k=0; k<score.length; k++) {
		if (k<score.length) {
			 System.out.print(score[k]+ ", ");
		} else {
			 System.out.print(score[k]);
		}
		System.out.print("]");
		System.out.println();
		
		int sum = 0;
		int min = 100;
		int max = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
			if (min > score[i]) {
				min = score[i];
			}
			if (max < score[i]) {
				max = score[i];
			}
		}
		System.out.println("합계는 = " + sum + "점");
		System.out.println("최소값 = " + min + "점");
		System.out.println("최대값 = " + max + "점");
		System.out.println("평균값 = " + sum / score.length + "점");
	}
	}
}
