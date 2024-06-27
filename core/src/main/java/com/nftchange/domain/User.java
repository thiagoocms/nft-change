package com.nftchange.domain;

import com.nftchange.exception.BadRequestException;
import com.nftchange.util.EmailUtil;

public class User extends AbstractAuditing {
    private Long id;
    private String name;
    private String email;
    private Wallet wallet;
    private String login;
    private String password;
    private String pinCode;
    private boolean active;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, String email, Wallet wallet, String login, String password, String pinCode, boolean active) {
        this.id = id;
        this.name = name;
        this.email = isEmail(email);
        this.wallet = wallet;
        this.login = login;
        this.password = password;
        this.pinCode = pinCode;
        this.active = active;
    }

    public void from(User user) {
        this.name = user.getName() != null ? user.getName() : this.name;
        this.email = user.getEmail() != null ? isEmail(user.getEmail()) : this.email;
        this.login = user.getLogin() != null ? user.getLogin() : this.login;
        this.password = user.getPassword() != null ? user.getPassword() : this.password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new BadRequestException("O campo nome é obrigatorio.");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = isEmail(email);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null) {
            throw new BadRequestException("O campo login é obrigatorio.");
        }
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            throw new BadRequestException("O campo senha é obrigatorio.");
        }
        this.password = password;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private String isEmail(String email) {
        if (email == null || !EmailUtil.isItEmail(email)) {
            throw new BadRequestException("Email invalido");
        }
        return email;
    }
}
