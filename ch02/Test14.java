package com.ruby.java.ch02;

public class Test14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'A';
		int nc = c;
		System.out.println("nc = " + nc);
		System.out.println(nc);
		c ^= (1<<5);
		System.out.println(c);
		int h = 1 ;
		int g = h<<2 ;
		System.out.println(g);
	}

}
