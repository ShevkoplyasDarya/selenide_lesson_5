package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HoverTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920*1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }

    @Test
    void HoverSolutions() {
        open("https://github.com");
        //hover on Solutions
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        //select Enterprise
        $(".header-menu-wrapper").$(byText("Enterprise")).click();
        //check if "Build like the best" header is present
        $(".container-xl h1").shouldHave(text("Build like the best"));
    }
}
