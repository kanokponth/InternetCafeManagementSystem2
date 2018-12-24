

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import System.FoodDao;
import System.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;
class FoodDaoMockTest {
    @Mock
    private FoodDaoMock Mock;
    @Mock
    private FoodDao foodDao;
    @Mock
    private Food food;

    @BeforeEach
    void initMock(){
        foodDao = mock(FoodDao.class);
        Mock = new FoodDaoMock(foodDao);
        food = new Food();
    }

    @Test
    void find_All_Data_Db() throws SQLException {
        Mock.findAllDb();
        verify(foodDao).findAll(); }

    @Test
    void add_Data_To_Db() throws SQLException {
        Mock.add(food);
        verify(foodDao).add(food);
    }
}