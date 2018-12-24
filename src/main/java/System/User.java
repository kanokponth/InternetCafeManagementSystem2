package System;

public class User {
    private String username,password,email,access_Level;
    private int balance;
    private int hour;
    private int min;
    private int sec;
    private String state;

    public User(String username, String password, String email, String access_Level, int balance, int hour, int min, int sec,String state) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.access_Level = access_Level;
        this.balance = balance;
        this.hour = hour;
        this.min=min;
        this.sec=sec;
        this.state=state;
    }

    public User(String username, int balance) {
        this.username = username;
        this.balance = balance;
    }

    public User() {
    }
    public String getState(){
        return state;
    }
    public void setState(String s){
        this.state=s;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessLevel() {
        return access_Level;
    }

    public void setAccessLevel(String accessLevel) {
        this.access_Level = accessLevel;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", access_Level='" + access_Level + '\'' +
                ", balance=" + balance +
                ", hour=" + hour +
                '}';
    }
}
