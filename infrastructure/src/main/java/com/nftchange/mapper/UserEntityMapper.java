package com.nftchange.mapper;

import com.nftchange.domain.User;
import com.nftchange.persistence.entity.UserEntity;

public class UserEntityMapper {

    public static User toDomain(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setLogin(userEntity.getLogin());
        user.setPassword(userEntity.getPassword());
        user.setPinCode(userEntity.getPinCode());
        user.setActive(userEntity.isActive());
//        user.setWallet(WalletEntityMapper.toDomain(userEntity.getWallet()));
        user.setCreatedDate(userEntity.getCreatedDate());
        user.setCreatedBy(userEntity.getCreatedBy());
        user.setLastModifiedDate(userEntity.getLastModifiedDate());
        user.setDeleted(userEntity.isDeleted());
        return user;
    }

    public static UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        userEntity.setPinCode(user.getPinCode());
        userEntity.setActive(user.isActive());
//        userEntity.setWallet(WalletEntityMapper.toEntity(user.getWallet()));
        userEntity.setCreatedDate(user.getCreatedDate());
        userEntity.setCreatedBy(user.getCreatedBy());
        userEntity.setLastModifiedDate(user.getLastModifiedDate());
        userEntity.setDeleted(user.isDeleted());
        return userEntity;
    }
}
