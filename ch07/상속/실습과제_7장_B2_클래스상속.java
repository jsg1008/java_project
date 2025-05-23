package com.ruby.java.ch07.상속;

// Item 클래스
class Item2 {
    private String name; // 상품 이름
    private double price; // 상품 가격
    private int stockQuantity; // 재고 수량

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	// 생성자
    public Item2(String name, double price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // 재고 수량 감소 메서드
    public void reduceStock(int quantity) {
        stockQuantity -= quantity; // 재고 수량 감소
    }

    // 재고 수량 증가 메서드
    public void increaseStock(int quantity) {
        stockQuantity += quantity; // 재고 수량 증가
    }

    // 상품 정보 출력 메서드
    public void show() {
        System.out.println("상품명: " + name + ", 가격: " + price + ", 재고: " + stockQuantity);
    }

    @Override
    public String toString() {
        return "상품명: " + name + ", 가격: " + price + ", 재고: " + stockQuantity;
    }
}

// Electronics 클래스 (Item 클래스를 상속)
class Electronics extends Item2 {
    private int warranty; // 제품 보증 기간

    // 생성자
    public Electronics(String name, double price, int stockQuantity, int warranty) {
        super(name, price, stockQuantity); // 부모 클래스 생성자 호출
        this.warranty = warranty; // 보증 기간 설정
    }

    @Override
    public void show() {
        super.show(); // 부모 클래스의 show 메서드 호출
        System.out.println("보증 기간: " + warranty + "개월"); // 보증 기간 출력
    }

    @Override
    public String toString() {
        return super.toString() + ", 보증 기간: " + warranty + "개월"; // 부모 클래스의 toString 호출
    }
}

// Clothing 클래스 (Item 클래스를 상속)
class Clothing extends Item2 {
    private String size; // 의류 사이즈
    private String color; // 의류 색상

    // 생성자
    public Clothing(String name, double price, int stockQuantity, String size, String color) {
        super(name, price, stockQuantity); // 부모 클래스 생성자 호출
        this.size = size; // 사이즈 설정
        this.color = color; // 색상 설정
    }

    @Override
    public void show() {
        super.show(); // 부모 클래스의 show 메서드 호출
        System.out.println("사이즈: " + size + ", 색상: " + color); // 사이즈와 색상 출력
    }

    @Override
    public String toString() {
        return super.toString() + ", 사이즈: " + size + ", 색상: " + color; // 부모 클래스의 toString 호출
    }
}

// Customer 추상 클래스 정의
abstract class Customer2 {
    private String cname; // 고객 이름
    private String city; // 고객 도시
    private int age; // 고객 나이

    // 생성자
    public Customer2(String cname, String city, int age) {
        this.cname = cname;
        this.city = city;
        this.age = age;
    }

    // 고객 정보 출력 메서드
    public void show() {
        System.out.println("고객명:" + cname + ", 도시:" + city + ", 나이:" + age);
    }

    @Override
    public String toString() {
        return "고객명: " + cname + ", 도시: " + city + ", 나이: " + age;
    }

    // 할인 적용 메서드 (구현해야 함)
    abstract double applyDiscount(double totalAmount);
}

// RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer2 {
    static final double REGULARDISCOUNT_RATE = 0.03; // 일반 고객 할인율

    // 생성자
    public RegularCustomer(String name, String city, int age) {
        super(name, city, age); // 부모 클래스 생성자 호출
    }

    @Override
    double applyDiscount(double totalAmount) {
        return totalAmount * (1 - REGULARDISCOUNT_RATE); // 할인 적용
    }
}

// PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer2 {
    static final double PREMIUMDISCOUNT_RATE = 0.1; // 프리미엄 고객 할인율

    // 생성자
    public PremiumCustomer(String name, String city, int age) {
        super(name, city, age); // 부모 클래스 생성자 호출
    }

    @Override
    double applyDiscount(double totalAmount) {
        return totalAmount * (1 - PREMIUMDISCOUNT_RATE); // 할인 적용
    }
}

// Order 클래스
class Order2 {
    private Customer2 customer; // 주문 고객
    private Item2[] items; // 주문 상품 배열
    private int[] quantities; // 주문 수량 배열
    private int itemCount; // 주문한 상품 수
    
    // 생성자
    public Order2(Customer2 customer, int maxItems) {
        this.customer = customer; // 고객 설정
        this.items = new Item2[maxItems]; // 최대 상품 수만큼 배열 생성
        this.quantities = new int[maxItems]; // 최대 상품 수만큼 수량 배열 생성
        this.itemCount = 0; // 초기 상품 수는 0
    }

    // 상품 추가 메서드
    public void addItem(Item2 item, int quantity) {
        if (itemCount < items.length) {
            items[itemCount] = item; // 상품 추가
            quantities[itemCount] = quantity; // 수량 추가
            itemCount++; // 상품 수 증가
            item.reduceStock(quantity); // 재고 감소
        } else {
            System.out.println("더 이상 상품을 추가할 수 없습니다."); // 최대 수량 초과 시 메시지 출력
        }
    }

    // 총합 계산 메서드
    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getPrice() * quantities[i]; // 각 상품의 가격과 수량을 곱하여 총합 계산
        }
        return total; // 총합 반환
        
    }

    // 할인된 총합 계산 메서드
    public double calculateDiscountedTotal() {
        double total = calculateTotal(); // 총합 계산
        return customer.applyDiscount(total); // 고객의 할인 적용
    }

    // 주문 요약 출력 메서드
    public void printOrderSummary() {
        System.out.println("주문 요약:");
        customer.show(); // 고객 정보 출력
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i].toString() + ", 수량: " + quantities[i]); // 각 상품 정보와 수량 출력
        }
        System.out.println("총합: " + calculateTotal()); // 총합 출력
        System.out.println("할인된 총합: " + calculateDiscountedTotal()); // 할인된 총합 출력
    }
}

// 메인 클래스
public class 실습과제_7장_B2_클래스상속 {
    public static void main(String[] args) {
        // 의류 및 전자제품 생성
        Item2 laptop = new Electronics("노트북", 1200.00, 10, 24);
        Item2 phone = new Electronics("휴대폰", 800.00, 30, 12);
        Item2 tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
        Item2 jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

        // 고객 생성
        PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
        RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);

        // 주문 생성
        Order2 order1 = new Order2(premiumCustomer, 4);
        order1.addItem(laptop, 1);
        order1.addItem(tshirt, 2);

        Order2 order2 = new Order2(regularCustomer, 4);
        order2.addItem(phone, 1);
        order2.addItem(jacket, 1);

        // 주문 요약 출력
        System.out.println("프리미엄 고객 주문:");
        order1.printOrderSummary();

        System.out.println("일반 고객 주문:");
        order2.printOrderSummary();
    }
}
