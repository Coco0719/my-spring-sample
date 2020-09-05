package my.spring.sample.coupon;

public class Coupon {

    private int id;

    private String name;

    private int discountValue;

    public Coupon() {
    }

    public Coupon(int id, String name, int discountValue) {
        this.id = id;
        this.name = name;
        this.discountValue = discountValue;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscountValue() {
        return discountValue;
    }
}
