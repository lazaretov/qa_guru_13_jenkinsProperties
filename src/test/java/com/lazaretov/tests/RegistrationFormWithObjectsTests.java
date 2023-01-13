package com.lazaretov.tests;

import com.lazaretov.pages.RegistrationFormPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.lazaretov.testData.UserInfo.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormWithObjectsTests extends TestBase{
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @Feature("Форма регистрации")
    @Story("Заполнение всех полей")
    @Owner("lazaretov")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing site", url = "https://demoqa.com")
    @DisplayName("Проверка полей формы регистрации")
    void fillFormTest() {
        step("Открыть и заполнить форму", () -> {
            registrationFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setPhone(phone)
                    .setDateOfBirth(day, month, year)
                    .setSubjects(subject)
                    .setHobbies(hobby)
                    .uploadPic(pic)
                    .setAddress(address, state, city)
                    .clickSubmit();
        });
        step("Проверить результаты", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phone)
                    .checkResult("Date of Birth", date)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobby)
                    .checkResult("Picture", pic)
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);
        });
    }
}
