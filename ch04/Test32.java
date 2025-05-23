package com.ruby.java.ch04;

public class Test32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		System.out.print("[");
		for (int i = 0; i < 10; i++) {
			arr[i] = 3 + (i + 1 - 1) * 2;
			if (arr[i] == 21) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
		System.out.print("]");
	}
}