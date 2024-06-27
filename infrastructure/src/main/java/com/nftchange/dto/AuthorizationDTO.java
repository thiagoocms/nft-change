package com.nftchange.dto;

import com.nftchange.enums.AuthorizationStatusEnum;

public class AuthorizationDTO {

    private AuthorizationStatusEnum status;

    public AuthorizationDTO() {
    }

    public AuthorizationDTO(AuthorizationStatusEnum status) {
        this.status = status;
    }

    public AuthorizationStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AuthorizationStatusEnum status) {
        this.status = status;
    }
}
