package com.ruby.java.test;

import java.util.Scanner;

public class MinBillCount {
	public static void main(String[] args) {
		// 상품가격을 입력 받는다 167,000원(스캐너 이용)
		// 5만원, 1만원, 5천원, 1천원 장수(지폐 장수 구하기)
		// 나누었을때 
		// 천원 미만은 할인하고 임의의 금액을 지불하기 위해 필요한 지폐 장수 구하기
		Scanner scanner = new Scanner(System.in);
		System.out.println("총액:");
		int bill = scanner.nextInt();
		//5만원권 몇장 필요한지 확인
		// 총액에서 5만원권 제하기
		int a = bill/50000;
		bill %= 50000 ;
//		bill -= a+50000;
		int b = bill/10000;
		bill %= 10000;
		int c = bill/5000;
		bill %= 50000;
		int d = bill/1000;
		bill %= 1000;
		
		System.out.println("5만원권은 " + a + "장");
		System.out.println("1만원권은 " + b + "장");
		System.out.println("5천원권은 " + c + "장");
		System.out.println("1천원권은 " + d + "장");
		
	}
}
