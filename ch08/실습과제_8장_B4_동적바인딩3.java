package com.ruby.java.ch08;

// Item 추상 클래스
abstract class Item {
	private String name;
	private double price;
	private int stockQuantity;

	public Item(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void reduceStock(int quantity) {
		stockQuantity -= quantity;
	}

	public void show() {
		System.out.println("상품명: " + name + ", 가격: " + price + ", 재고: " + stockQuantity);
	}

	@Override
	public String toString() {
		return name + " (가격: " + price + ")";
	}
}

// Electronics 클래스
class Electronics extends Item {
	int madeYear;

	public Electronics(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear = madeYear;
	}

	@Override
	public void show() {
		super.show();
		System.out.println("제조날짜 : " + madeYear);
	}
}

// Clothing 클래스
//Clothing 클래스: Item 클래스 상속
class Clothing extends Item {
	int size;
	int madeYear;

	public Clothing(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}

	@Override
	public void show() {
		super.show();
		System.out.println("제조날짜 : " + madeYear);
		System.out.println("크기 : " + size);
	}
}


// Discountable 인터페이스
interface Discountable {
	double getDiscountedPrice(double price);
}

// SeasonalDiscount 클래스
class SeasonalDiscount implements Discountable {
	private double discountRate = 0.1; // 10% 기본 할인

	@Override
	public double getDiscountedPrice(double price) {
		return price * (1 - discountRate);
	}
}

// Customer 추상 클래스
abstract class Customer {
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	public abstract double applyDiscount(double totalAmount);

	public void show() {
		System.out.println("고객명: " + name);
	}
}

// RegularCustomer
class RegularCustomer extends Customer {
	static final double REGULARDISCOUNT_RATE = 0.03;

	public RegularCustomer(String name) {
		super(name);
	}

	@Override
	public double applyDiscount(double totalAmount) {
		return totalAmount * (1 - REGULARDISCOUNT_RATE);
	}
}

// PremiumCustomer
class PremiumCustomer extends Customer {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	public PremiumCustomer(String name) {
		super(name);
	}

	@Override
	public double applyDiscount(double totalAmount) {
		return totalAmount * (1 - PREMIUMDISCOUNT_RATE);
	}
}

// Order 클래스
class Order extends SeasonalDiscount {
	private final int N = 20;
	private Customer customer;
	private Item[] items;
	private int[] quantities;
	private String[] orderDates;
	private int count = 0;

	public Order(Customer customer) {
		this.customer = customer;
		items = new Item[N];
		quantities = new int[N];
		orderDates = new String[N];
	}

	public void addItem(Item item, int quantity, String date) {
		if (count < items.length) {
			items[count] = item;
			quantities[count] = quantity;
			orderDates[count] = date;
			count++;
			item.reduceStock(quantity);
		} else {
			System.out.println("더 이상 상품을 추가할 수 없습니다.");
		}
	}

	public double calculateTotal() {
		double total = 0;
		for (int i = 0; i < count; i++) {
			total += items[i].getPrice() * quantities[i];
		}
		return total;
	}

	public double calculateDiscountedTotal() {
		double total = 0;
		for (int i = 0; i < count; i++) {
			double discountedPrice = getDiscountedPrice(items[i].getPrice()); // SeasonalDiscount
			total += discountedPrice * quantities[i];
		}
		return customer.applyDiscount(total); // 고객 할인 적용
	}

	public void printOrderSummary() {
		System.out.println("주문 요약:");
		customer.show();
		for (int i = 0; i < count; i++) {
			System.out.println(items[i].toString() + ", 수량: " + quantities[i]);
		}
		System.out.println("총합: " + calculateTotal());
	}

	public void printDiscountDetails() {
		System.out.println("할인된 총합: " + calculateDiscountedTotal());
	}
}

// 메인 클래스
public class 실습과제_8장_B4_동적바인딩3 {
	static void showItemsStock(Item[] items) {
		for (Item item : items) {
			item.show();
		}
	}

	public static void main(String[] args) {
		Item[] items = new Item[4];
		items[0] = new Electronics("노트북", 1500, 100, 2023);
		items[1] = new Clothing("티셔츠", 50, 100, 95);
		items[2] = new Electronics("휴대폰", 800, 100, 2024);
		items[3] = new Clothing("청바지", 80, 100, 90);

		showItemsStock(items);

		Customer regularCustomer = new RegularCustomer("홍길동");
		Customer premiumCustomer = new PremiumCustomer("강감찬");

		Order regularOrder = new Order(regularCustomer);
		regularOrder.addItem(items[0], 1, "240901");
		regularOrder.addItem(items[1], 2, "240902");

		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails();

		Order premiumOrder = new Order(premiumCustomer);
		premiumOrder.addItem(items[1], 1, "240901");
		premiumOrder.addItem(items[3], 2, "240903");

		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails();

		showItemsStock(items);
	}
}
