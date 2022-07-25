import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.FileWriter;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class ListingPage extends XPathForListingPage {

    public void applySort() {
        $x(sortByPrice).click();
    }

    public void checkSortPrice() throws Exception {

        ElementsCollection allPrices = $$x(itemPriceForArray);
        int prevprice = 0;
        for (SelenideElement p : allPrices) {
            int price = Integer.parseInt(p.getText().replaceAll("\\s", ""));
            System.out.println(price);
            if (prevprice != 0 && prevprice < price) {

                throw new Exception("Price is false. Not sorted");
            }

            prevprice = price;
        }

    }

    public void loadNextItems() {
        for (int i = 0; i < 2; i++) {
            $x(moreItemButton).scrollIntoView("{block: \"center\"}").click();
        }
    }

    public void promoGoods() throws IOException {
        $x(moreItemButton).scrollIntoView(false);

        ElementsCollection allGoods = $$(itemPromo);
        System.out.println(allGoods.size());
        FileWriter fw = new FileWriter("result.txt");

        for (SelenideElement item : allGoods) {
            boolean existsPromo = item.find(promoLabel).exists();
            if (existsPromo) {
                String price = item.find(itemPriceValue).getText();
                String title = item.find(itemTitle).getText();
                fw.write(price + " " + title + "\r\n");
                System.out.println("fw done");

            }
        }
        fw.close();
    }
}
