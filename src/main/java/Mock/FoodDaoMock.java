
import System.FoodDao;
import System.Food;

import java.sql.SQLException;

public class FoodDaoMock {
    private FoodDao foodDao;

    public FoodDaoMock(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public void findAllDb() throws SQLException {
        this.foodDao.findAll();
    }

    public void add(Food food) throws SQLException {
        this.foodDao.add(food);
    }
}
