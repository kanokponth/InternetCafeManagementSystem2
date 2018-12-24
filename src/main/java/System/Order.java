package System;

public class Order {
    private String detail,computerNumber;
    private int totalPrice;

    public Order(String computerNumber, String detail, int totalPrice) {
        this.computerNumber = computerNumber;
        this.detail = detail;
        this.totalPrice = totalPrice;
    }

    public Order() {
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(String computerNumber) {
        this.computerNumber = computerNumber;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}