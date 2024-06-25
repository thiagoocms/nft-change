package com.nftchange.validation;


import com.nftchange.domain.User;
import com.nftchange.exception.BadRequestException;
import com.nftchange.exception.ResourceNotFoundException;
import com.nftchange.gateway.UserGateway;
import com.nftchange.util.EmailUtil;

import java.util.Objects;

public class UserValidation {

    private final UserGateway userGateway;

    public UserValidation(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public void checkOwnerFieldsToCreate(User user) {
        user.setId(null);
    }

    public User checkUpdateConsistence(Long id, User toUpdateEntity) throws Throwable {

        if (Objects.isNull(id) || Objects.isNull(toUpdateEntity.getId())) {
            throw new BadRequestException("400");
        }

        if (id.compareTo(toUpdateEntity.getId()) != 0) {
            throw new BadRequestException("400");
        }
        User persistedEntity = checkExistUser(id);

        persistedEntity.from(toUpdateEntity);

        return persistedEntity;
    }

    public User checkExistUser(Long id) {

        User user = userGateway.findById(id);
        if (Objects.isNull(user)) {
            throw new ResourceNotFoundException("Usuario não encontrado.");
        }

        return user;
    }

    public void checkExistByEmail(User user) {
        User persistUser = userGateway.findByEmail(user.getEmail());
        if (persistUser != null) {
            if (!persistUser.isActive()) {
                throw new BadRequestException("A conta com o e-mail " + EmailUtil.maskEmail(user.getEmail()) + " ja foi criada, você precisa ativa-la");
            }
            throw new BadRequestException("A conta com o e-mail " + EmailUtil.maskEmail(user.getEmail()) + " ja Existe");
        }
    }

    public void checkExistByLogin(User user) {
        Long count = this.userGateway.countByLogin(user.getLogin());
        if (count > 0) {
            throw new BadRequestException("O login " + user.getLogin() + " ja é usado.");
        }
    }

}