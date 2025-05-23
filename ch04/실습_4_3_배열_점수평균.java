package com.ruby.java.ch04;

import java.util.Random;

public class 실습_4_3_배열_점수평균 {
	public static void main(String[] args) {
		int score[] = new int[10];
		Random rd = new Random();

		for (int i = 0; i < score.length; i++) {
			score[i] = rd.nextInt(100);
		}

		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " : ");
			if (score[i] >= 90)
				System.out.println("A");
			else if (score[i] >= 80)
				System.out.println("B");
			else if (score[i] >= 70)
				System.out.println("C");
			else if (score[i] >= 60)
				System.out.println("D");
			else if (score[i] < 60)
				System.out.println("F");

		}
	}
}
