package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static config.ConfigHelper.*;

public class GoogleTests {

    @Test
    void selenideSearchTest() {
        Configuration.remote = getWebdriverRemote();

        String searchSite = getSearchSite();
        String searchItem = getSearchItem();
        String searchResult = getSearchResult();
        String password = getPassword();
        System.out.println(password);

        open(searchSite);

        $(byName("q")).setValue(searchItem).pressEnter();

        $("html").shouldHave(text(searchResult));
    }
}