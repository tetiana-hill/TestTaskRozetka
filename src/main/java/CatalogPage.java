import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage extends XpathForCatalogPage {
    public void goToListing() {
        $x(smartphones).click();
    }
}
