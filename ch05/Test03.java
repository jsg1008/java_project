package com.ruby.java.ch05;

public class Test03 {

	public static void main(String[] args) {
		System.out.println(addNumber(1));
		System.out.println(addNumber(1, 2));
		System.out.println(addNumber(1, 2, 3));
		System.out.println(addNumber(1, 2, 3, 4));
		System.out.println(addNumber(1, 2, 3, 4, 5));
	}

	private static int addNumber(int...v) {
		System.out.print(v.length + " : ");
		int sum = 0 ;
		
		for (int x : v) {
			sum += x;
			System.out.print(x + " ");
		}
		System.out.print(" ==> ");
		return sum;
		}

//	public static void main(String[] args) {
//		System.out.println("합:" + addNumber(1, 2));
//	}
//	private static int addNumber(int x, int y) {
//		return sum ;
}
