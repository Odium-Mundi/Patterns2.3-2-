package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

@Data
@AllArgsConstructor
@Value
@Getter
public class RegistrationDto {
     String login;
     String password;
     String status;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

}