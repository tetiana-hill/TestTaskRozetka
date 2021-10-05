import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class RozetkaTest {

    @BeforeTest
    public void beforeTest() {
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        open("http://rozetka.com.ua/");
    }


    @Test
    public void mainTestRozetka() throws Exception {

        CheckSort checkSort = new CheckSort();
                checkSort.checkSortPrice();


        Goods goods = new Goods();
        goods.promoGoods();
    }
}