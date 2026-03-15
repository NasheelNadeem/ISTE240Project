package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.services.UserAccountServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserAccountController {
    private UserAccountServices userServ;

    public UserAccountController(UserAccountServices userServ) {
        this.userServ = userServ;
    }

    @GetMapping("/userAccounts")
    public String viewUserAccounts(Model data) {
        data.addAttribute("userAccounts", userServ.findAllUserAccounts());
        return "userAccounts";
    }

    @GetMapping("/addUserAccount")
    public String addUserAccountForm(Model data) {
        return "redirect:addUserAccount.html";
    }

    @PostMapping("/addUserAccount")
    public String addUserAccount(@RequestParam String userName, @RequestParam String password, @RequestParam String role, Model data) {
        userServ.saveUserAccount(userName, password, role);
        return "redirect:userAccountSuccess";
    }

    @GetMapping("/userAccountSuccess")
    public String showUserAccountSuccess(Model data) {
        data.addAttribute("userAccount", userServ.findAllUserAccounts().get(userServ.findAllUserAccounts().size()-1));
        return "userAccountSuccess";
    }
}
