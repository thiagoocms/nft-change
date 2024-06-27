package com.nftchange.mapper;

import com.nftchange.domain.User;
import com.nftchange.dto.UserDTO;

public class UserDTOMapper {

    public static User toDomain(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setLogin(userDTO.getLogin());
        user.setWallet(WalletDTOMapper.toDomain(userDTO.getWallet()));
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public static UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setLogin(user.getLogin());
        userDTO.setWallet(WalletDTOMapper.toDto(user.getWallet()));
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
