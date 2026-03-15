package org.example.spiritassignment1group4.services;

import org.example.spiritassignment1group4.models.UserAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountServices {
    List<UserAccount> userAccounts = new ArrayList<>();

    public UserAccountServices() {
        var u1 = new UserAccount();
        u1.setUserName("mark11");
        u1.setPassword("mark123");
        u1.setRole("Patient");

        userAccounts.add(u1);

        var u2 = new UserAccount();
        u2.setUserName("habil55");
        u2.setPassword("habil123");
        u2.setRole("Doctor");

        userAccounts.add(u2);
    }

    public List<UserAccount> findAllUserAccounts() {
        return this.userAccounts;
    }

    public void saveUserAccount(String userName, String password, String role) {
        var newUserAccount = new UserAccount();
        newUserAccount.setUserName(userName);
        newUserAccount.setPassword(password);
        newUserAccount.setRole(role);
        this.userAccounts.add(newUserAccount);
    }
}
