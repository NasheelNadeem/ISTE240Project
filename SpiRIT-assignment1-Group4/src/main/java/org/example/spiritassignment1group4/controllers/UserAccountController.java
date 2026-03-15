package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.services.ProjectServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserAccountController {
    private final ProjectServices projectServices;

    public UserAccountController(ProjectServices projectServices) {
        this.projectServices = projectServices;
    }

    @GetMapping("/userAccounts")
    public String viewUserAccounts(Model data) {
        data.addAttribute("userAccounts", projectServices.findAllUserAccounts());
        return "userAccounts"; // userAccounts.mustache
    }

    @GetMapping("/addUserAccount")
    public String addUserAccountForm() {
        return "redirect:/addUserAccount.html";
    }

    @PostMapping("/addUserAccount")
    public String addUserAccount(@RequestParam String userName,
                                 @RequestParam String password,
                                 @RequestParam String role) {
        projectServices.saveUserAccount(userName, password, role);
        return "redirect:/add/success/userAccount";
    }
}