package com.ruby.java.ch11;

import java.util.ArrayList;
import java.util.Arrays;

//Book 클래스
class Book implements Comparable<Book>{
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
	public int compareTo(Book b) { //추상 메소를 구현-
		return title.compareTo(b.title); // a.compareTo( b)형태
	}

	@Override
	public String toString() {
	    return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s",
	            title, author, publicationYear, isbn);
	}


}

class Library {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<Book> books;


	// 책 추가 (용량 초과 시 OverflowException 발생)
	public void addBook(Book book) {

	}

	// 책 삭제 (빈 목록에서 삭제 시 UnderflowException 발생)
	public Book removeBook() {

	}

	public void printBooks(String msg) {

	}

	public void sortBooksByTitle() {
		
	}

	public void sortBooksByISBN() {
		
	}

	public Book searchBookByTitle(String title) {

	}
}
public class Test07 {
	public static void main(String[] args) {

		Library library = new Library();

		// 5개의 Book 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("C#", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);

		// 도서 목록 출력
		library.printBooks("\n현재 도서 목록:");

		library.sortBooksByTitle(); // 도서 목록 정렬
		// 최종 도서 목록 출력
		library.printBooks("\n\n정렬후 최종 도서 목록:");
		// 특정 제목으로 도서 검색
		String searchTitle = "자바";
		// 정렬된 도서 목록 출력
		Book foundBook = library.searchBookByTitle(searchTitle);

		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		// 도서 목록 출력
		library.printBooks("\n\n현재 도서 목록:");
	}
}