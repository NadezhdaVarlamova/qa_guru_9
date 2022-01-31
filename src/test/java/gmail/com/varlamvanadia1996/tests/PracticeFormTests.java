package gmail.com.varlamvanadia1996.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import gmail.com.varlamvanadia1996.pages.RegistrationPage;
import gmail.com.varlamvanadia1996.pages.StudentData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PracticeFormTests {

    RegistrationPage registrationPage = new RegistrationPage();
    StudentData studentData = new StudentData();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    void successTests() {
        registrationPage.openPage()
                .typeFirstName(studentData.firstName)
                .typeLastName(studentData.lastName)
                .typeUserEmail(studentData.userEmail)
                .typeGender(studentData.gender)
                .typePhone(studentData.phone);
        registrationPage.calendarComponent.setDae(studentData.year, studentData.month, studentData.day);
        registrationPage.typeSubject(studentData.subjects)
                .typeHobbies(studentData.hobbiesSports)
                .typeHobbies(studentData.hobbiesReading)
                .typeHobbies(studentData.hobbiesMusic)
//                .uploadPicture(studentData.fileName)
                .setAddress(studentData.address)
                .selectStateAndCity(studentData.state, studentData.city)
                .submitForm()
                .checkResults(studentData);
    }
}
