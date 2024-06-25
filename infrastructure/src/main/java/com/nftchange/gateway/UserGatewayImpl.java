package com.nftchange.gateway;

import com.nftchange.domain.User;
import com.nftchange.mapper.UserEntityMapper;
import com.nftchange.persistence.entity.UserEntity;
import com.nftchange.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;

    @Autowired
    public UserGatewayImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) throws Throwable {
        UserEntity userEntity = UserEntityMapper.toEntity(user);
        user = UserEntityMapper.toDomain(this.userRepository.save(userEntity));
        return user;
    }

    @Override
    public User findById(Long id) {
        UserEntity userEntity = this.userRepository.findFirstByIdAndDeletedIsFalse(id);
        return UserEntityMapper.toDomain(userEntity);
    }

    @Override
    public User update(User user) throws Throwable {
        UserEntity userEntity = UserEntityMapper.toEntity(user);
        user = UserEntityMapper.toDomain(this.userRepository.save(userEntity));
        return user;
    }

    @Override
    public void deleteById(Long id) {
        UserEntity userEntity = this.userRepository.findFirstByIdAndDeletedIsFalse(id);
        userEntity.setDeleted(Boolean.TRUE);
        this.userRepository.save(userEntity);
    }
}
