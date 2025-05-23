package com.ruby.java.ch05;

public class 실습_5_3_배열필드2 {
	static class Person {
	    // 필드 (private)
		/*
		 * name은 String, age는 int, weight는 float로 필드들을 private 선언
		 * subjects을 교육과목 private 배열
	     * years을 수강 연도 private 배열
	     * count 필드를 사용하여 수강 과목 증가시마다 ++count
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
	       System.out.println("기본 정보 출력::name=" + name + ", age=" + age + ", weight=" + weight);
	        // 교육과목 및 수강 연도 출력
	    	/*
	    	 * while 문을 사용하여 교육과목과 수강연도를 출력
	    	 */
	       int i = 0;
	       while(i < count) {
	    	   System.out.println("\t" + subjects[i] + ":" + years[i]);
	    	   i++;
	       }
	    }
	    
	    void addSubjectYear(String subject, int year) {
	    	if (subjects == null) {
	    		subjects = new String[1];
	    		years = new int[1];
	    		subjects[count] = subject;
	    		years[count] = year;
	    	} else {
	    		String[] nSubjects = new String[count+1];
	    		int[] nYears = new int[count+1];
	    		
	    		for(int i = 0 ; i < count ; i++) {
	    			nSubjects[i] = subjects[i];
	    			nYears[i] = years[i];
	    		}
	    		nSubjects[count] = subject;
	    		nYears[count] = year;

	    		subjects = nSubjects;
	    		years = nYears;
	    	}
    		++count;
	    }
	}

    public static void main(String[] args) {

        Person p1 = new Person();

        p1.setName("홍길동");
        p1.setAge(25);
        p1.setWeight(60.56f);
        p1.addSubjectYear("Mathematics", 2020);
        p1.addSubjectYear("Science", 2021);
        p1.addSubjectYear("History", 2022);

        p1.show();
        
        Person p2 = new Person();
        p2.setName("강감찬");
        p2.setAge(55);
        p2.setWeight(62.34f);
        p2.addSubjectYear("Literature", 2018);
        p2.addSubjectYear("Philosophy", 2019);
        p2.addSubjectYear("Physics", 2020);
        
        p2.show();
    }
}