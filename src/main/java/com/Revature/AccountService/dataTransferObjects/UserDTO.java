package com.Revature.AccountService.dataTransferObjects;

import com.Revature.AccountService.beans.User;
import com.Revature.AccountService.beans.enums.SecurityLevel;

public class UserDTO {
    private long userId;
    private String username;
    private String firstName;
    private String lastName;
    private String pword;
    private String email;
    private int securityLevel;

    public UserDTO(){}

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public User convertToUser(){
        User u = new User(
                this.userId,
                this.username,
                this.firstName,
                this.lastName,
                this.pword,
                this.email,
                SecurityLevel.getSecurityLevelbyLevelId(this.securityLevel));
        return u;
    }

    public static UserDTO getDTO(User u){
        UserDTO x = new UserDTO();
        x.userId = u.getUserId();
        x.username = u.getUsername();
        x.firstName = u.getFirstName();
        x.lastName = u.getLastName();
        x.pword = u.getPword();
        x.email = u.getEmail();
        x.securityLevel = u.getSecurityLevel().getLevelId();
        return x;
    }
}
