package gmail.com.varlamvanadia1996.pages;

import com.codeborne.selenide.SelenideElement;
import gmail.com.varlamvanadia1996.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            popupResults = $(".modal-content"),
            tableResults = $(".table"),
            userEmailInput = $("#userEmail"),
            phoneInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput = $x("//textarea[@id=\"currentAddress\"]"),
            stateSelect = $("#react-select-3-input"),
            citySelect = $("#react-select-4-input"),
            submitButton = $("#submit");

    public CalendarComponent calendarComponent = new CalendarComponent();
    public StudentData studentData = new StudentData();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage typeUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage typeGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage typePhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    public RegistrationPage typeSubject(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage typeHobbies(String hobbies) {
        $(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage selectStateAndCity(String state, String city) {
        stateSelect.setValue(state).pressEnter();
        citySelect.setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }


    public RegistrationPage checkResults(StudentData studentData) {
        popupResults.shouldBe(visible);
        tableResults.shouldHave(text(studentData.firstName + " " + studentData.lastName),
                text(studentData.userEmail),
                text(studentData.gender),
                text(studentData.phone),
                text(studentData.year),
                text(studentData.month),
                text(studentData.day),
                text(studentData.subjects),
                text(studentData.hobbiesSports),
                text(studentData.hobbiesReading),
                text(studentData.hobbiesMusic),
                text(studentData.fileName),
                text(studentData.address),
                text(studentData.state + " " + studentData.city));
        return this;
    }

//    public RegistrationPage checkResults(String firstName, String lastName, String email, String gender, String phone, String bday, String subjects, String hobbies, String picture, String currentAddress, String state, String city) {
//        popupResults.shouldBe(visible);
//        tableResults.shouldHave(text(firstName + " " + lastName),
//                text(email),
//                text(gender),
//                text(phone),
//                text(bday),
//                text(subjects),
//                text(hobbies),
//                text(picture),
//                text(currentAddress),
//                text(state + " " + city));
//        return this;
//    }

}
