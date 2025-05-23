package com.ruby.java.ch04;

public class 실습_4_1_변수들사용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s1=49 ;
		int s2=91 ;
		int s3=87 ;
		int s4=67 ;
		int s5=73 ;
		int sum=0 ;
		sum=s1+s2+s3+s4+s5 ;
		System.out.println((sum)/5);
		
		int max = s1;
		if (max < s2) max = s2;
		if (max < s3) max = s3;
		if (max < s4) max = s4;
		if (max < s5) max = s5;
		System.out.println(max);
		
		int min = s1;
		if (min > s2) min = s2;
		if (min > s3) min = s3;
		if (min > s4) min = s4;
		if (min > s5) min = s5;
		System.out.println(min);
		
	}

}
