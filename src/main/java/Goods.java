import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class Goods {

    public void promoGoods() throws IOException {

        ElementsCollection allGoods = $$("ul.catalog-grid li.catalog-grid__cell");
//        System.out.println(allGoods.size());

        ArrayList<String> goodsWithPromo = new ArrayList<String>();
        FileWriter fw = new FileWriter("result.txt");

        for (SelenideElement item : allGoods) {
            boolean existsPromo = item.find(".promo-label_type_action").exists();
            if (existsPromo) {
                String price = item.find(".goods-tile__price-value").getText();
                String title = item.find(".goods-tile__title").getText();
                fw.write(price + title + "\r\n");

            }
//            $x("//a[@class='button button_color_gray button_size_medium pagination__direction pagination__direction_type_forward ng-star-inserted']").click();
        }
        fw.close();
//        System.out.println(goodsWithPromo.size());

    }
}