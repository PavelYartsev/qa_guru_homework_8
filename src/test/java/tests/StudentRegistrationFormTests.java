package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static data.TestData.*;
import static io.qameta.allure.Allure.step;

@DisplayName("Student registration form test with using selenoid")
public class StudentRegistrationFormTests extends TestBase {

    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @Test
    @Tag("Positive")
    @DisplayName("Positive test for filling student registration form")
    @Owner("Pavel Yartsev")
    void fillStudentRegistrationFormPositive() {

        step("Open student registration form", () -> {
            studentRegistrationFormPage.openPageAndCheckHeader(siteUrl, headerText);
        });
        step("Fill student registration form", () -> {
            studentRegistrationFormPage.fillForm(studentData);
        });
        step("Check data on student registration form", () -> {
            studentRegistrationFormPage.checkFilledData(studentData);
        });
    }

    @Test
    @Tag("Negative")
    @DisplayName("Negative test for filling student registration form")
    @Owner("Pavel Yartsev")
    void fillStudentRegistrationFormNegative() {

        step("Open student registration form", () -> {
            studentRegistrationFormPage.openPageAndCheckHeader(siteUrl, headerText);
        });
        step("Fill student registration form", () -> {
            studentRegistrationFormPage.fillForm(studentData);
        });
        step("Check data on student registration form", () -> {
            studentRegistrationFormPage.buttonClick(closeLargeModalLocator);
            studentRegistrationFormPage.checkFilledData(studentData);
        });
    }
}
