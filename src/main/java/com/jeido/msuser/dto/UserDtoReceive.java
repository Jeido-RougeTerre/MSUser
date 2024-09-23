package com.jeido.msuser.dto;

import com.jeido.msuser.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDtoReceive {
    @NotNull
    @Size(min = 2, max = 20)
    private String username;
    @NotNull
    @Email
    private String email;

    public User get() {
        return User.builder()
                .username(username)
                .email(email)
                .build();
    }
}
