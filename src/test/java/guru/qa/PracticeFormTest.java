package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;


public class PracticeFormTest {


    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue("Radja");
        $("#lastName").setValue("Nainggolan");
        $("#userEmail").setValue("radja.n@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $("select.react-datepicker__month-select").click();
        $("select.react-datepicker__month-select").selectOption("May");
        $("select.react-datepicker__year-select").click();
        $("select.react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue("di").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("foto.jpg");
        $("#currentAddress").setValue("ul. Lenina, d.1");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Merrut")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("Radja"),
                text("Nainggolan"),
                text("radja.n@gmail.com"),
                text ("1234567890"),
                text("04 May,1988"),
                text("Hindi"),
                text("Music"),
                text("foto.jpg"),
                text("ul. Lenina, d.1"),
                text("Uttar Pradesh Merrut")
        );
    }
}