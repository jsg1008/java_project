package com.ruby.java.test;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("num1:");
		int num1 = scanner.nextInt(); 
		System.out.print("num2:");
		int num2 = scanner.nextInt(); 
		for (int i = num1 ; i <= num2 ; i++) {
			for (int j = 1 ; j < 10 ; j++) {
				System.out.println(i + "*" + j + "=" + (i * j));
			}
			System.out.println();
		}
	}
}
