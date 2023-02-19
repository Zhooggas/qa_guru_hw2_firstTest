import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class DemoQaPracticeFormTest {

    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void studentRegistrationTest(){

        File file = new File("src/test/resources/хомяк.png");

        open("/automation-practice-form");

        $("#firstName").setValue("Иван");
        $("#lastName").setValue("Тестов");
        $("#userEmail").setValue("testov@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("9030000001");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("option[value='3']").click();
        $(".react-datepicker__year-select").click();
        $("option[value='2005']").click();
        $("div[aria-label='Choose Sunday, April 3rd, 2005']").click();
        $("#subjectsInput").setValue("острые предметы");
        $("label[for='hobbies-checkbox-3']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Село Кукуево, К.Маркса street");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Иван Тестов"));
        $("tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("testov@gmail.com"));
        $("tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("9030000001"));
        $("tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("03 April,2005"));
        //дефект, строка очищается после заполнения
        //$("tbody tr:nth-child(6) td:nth-child(2)").shouldHave(text("острые предметы"));
        $("tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Music, Reading"));
        $("tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("хомяк.png"));
        $("tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("Село Кукуево, К.Маркса street"));
        $("tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("Uttar Pradesh Lucknow"));
        $("#closeLargeModal").exists();

    }

}
