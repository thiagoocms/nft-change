package com.nftchange.validation;


import com.nftchange.domain.User;
import com.nftchange.exception.BadRequestException;
import com.nftchange.exception.ResourceNotFoundException;
import com.nftchange.gateway.UserGateway;

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

        // Valores que não podem ser Alterados
        toUpdateEntity.setCreatedBy(persistedEntity.getCreatedBy());
        toUpdateEntity.setCreatedDate(persistedEntity.getCreatedDate());

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

}