package com.vut.fit.pis2020.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/admin")
    public String admin() { return "index"; }

    @RequestMapping("/admin/users")
    public String adminUsersIndex() { return "index"; }

}
