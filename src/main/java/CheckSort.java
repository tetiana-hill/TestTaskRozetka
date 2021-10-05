import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CheckSort {

    public void checkSortPrice() throws Exception {
        $x("//ul//li[2]/a[@class='menu-categories__link']").click();
        $x("//ul//li//a[@class='tile-cats__picture']").click();
        $x("//select/option[3]").click();

        ElementsCollection allPrices = $$x("//ul[@class='catalog-grid ng-star-inserted']//li//span[@class='goods-tile__price-value']");
        int prevprice = 0;
        for (SelenideElement p : allPrices) {
            int price = Integer.parseInt(p.getText().replaceAll("\\s", ""));
            if (prevprice != 0 && prevprice < price) {

                throw new Exception("Price is:  false");
            }

            prevprice = price;
        }

    }
}
