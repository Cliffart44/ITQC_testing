import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class PageUiTestTest {
    private final SelenideElement russianSlogan = $(".as-h1>.rus");
    private final SelenideElement englishSlogan = $(".as-h1 noindex");
    private final SelenideElement switchToRussian = $(".en>.rus");
    private final SelenideElement switchToEnglish = $(".rus>.en");


    @BeforeEach
    void setUp() {
        open("http://www.itqc.ru");
    }

    @Test
    void shouldCheckSloganLiteracyRussian() {
        if (switchToRussian.isDisplayed()) switchToRussian.click();
        russianSlogan.shouldBe(visible).shouldHave(exactOwnText("Не платите за ошибки — платите за качество вашей системы"));
    }

    @Test
    void shouldCheckSloganLiteracyEnglish() {
        if (switchToEnglish.isDisplayed()) switchToEnglish.click();
        englishSlogan.shouldBe(visible).shouldHave(exactOwnText("Pay for the quality of your system — not for errors!"));
    }
}