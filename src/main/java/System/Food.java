package System;

public class Food {
    private String foodID,foodName;
    private int foodPrice;

    public Food(String foodID, String foodName, int foodPrice) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public Food() {
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }
}
