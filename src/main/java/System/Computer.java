package System;

public class Computer {
    private String status;
    private int computerNumber;

    public Computer(int computerNumber, String status) {
        this.computerNumber = computerNumber;
        this.status = status;
    }

    public Computer() {
    }

    public int getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(int computerNumber) {
        this.computerNumber = computerNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}