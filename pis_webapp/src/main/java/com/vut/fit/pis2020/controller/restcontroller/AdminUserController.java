package com.vut.fit.pis2020.controller.restcontroller;

import com.vut.fit.pis2020.converter.UserDtoConverter;
import com.vut.fit.pis2020.dto.UserDto;
import com.vut.fit.pis2020.entity.User;
import com.vut.fit.pis2020.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class AdminUserController {

    @Autowired
    private UserDtoConverter userDtoConverter;

    @Autowired
    private UserService userService;

    @GetMapping("/api/admin/users")
    public List<UserDto> index() {

        List<User> allUsers = userService.findAll();
        List<UserDto> allUsersDto = new ArrayList<>();

        for (User user: allUsers) {
            allUsersDto.add(userDtoConverter.convertToUserDto(user));
        }

        return allUsersDto;
    }

    @GetMapping("/api/admin/users/{userId}")
    public UserDto getUser(@PathVariable("userId") Long userId) {

        User user = userService.findById(userId);

        return userDtoConverter.convertToUserDto(user);
    }

    @PostMapping("/api/admin/users/create")
    public HashMap<String, String> createUser(@ModelAttribute("user") UserDto userDto) {

        HashMap<String, String> returnCode = new HashMap<>();

        if(userService.findByEmail(userDto.getEmail()) != null) {
            returnCode.put("400", "There is already a user registered with the email provided");

            return returnCode;
        }

        User user = userDtoConverter.convertToUser(userDto);
        userService.save(user);

        returnCode.put("200", "User registered");

        return returnCode;
    }
}
