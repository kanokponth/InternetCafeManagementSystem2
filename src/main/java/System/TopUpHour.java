package System;

public class TopUpHour {
    private int money ;
    private int countHour;
    private int hour;
    private int sumHour;

    public int getHour() {
        return hour;
    }

    public TopUpHour(int money, int hour) {
        this.money = money;
        this.countHour=hour;
    }

    public int getMoney() {
        return money;
    }

    public int getCountHour() {
        return countHour;
    }

    public  void increseHour(){
        if(money>=10){
            hour++;
            money-=10;
        }


    }
    public  void decrese(){
        if(hour>0&&money>=0){
            hour--;
            money+=10;

        }
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setCountHour(int countHour) {
        this.countHour = countHour;
    }
    public  int sumHour(){
        sumHour=countHour+hour;
        return sumHour;

    }

    public int getSumHour() {
        return sumHour;
    }
}
