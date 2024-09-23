package com.jeido.msuser.service;

import com.jeido.msuser.dto.UserDtoReceive;
import com.jeido.msuser.dto.UserDtoSend;
import com.jeido.msuser.entity.User;
import com.jeido.msuser.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public UserDtoSend create(UserDtoReceive userDtoReceive) {
        return UserDtoSend.of(repo.save(userDtoReceive.get()));
    }

    public UserDtoSend get(Long id) {
        return UserDtoSend.of(repo.findById(id).orElseThrow());
    }

    public List<UserDtoSend> getAll() {
        List<User> users = (List<User>) repo.findAll();
        return users.stream().map(UserDtoSend::of).toList();
    }

    public UserDtoSend update(Long id, UserDtoReceive userDtoReceive) {
        User user = repo.findById(id).orElseThrow();
        user.setUsername(userDtoReceive.getUsername());
        user.setEmail(userDtoReceive.getEmail());
        return UserDtoSend.of(repo.save(user));
    }

    public boolean delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return !repo.existsById(id);
        }

        return false;
    }
}
