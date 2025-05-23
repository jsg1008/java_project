package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.HashMap;

class Item {
	String name;
	Integer pid;

	public Item(String name, Integer pid) {
		this.name = name;
		this.pid = pid;
	}

	public String toString() {
		return name + " : " + pid;
	}
}

class ItemA extends Item {

	String size;

	ItemA(String name, Integer pid, String size) {
		super(name, pid);
		this.size = size;
	}

	public String toString() {
		return super.toString() + " : " + size;
	}
}

class ItemB extends Item {

	String color;

	ItemB(String name, Integer pid, String color) {
		super(name, pid);
		this.color = color;
	}

	public String toSting() {
		return super.toString() + " : " + color;
	}
}

public class Test1 {
	public static void main(String[] args) {
		ArrayList<Item> list = new ArrayList<>();
//		ItemA item1 = new ItemA("Name", 100, "XXL");
//		ItemB item2 = new ItemB("Name", 900, "XXL");

		list.add(new ItemA("Name", 100, "XXL"));
		list.add(new ItemB("Name", 100, "RED"));

		for (Item item : list) {
			System.out.println(item);
		}
		System.out.println("=".repeat(20));

		HashMap<Integer, Item> map = new HashMap<>();
		map.put(1, new ItemA("Name", 100, "XXL"));
		map.put(2, new ItemA("Name", 100, "RED"));

		System.out.println(map.get(1));
		System.out.println(map.get(2));
	}
}
