import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



public class CheckJU5OnGitHubSelenideTest {
    @Test
    void checkJUnit5OnGitHubSelenide(){

        Configuration.browserSize = "1920x1080";

        String expectedCode = "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}";

        open("https://github.com/selenide");

        $("span[title = selenide]").click();
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $("[data-filterable-for = wiki-pages-filter]").shouldHave(text("SoftAssertions"));

        $(".Truncate-text[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $(".markdown-body").shouldHave(text("Example"), text("Using JUnit5 extend test class"));

        String foundedCode = $("#user-content-3-using-junit5-extend-test-class")
                .closest("h4").sibling(0).$("pre").getText();

        Assertions.assertEquals(foundedCode, expectedCode);

    }

}
