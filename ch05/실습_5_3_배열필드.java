package com.ruby.java.ch05;

public class 실습_5_3_배열필드 {
	static class Person {
		// 필드 (private)
		/*
		 * name은 String, age는 int, weight는 float로 필드들을 private 선언 subjects을 교육과목 private
		 * 배열 years을 수강 연도 private 배열 count 필드를 사용하여 수강 과목 증가시마다 ++count
		 */
		// 필드

		private String name;
		private int age;
		private float weight;
		private String[] subjects;
		private int[] years;
		private int count;

		public void setName(String name) {
			this.name = name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void setWeight(float weight) {
			this.weight = weight;
		}

		// 메소드
		void show() {
			// 기본 정보 출력::name=**, age=**, weight=**로 출력
			System.out.println("name=" + name + ", age=" + age + ", weihgt=" + weight);
			// 교육과목 및 수강 연도 출력
			/*
			 * while 문을 사용하여 교육과목과 수강연도를 출력
			 */
			int i = 0;
			while (i < count) {
				System.out.println("\t" + subjects[i] + ":" + years[i]);
				i++;
			}
		}

		void addSubjectYear(String subject, int year) { // 과목, 수강연도를 매개변수로 전달받아 배열에 추가
			// 현재 과목이 저장된 개수가 count에 저장되어 있으므로 현재 새로운 과목을 저장하려면
			// count보다 1이 크게 배열을 다시 생성해서 저장해야 한다.
			
			// 새로운 배열을 count+1 개 생성
			String[] nSubjects = new String[count+1];
			int[] nYears = new int[count+1];

			// count까지 원래 저장되어 있던 배열의 데이터를 새로운 배열에 저장
			for (int i = 0; i < count; i++) {
				nSubjects[i] = subjects[i];
				nYears[i] = years[i];
			}
			
			// 마지막에 새로 저장하려고 하는 과목을 마지막에 저장
			nSubjects[count] = subject ;
			nYears[count] = year ;
			
			// 새로 만든 배열의 참조변수 값을 원래 배열의 참조변수에 저장한다.
			subjects = nSubjects;
			years = nYears;

			++count;
		}
//		void addSubjectYear(String subject, int year) { // 과목, 수강연도를 매개변수로 전달받아 배열에 추가
//			if (subjects == null) {
//				subjects = new String[1];
//				years = new int[1];
//				subjects[count] = subject;
//				years[count] = year;
//			} else {
//				String[] nSubjects = new String[count+1];
//				int[] nYears = new int[count+1];
//				
//				for (int i = 0; i < count; i++) {
//					nSubjects[i] = subjects[i];
//					nYears[i] = years[i];
//				}
//				nSubjects[count] = subject ;
//				nYears[count] = year ;
//				
//				subjects = nSubjects;
//				years = nYears;
//			}
//			++count;
//		}
	}

	public static void main(String[] args) {
		// 첫 번째 객체 생성 및 초기화
		Person p1 = new Person();
		// 다음 코드를 setter, addSubjectYear를 사용하여 수정
		p1.setName("홍길동");
		p1.setAge(25);
		p1.setWeight(60.56f);
		p1.addSubjectYear("Mathematics", 2020);
		p1.addSubjectYear("Science", 2021);
		p1.addSubjectYear("History", 2022);

		// 메소드 호출
		p1.show();

		// 두 번째 객체 생성 및 초기화
		Person p2 = new Person();
		p2.setName("강감찬");
		p2.setAge(55);
		p2.setWeight(62.34f);
		p2.addSubjectYear("Literature", 2018);
		p2.addSubjectYear("Philosophy", 2019);
		p2.addSubjectYear("Physics", 2020);

		// 메소드 호출
		p2.show();
	}
}
