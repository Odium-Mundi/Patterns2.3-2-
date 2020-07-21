package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardTest {

    @Test
    void shouldPassWhenAccountActive() {
        RegistrationDto account = Generator.falseLogin();
        System.out.println(account.login);
        open("http://localhost:9999");
        $(".input__control [name='login']").setValue(account.login);
        $(".input__control [name='password']").setValue(account.password);
        $(byText("Продолжить")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 2000);
    }



}
