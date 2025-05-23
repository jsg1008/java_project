package com.ruby.java.ch02;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long totalSales;
		totalSales = 2147483648L;
		System.out.println(totalSales);

		float exchangeRate = (float) 1136.50;
		double USDAmount = 600.50;
		System.out.println(exchangeRate);
		System.out.println(USDAmount);

		String name = "Amy";
		String greet = "Hello, how are you! I am fine";
		System.out.println("greet의 길이 = " + greet.length());
		System.out.println("greet 변수 길 = " + greet.getBytes().length);

		int a = 10;
		int b, c;

		b = a++;
		c = ++a;

		System.out.println("a = " + a + ", b = " + b + ", c = " + c);

	}
}
