import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
        MainPage mainPage = new MainPage();
                mainPage.goToCategory();

        CatalogPage catPage = new CatalogPage();
                catPage.goToListing();

        ListingPage listing = new ListingPage();
                listing.applySort();
                listing.checkSortPrice();
                listing.loadNextItems();
                listing.promoGoods();


    }
}