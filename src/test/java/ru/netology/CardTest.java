package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardTest {

    @Test
    void shouldPassWhenAccountActive() {
        RegistrationDto account = Generator.active();
        System.out.println(account.login);
        open("http://localhost:9999");
        $("[name='login']").setValue(account.getLogin());
        $("[name='password']").setValue(account.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Личный кабинет")).waitUntil(Condition.visible, 2000);
    }

    @Test
    void shouldPassWhenAccountBlocked() {
        RegistrationDto account = Generator.blocked();
        System.out.println(account.login);
        open("http://localhost:9999");
        $("[name='login']").setValue(account.getLogin());
        $("[name='password']").setValue(account.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Пользователь заблокирован")).waitUntil(Condition.visible, 2000);
    }

    @Test
    void shouldPassWhenAccountFalseLogin() {
        RegistrationDto account = Generator.falseLogin();
        System.out.println(account.login);
        open("http://localhost:9999");
        $("[name='login']").setValue(account.getLogin());
        $("[name='password']").setValue(account.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 2000);
    }

    @Test
    void shouldPassWhenAccountFalsePassword() {
        RegistrationDto account = Generator.falsePassword();
        System.out.println(account.login);
        open("http://localhost:9999");
        $("[name='login']").setValue(account.getLogin());
        $("[name='password']").setValue(account.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 2000);
    }


}
