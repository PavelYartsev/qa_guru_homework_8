package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static data.TestData.*;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormPage {

    public void openPageAndCheckHeader(String siteUrl, String headerText) {
        open(siteUrl);
        checkHeader(headerText);
    }

    public void fillForm(Map<String, String> studentData) {
        step("Fill first and last name", () -> {
            fillTextInput(firstNameInputLocator, studentData.get("First Name"));
            fillTextInput(lastNameInputLocator, studentData.get("Last Name"));
        });
        step("Fill email", () -> {
            fillTextInput(emailInputLocator, studentData.get("Email"));
        });
        step("Fill gender", () -> {
            clickElementWithText(parentElementLocatorGender, studentData.get("Gender"));
        });
        step("Fill mobile phone", () -> {
            fillTextInput(phoneLocator, studentData.get("Mobile Phone"));
        });
        step("Fill date of birth", () -> {
            setDate(studentData.get("Year of Birth"), studentData.get("Month of Birth"), studentData.get("Day of Birth"));
        });
        step("Fill subjects", () -> {
            fillAutocompleteInput(subjectInputLocator, studentData.get("Short Subject 1"), studentData.get("Subject 1"));
            fillAutocompleteInput(subjectInputLocator, studentData.get("Short Subject 2"), studentData.get("Subject 2"));
        });
        step("Fill hobbies", () -> {
            clickElementWithText(parentElementLocatorHobby, studentData.get("Hobby 1"));
            clickElementWithText(parentElementLocatorHobby, studentData.get("Hobby 2"));
        });
        step("Upload image", () -> {
            uploadFile(uploadButtonLocator, studentData.get("File Name"));
        });
        step("Set address", () -> {
            fillTextInput(addressInputLocator, studentData.get("Address"));
            fillSelectInput(stateInputLocator, studentData.get("State"));
            fillSelectInput(cityInputLocator, studentData.get("City"));
        });
        step("Submit registration form", () -> {
            buttonClick(submitButtonLocator);
        });
    }

    public void checkFilledData(Map<String, String> studentData) {
        step("Verify successful form submit", () -> {
            modalForCheckingLocator.shouldHave(text(studentData.get("First Name")), text(studentData.get("Last Name")),
                    text(studentData.get("Email")), text(studentData.get("Gender")), text(studentData.get("Mobile Phone")),
                    text(studentData.get("Subject 1")), text(studentData.get("Subject 2")), text(studentData.get("Hobby 1")),
                    text(studentData.get("Hobby 2")), text(studentData.get("File Name")), text(studentData.get("Address")),
                    text(studentData.get("State")), text(studentData.get("City")),
                    text(studentData.get("Day of Birth") + " " + getMonthName(studentData.get("Month of Birth")) + "," + studentData.get("Year of Birth")));
        });
        step("Close form", () -> {
            buttonClick(closeLargeModalLocator);
        });
    }

    public void setDate(String year, String month, String day) {
        dateOfBirthInputLocator.click();
        birthYearLocator.selectOptionByValue(year);
        birthMonthLocator.selectOptionByValue(month);
        $(byText(day)).click();
    }

    public void checkHeader(String headerText) {
        pageHeaderLocator.shouldHave(text(headerText));
    }

    public void buttonClick(SelenideElement buttonLocator) {
        buttonLocator.click();
    }

    public void fillTextInput(SelenideElement textInputLocator, String value) {
        textInputLocator.setValue(value);
    }

    public void fillAutocompleteInput(SelenideElement subjectInputLocator, String shortSubject, String subject) {
        subjectInputLocator.setValue(shortSubject);
        $(byText(subject)).click();
    }

    public void uploadFile(SelenideElement uploadButtonLocator, String fileName) {
        uploadButtonLocator.uploadFromClasspath(fileName);
    }

    public void clickElementWithText(SelenideElement parentElementLocator, String elementText) {
        parentElementLocator.$(byText(elementText)).click();
    }

    public void fillSelectInput(SelenideElement selectInputLocator, String selectInputValue) {
        selectInputLocator.setValue(selectInputValue).pressEnter();
    }
}