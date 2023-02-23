import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @Test
    void dragAndDropWithSelenideCheck() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDropTo($("#column-b"));

        $("#column-b header").shouldHave(text("A"));

        }

    @Test
    void dragAndDropViaActions(){

        open("https://the-internet.herokuapp.com/drag_and_drop");

        actions().clickAndHold($("#column-a header")).moveByOffset(250, 0).release().build().perform();

        $("#column-b header").shouldHave(text("A"));

    }
}
