package com.Revature.AccountService.beans;

import com.Revature.AccountService.beans.enums.SecurityLevel;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="USER_ACCOUNT")
public class User {

    @Id
    @SequenceGenerator(name="User_ID_SEQ", sequenceName = "User_ID_SEQ",allocationSize=1)
    @GeneratedValue(strategy=SEQUENCE, generator="User_ID_SEQ")
    @Column(name="User_ID")
    private long userId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="PWORD")
    private String pword;

    @Column(name="SECURITY_LEVEL")
    private SecurityLevel securityLevel;

    public User(){}

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
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

    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }
    public void setSecurityLevel(SecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", securityLevel=" + securityLevel +
                '}';
    }
}
