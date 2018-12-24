package System;

public class Topup {
    private int money;

    public void topUp(int m){
        money+=m;
    }

    public void setMoney(int m){
        this.money = m;
    }

    public int getMoney() {
        return money;
    }
}
