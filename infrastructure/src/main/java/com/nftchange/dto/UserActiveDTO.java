package com.nftchange.dto;

import java.io.Serializable;

public class UserActiveDTO implements Serializable {

    private String login;
    private String pinCode;

    public UserActiveDTO() {
    }

    public UserActiveDTO(String login, String pinCode) {
        this.login = login;
        this.pinCode = pinCode;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
