package com.ruby.java.test;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // 단축키 컨트롤+쉬프트+오
		System.out.println("num:"); // 외울것
		int num = scanner.nextInt(); // 외울것

		// 짝수 합 저장할 변수 선언
		int a = 0;
		// 홀수 합 저장할 변수 선언
		int b = 0;
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0)
				a += i;
			else
				b += i;
			System.out.println("짝수는 = " + a);
			System.out.println("홀수는 = " + b);
			System.out.println("전체의 합은 = " + a+ b);

		}
	}
}
