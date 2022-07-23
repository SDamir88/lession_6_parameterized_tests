package praktice;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


public class ParameterizedSearchMvideoTests {
    @BeforeEach
     void precondition() {
        open("https://www.mvideo.ru/");
        Configuration.browserSize = "1980x1024";
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @ValueSource(strings = {"ноутбуки", "планшеты"})
    @ParameterizedTest(name = "Проверка отображения поисковых результатов на сайте")

    void commonSearchTest(String testData) {

        $("[placeholder= 'Искать климатическую технику со скидкой']").setValue(testData).pressEnter();
        $("[itemprop= 'name']").shouldBe(visible);
    }
}
