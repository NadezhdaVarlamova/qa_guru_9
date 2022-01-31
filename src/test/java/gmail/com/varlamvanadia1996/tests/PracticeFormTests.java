package gmail.com.varlamvanadia1996.tests;

import com.github.javafaker.Faker;
import gmail.com.varlamvanadia1996.pages.RegistrationPage;
import gmail.com.varlamvanadia1996.pages.StudentData;
import org.junit.jupiter.api.Test;

public class PracticeFormTests {

    RegistrationPage registrationPage = new RegistrationPage();
    StudentData studentData = new StudentData();

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
                .uploadPicture(studentData.fileName)
                .setAddress(studentData.address)
                .selectStateAndCity(studentData.state, studentData.city)
                .submitForm()
                .checkResults(studentData);
    }
}
