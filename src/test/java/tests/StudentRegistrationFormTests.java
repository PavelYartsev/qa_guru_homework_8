package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static data.TestData.*;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormTests extends TestBase {

    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @Test
    void fillStudentRegistrationForm() {

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
}
