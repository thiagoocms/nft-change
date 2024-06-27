package com.nftchange.client;

import com.nftchange.dto.AuthorizationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AuthorizerClient", url = "https://util.devi.tools/api/v2")
public interface AuthorizerClient {

    @GetMapping("/authorize")
    ResponseEntity<AuthorizationDTO> checkAuthorization();

}