package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTestWithPageObjects {
    PracticeFormPage practiceFormPage = new PracticeFormPage();


    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTests() {
        practiceFormPage.openPage()
                        .setFirstName("Radja")
                        .setLastName("Nainggolan")
                        .setUserEmail("radja.n@gmail.com")
                        .setGender("Male")
                        .setNumber("1234567890")
                        .setBirthDate("04", "May", "1988")
                        .setSubjectsInput("Hindi")
                        .setHobbies("Music")
                        .uploadFile("src/test/resources/foto.jpg")
                        .setAddress("ul.Pushkina, d.1")
                        .setStateAndCity("Uttar Pradesh", "Merrut")
                        .clickOnSubmit();


        practiceFormPage.checkResultTableIsVisible()
                        .checkResult("Student Name", "Radja")
                        .checkResult("Date of Birth", "04 May,1988")
                        .checkResult("Student Email", "radja.n@gmail.com");

    }
}