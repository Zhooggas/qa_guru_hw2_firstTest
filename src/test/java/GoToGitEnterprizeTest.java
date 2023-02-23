import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GoToGitEnterprizeTest {

    @Test
    void goToGitHubEnterprize(){

        open("https://github.com/");

        $(withText("Solutions")).hover();
        $(withTagAndText("a", "Enterprise")).click();

        $(".enterprise-hero").shouldHave(text("Build like the best"));
    }
}
