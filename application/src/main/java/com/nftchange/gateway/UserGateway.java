package com.nftchange.gateway;

import com.nftchange.domain.User;

public interface UserGateway {
    User create(User user) throws Throwable;
    User findById(Long id);
    User update(User user) throws Throwable;
    void deleteById(Long id);
    User findByEmail(String email);
    Long countByLogin(String login);
    User findByLogin(String login);

}
