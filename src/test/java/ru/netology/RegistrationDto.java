package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationDto {
    public String login;
    public String password;
    public String status;

    public RegistrationDto(String login, String password, String active) {
    }
}