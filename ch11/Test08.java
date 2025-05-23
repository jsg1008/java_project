package com.ruby.java.ch11;

import java.util.ArrayList;
import java.util.Collections;

//Overflow 예외 클래스
class OverflowException extends RuntimeException { // 교재 553
    public OverflowException(String message) {
        super(message);
    }
}

//Underflow 예외 클래스
class UnderflowException extends RuntimeException {
    public UnderflowException(String message) {
        super(message);
    }
}

//Book 클래스
class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;

    public Book(String title, String author, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }
    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s", title, author, publicationYear, isbn);
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title); // 제목으로 비교
    }
}

class Library {
    static final int CAPACITY = 5; // 기본 용량을 5로 설정
    private ArrayList<Book> books;
    private int top;

    public Library() {
        this.books = new ArrayList<>(CAPACITY);
        this.top = 0;
    }

    // 책 추가 (용량 초과 시 OverflowException 발생)
    public void addBook(Book book) {
        if (top >= CAPACITY) {
            throw new OverflowException("도서관의 용량을 초과했습니다.");
        }
        books.add(book);
        top++;
    }

    // 책 삭제 (빈 목록에서 삭제 시 UnderflowException 발생)
    public Book removeBook() {
        if (top <= 0) {
            throw new UnderflowException("도서관에 책이 없습니다.");
        }
        Book removedBook = books.remove(top - 1);
        top--;
        return removedBook;
    }

    public void printBooks(String msg) {
        System.out.println(msg);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void sortBooksByTitle() {
        Collections.sort(books); // 제목으로 정렬
    }

    public void sortBooksByISBN() {
        books.sort((b1, b2) -> b1.getIsbn().compareTo(b2.getIsbn())); // ISBN으로 정렬
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}

public class Test06 {
    public static void main(String[] args) {
        try {
            String s = new String("java");
            System.out.println(s.length());
            s = null;
            System.out.println(s.length());
            int[] arr = new int[2];
            arr[2] = 10;
        } catch (ArrayIndexOutOfBoundsException e1) { // 교재534
            System.out.println("***배열 색인 예외 발생");
            System.out.println(e1.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("***널 포인터 예외 발생");
            e2.printStackTrace();
        } catch (Exception e) {
            System.out.println("***예외 발생");
        } finally {
            System.out.println("***모든 것이 ok\n\n"); // 교재 543
            // 할당된 자원을 자동으로 해제가 아니고 close(file)을 포함해야 한다
        }

        Library library = new Library();

        // 5개의 Book 객체 초기화
        Book book1 = new Book("자바", "강감찬", 1995, "12");
        Book book2 = new Book("파이썬", "이순신", 2008, "9");
        Book book3 = new Book("C#", "을지문덕", 2008, "8");
        Book book4 = new Book("자료구조", "연개소문", 1994, "45");
        Book book5 = new Book("리액트", "김춘추", 1999, "7");
        Book book6 = new Book("스프링", "홍길동", 2025, "99");

        // 예외 처리를 적용한 책 추가 및 삭제
        try {
            // 도서관의 용량을 초과하여 책을 추가 (예외 발생)
            library.addBook(book1);
            library.addBook(book2);
            library.addBook(book3);
            library.addBook(book4);
            library.addBook(book5);
            library.addBook(book6); // 이 줄에서 OverflowException 발생
        } catch (OverflowException e) {
            System.out.println(e.getMessage());
        }

        // 도서 목록 출력
        library.printBooks("\n\n현재 도서 목록:");

        try {
            // 빈 도서관에서 책을 삭제 (예외 발생)
            library.removeBook(); // 책이 없을 경우 UnderflowException 발생
            library.removeBook(); // 책이 없을 경우 UnderflowException 발생
        } catch (UnderflowException e) {
            System.out.println(e.getMessage());
        }

        // 최종 도서 목록 출력
        library.printBooks("\n최종 도서 목록:");
    }
}
