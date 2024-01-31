package com.chat.web.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "avatar_path")
    private String avatarPath ;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "ENUM('Male', 'Female', 'Unknown') DEFAULT 'Unknown'")
    private Gender gender = Gender.Unknown;

    @Column(name = "region")
    private String region;

    @Column(name = "language")
    private String language;

    @Column(name = "registration_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp registrationTime;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    @Column(name = "friend_request_approval", columnDefinition = "CHAR(1) DEFAULT 'Y'")
    private char friendRequestApproval = 'Y';

    @Column(name = "signature", columnDefinition = "TEXT")
    private String signature;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Timestamp getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Timestamp registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public char getFriendRequestApproval() {
        return friendRequestApproval;
    }

    public void setFriendRequestApproval(char friendRequestApproval) {
        this.friendRequestApproval = friendRequestApproval;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "User{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", nickName='" + nickName + '\'' +
            ", avatarPath='" + avatarPath + '\'' +
            ", gender=" + gender +
            ", region='" + region + '\'' +
            ", language='" + language + '\'' +
            ", registrationTime=" + registrationTime +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", email='" + email + '\'' +
            ", country='" + country + '\'' +
            ", friendRequestApproval=" + friendRequestApproval +
            ", signature='" + signature + '\'' +
            '}';
    }
}

enum Gender {
    Male,
    Female,
    Unknown
}
