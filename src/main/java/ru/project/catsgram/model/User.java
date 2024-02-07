package ru.project.catsgram.model;

import java.time.LocalDate;


public class User {

    private String email;
    private String nickname;
    private LocalDate birthdate;

    public User() {
        this.email = null;
        this.nickname = null;
        this.birthdate = null;
    }

    public User(String email, String nickname, LocalDate birthdate) {
        this.email = email;
        this.nickname = nickname;
        this.birthdate = birthdate;
    }

    public User(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = email.hashCode() * 13;
        return result;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

}
