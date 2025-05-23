package com.ruby.java.ch07.상속;

class Item { // 제품
    private String name; // 제품명
    private double price; // 제품 가격
    private int stockQuantity; // 재고량

    // 생성자
    public Item(String name, double price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // 재고 감소 메소드
    public void reduceStock(int quantity) {
        stockQuantity -= quantity;
    }

    // 재고 증가 메소드
    public void increaseStock(int quantity) {
        stockQuantity += quantity;
    }

    // 정보 출력 메소드
    public void show() {
        System.out.println("제품명 : " + name + ", 제품가격 : " + price + ", 재고량 = " + stockQuantity);
    }

    @Override
    public String toString() {
        return "제품 : " + name + ", 가격 : " + price + ", 재고 = " + stockQuantity;
    }

    // 접근자 메소드
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Customer { // 고객
    private String cname; // 고객 이름
    private String city; // 고객 도시
    private int age; // 고객 나이

    // 생성자
    public Customer(String cname, String city, int age) {
        this.cname = cname;
        this.city = city;
        this.age = age;
    }

    // 정보 출력 메소드
    public void show() {
        System.out.println("이름 = " + cname + ", 주소 = " + city + ", 나이 = " + age);
    }

    @Override
    public String toString() {
        return "이름 = " + cname + ", 주소 = " + city + ", 나이 = " + age;
    }
}
class Order { // 주문
    private Customer customer; // 고객
    private Item[] items; // 주문 제품들
    private int[] quantities; // 주문 제품 수량들
    private int count; // 아이템 개수

    // 생성자
    public Order(Customer customer, int maxCount) {
        this.customer = customer;
        this.items = new Item[maxCount];
        this.quantities = new int[maxCount];
        this.count = 0;
    }

    // 아이템 추가 메소드
    public void addItem(Item item, int orderQuantity) {
        if (count < items.length) {
        	items[count] = item;
            quantities[count] = orderQuantity;
            item.reduceStock(orderQuantity); // 재고 감소
            count++;
        } else {
        	System.out.println("더 이상 아이템을 추가할 수 없습니다.");
        }
        return;       
    }

    // 총액 계산 메소드
    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += items[i].getPrice() * quantities[i];
        }
        return total;
    }

    // 주문 요약 출력 메소드
    public void printOrderSummary() {
        System.out.println("\n=== 주문 요약 ===");
        System.out.println(customer.toString());
        double subTotal = 0;
        for (int i = 0; i < count; i++) {
        	double itemTotal = items[i].getPrice()*quantities[i];
        	subTotal += itemTotal;
            System.out.println("제품명 : " + items[i].getName() + ", 수량: " + quantities[i] +
                               ", 단가: " + items[i].getPrice()+"==>" + " 가격 "+subTotal);
        }
        System.out.println();
        System.out.println("총액: " + calculateTotal());
    }
}

public class 실습과제_7장_B1_객체생성 {
    public static void main(String[] args) {
        // 아이템 생성
        Item laptop = new Item("노트북", 1200.00, 10);
        Item tshirt = new Item("티셔츠", 20.00, 50);
        Item phone = new Item("휴대폰", 800.00, 30);
        Item headphones = new Item("헤드폰", 150.00, 20);
        Item mouse = new Item("마우스", 30.00, 15);

        // 고객 생성
        Customer boy = new Customer("홍길동", "부산", 21);
        Customer girl = new Customer("계백", "양산", 22);

        // 주문 생성
        Order order1 = new Order(boy, 5); // 최대 5개 아이템
        order1.addItem(laptop, 1);
        order1.addItem(tshirt, 2);
        order1.addItem(phone, 1);
        order1.addItem(headphones, 1);
        order1.addItem(mouse, 1);

        Order order2 = new Order(girl, 5); // 최대 5개 아이템
        order2.addItem(laptop, 1);
        order2.addItem(tshirt, 1);
        order2.addItem(phone, 1);
        order2.addItem(headphones, 1);
        order2.addItem(mouse, 1);

        // 주문 요약 출력
        order1.printOrderSummary();
        order2.printOrderSummary();
    }
}
