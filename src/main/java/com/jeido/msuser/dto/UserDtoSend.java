package com.jeido.msuser.dto;

import com.jeido.msuser.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDtoSend {
    private long id;
    private String username;
    private String email;

    public static UserDtoSend of(User user) {
        return new UserDtoSend(user.getId(), user.getUsername(), user.getEmail());
    }

    public User get() {
        return new User(id, username, email);
    }
}
