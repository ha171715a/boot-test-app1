package com.dev.ict.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ict.domain.UserVO;
import com.dev.ict.entity.User;
import com.dev.ict.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cache")
@RestController
@RequestMapping("/api/cache")
public class UserRestController {
 
    private final UserService userService;

    UserRestController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/insert-user")
    public ResponseEntity<User> insertUser(@RequestBody UserVO userVO) {

        return null;
    }

    @GetMapping("/get-user/{seq}")
    public ResponseEntity<UserVO> getUser(@PathVariable("seq") Long seq) {

        return null;
    }

}
