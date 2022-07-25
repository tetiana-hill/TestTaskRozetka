import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends XPathForMainPage{
    public void goToCategory() {
        $x(ehlektronika).click();
    }
}
