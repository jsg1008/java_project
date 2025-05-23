package com.ruby.java.ch05;

class Box {
	// 필드 (속성)
	double width; // 가로
	double height; // 세로
	double depth; // 높이

	public Box(double width, double height, double depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	// 부피 계산 메소드
	double getVolume() {
		return width * height * depth;
	}

	// 둘레 길이 계산 메소드
	double getPerimeter() {
		return (width+height)*2.0 ;
	}

	// 박스 크기 조정 (메소드 오버로딩)
	void resize(double newWidth, double newHeight, double newDepth) {
		width=newWidth;
		height=newHeight;
		depth=newDepth;
		return ;
	}	
			// 박스의 가로,세로,높이를 변경
	
	void resize(double scale) {
		// 박스의 가로,세로,높이를 scale 비율로 변경
		width*=scale ; 
		height*=scale ;
		depth*=scale ;
		return;
	}

	void show() {
		System.out.println("width=" + width + ", height = " + height + ", depth = " + depth);
	}

	@Override
	public String toString() {
		return "width=" + width + ", height = " + height + ", depth = " + depth;
	}
}

public class 실습_5_2_상자클래스 {
	public static void main(String[] args) {
		// 박스 객체 생성
		Box box1 = new Box(10, 5, 3);

		// 박스 정보 출력
		box1.show();
		System.out.println("box1의 부피는 = " + box1.getVolume()+"\n");
		// 박스 크기 변경
		box1.resize(15, 8, 5);
		box1.show();
		System.out.println("box1의 둘레 길이는 = " + box1.getPerimeter()+"\n");
		// 박스를 2배 확대
		box1.resize(0.5);
		box1.show();

		Box box2 = new Box(4, 7, 3);
		System.out.println("box2의 부피는 = " + box2.getVolume()+"\n");
		box2.show();
		// 박스 크기 변경
		box2.resize(9, 3, 8);
		System.out.println("box2의 둘레 길이는 = " + box2.getPerimeter()+"\n");
		box2.show();

		// 박스를 2배 확대
		box2.resize(1.5);
		System.out.println("box2의 부피는 = " + box2.getVolume()+"\n");
		box2.show();
		System.out.println("box2의 둘레 길이는 = " + box2.getPerimeter()+"\n");

	}
}
