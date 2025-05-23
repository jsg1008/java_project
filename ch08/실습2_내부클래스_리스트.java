package com.ruby.java.ch08;

public class 실습2_내부클래스_리스트 {
	private Node head;

	public 실습2_내부클래스_리스트() {
		head = null;
	}

	public class Node {
		private String data;
		private Node link;

		public Node(String data) {
			this.data = data;
		}
	}

	public void add(String data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node next = head;
			while (next.link != null) {
				next = next.link;
			}
			next.link = newNode;
		}
	}

	public void printList() {
		// printList() 결과는 A -> B -> C 등으로 출력한다
		if (head == null) {
			System.out.println("리스트가 없습니다." + "\n");
		} else {
			Node next = head;
			System.out.print("printList()결과는 ");
			while (next != null) {
				System.out.print(next.data);
				next = next.link;
				if (next != null) {
					System.out.print(" -> ");
				}
			}
			System.out.println();
		}
	}

	public void delete(String data) {
		if (head == null) return;
		Node next = head;
		Node pre = null;
		while (next.link != null) {

			if (data.equals(next.data)) {
				pre.link = next.link;
				break;
			}
			pre = next;
			pre = next.link;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		실습2_내부클래스_리스트 myList = new 실습2_내부클래스_리스트();
		myList.printList();

		myList.add("JAVA");
		myList.add("HTML");
		myList.add("CSS");
		myList.add("Javascript");
		myList.printList();
		myList.delete("CSS");
		myList.printList();
	}
}
