package com.jeido.msuser.controller;

import com.jeido.msuser.dto.UserDtoReceive;
import com.jeido.msuser.dto.UserDtoSend;
import com.jeido.msuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDtoSend> create(@Validated @RequestBody UserDtoReceive userDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDtoReceive));
    }

    @GetMapping
    public ResponseEntity<List<UserDtoSend>> findAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDtoSend> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.get(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDtoSend> update(@PathVariable Long id, @Validated @RequestBody UserDtoReceive userDtoReceive) {
        return ResponseEntity.ok(userService.update(id, userDtoReceive));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<UserDtoSend>> delete(@PathVariable Long id) {
        if (userService.delete(id)) {
            return ResponseEntity.ok(userService.getAll());
        }
        return ResponseEntity.noContent().build();
    }
}
