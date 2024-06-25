package com.nftchange.controller;


import com.nftchange.constants.AppConstants;
import com.nftchange.domain.User;
import com.nftchange.dto.UserDTO;
import com.nftchange.mapper.UserDTOMapper;
import com.nftchange.user.CreateUserUseCase;
import com.nftchange.user.DeleteUserByIdUseCase;
import com.nftchange.user.FindUserByIdUseCase;
import com.nftchange.user.UpdateUserByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = AppConstants.PATH + AppConstants.API + AppConstants.V1 + "/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserByIdUseCase updateUserByIdUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final DeleteUserByIdUseCase deleteUserByIdUseCase;

    @Autowired
    public UserController(CreateUserUseCase createUserUseCase, UpdateUserByIdUseCase updateUserByIdUseCase, FindUserByIdUseCase findUserByIdUseCase, DeleteUserByIdUseCase deleteUserByIdUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserByIdUseCase = updateUserByIdUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.deleteUserByIdUseCase = deleteUserByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) throws Throwable {

        User user = this.createUserUseCase.create(UserDTOMapper.toDomain(dto));
        dto = UserDTOMapper.toDto(user);

        return ResponseEntity
                .created(URI.create("/users"))
                .body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO dto) throws Throwable {

        User user = this.updateUserByIdUseCase.updateById(id, UserDTOMapper.toDomain(dto));
        dto = UserDTOMapper.toDto(user);

        return ResponseEntity
                .ok()
                .body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) throws Throwable {

        UserDTO userDTO = UserDTOMapper.toDto(this.findUserByIdUseCase.findById(id));

        return ResponseEntity
                .ok()
                .body(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Throwable {

        deleteUserByIdUseCase.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
