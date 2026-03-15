package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.services.ProjectServices;
import org.example.spiritassignment1group4.services.UserAccountServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserAccountController {
    private ProjectServices projectServices;

    public UserAccountController(ProjectServices projectServices) {
        this.projectServices = projectServices;
    }

    @GetMapping("/userAccounts")
    public String viewUserAccounts(Model data) {
        data.addAttribute("userAccounts", projectServices.findAllUserAccounts());
        return "userAccounts";
    }

    @GetMapping("/addUserAccount")
    public String addUserAccountForm(Model data) {
        return "redirect:addUserAccount.html";
    }

    @PostMapping("/addUserAccount")
    public String addUserAccount(@RequestParam String userName, @RequestParam String password, @RequestParam String role, Model data) {
        projectServices.saveUserAccount(userName, password, role);
        return "redirect:userAccountSuccess";
    }

    @GetMapping("/userAccountSuccess")
    public String showUserAccountSuccess(Model data) {
        data.addAttribute("userAccount", projectServices.findAllUserAccounts().get(projectServices.findAllUserAccounts().size()-1));
        return "userAccountSuccess";
    }
}
