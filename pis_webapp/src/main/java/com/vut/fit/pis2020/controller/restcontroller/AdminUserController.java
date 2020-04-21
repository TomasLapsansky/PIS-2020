package com.vut.fit.pis2020.controller.restcontroller;

import com.vut.fit.pis2020.converter.UserDtoConverter;
import com.vut.fit.pis2020.dto.UserDto;
import com.vut.fit.pis2020.entity.Role;
import com.vut.fit.pis2020.entity.User;
import com.vut.fit.pis2020.service.RoleService;
import com.vut.fit.pis2020.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
            returnCode.put("409", "There is already a user registered with the email provided");

            return returnCode;
        }

        User user = userDtoConverter.convertToUser(userDto);

        Role basicRole = roleService.findByName("user");
        user.setRole(basicRole);

        userService.save(user);

        returnCode.put("201", "User registered");

        return returnCode;
    }

    @PostMapping("/api/admin/users/update")
    public HashMap<String, String> updateUser(@ModelAttribute("user") UserDto userDto) {

        HashMap<String, String> returnCode = new HashMap<>();

        User user = userService.findById(userDto.getId());

        if(user == null) {
            returnCode.put("409", "There is no user with this id");

            return returnCode;
        }

        /* Set new password if exists */
        if(userDto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setSurName(userDto.getSurname());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setCode(userDto.getCode());

        userService.save(user);

        returnCode.put("201", "User updated");

        return returnCode;
    }
}
