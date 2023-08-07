package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MoveSquaresTest {
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
    void moveSquares() {
        // open page internet.herokuapp
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //find squares A & B
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        //move square A
        $("#column-a").dragAndDropTo($("#column-b"));
        //check if squares moved
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }


}