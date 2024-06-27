package com.nftchange.controller;


import com.nftchange.constants.AppConstants;
import com.nftchange.domain.User;
import com.nftchange.dto.UserActiveDTO;
import com.nftchange.dto.UserAddBalanceDTO;
import com.nftchange.dto.UserDTO;
import com.nftchange.mapper.UserDTOMapper;
import com.nftchange.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = AppConstants.PATH + AppConstants.API + AppConstants.V1 + "/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserByIdUseCase updateUserByIdUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final DeleteUserByIdUseCase deleteUserByIdUseCase;
    private final IsActiveUserUseCase isActiveUserUseCase;
    private final ActiveUserUseCase activeUserUseCase;
    private final AddBalanceByUserUseCase addBalanceByUserUseCase;

    @Autowired
    public UserController(CreateUserUseCase createUserUseCase, UpdateUserByIdUseCase updateUserByIdUseCase, FindUserByIdUseCase findUserByIdUseCase, DeleteUserByIdUseCase deleteUserByIdUseCase, IsActiveUserUseCase isActiveUserUseCase, ActiveUserUseCase activeUserUseCase, AddBalanceByUserUseCase addBalanceByUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserByIdUseCase = updateUserByIdUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.deleteUserByIdUseCase = deleteUserByIdUseCase;
        this.isActiveUserUseCase = isActiveUserUseCase;
        this.activeUserUseCase = activeUserUseCase;
        this.addBalanceByUserUseCase = addBalanceByUserUseCase;
    }

    @PostMapping
    @Transactional
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

    @GetMapping("/is-active")
    public ResponseEntity<Void> isActive(@RequestParam(name = "login", required = true) String login) throws Throwable {

        isActiveUserUseCase.isActive(login);

        return ResponseEntity
                .ok().build();
    }

    @PostMapping("/active")
    public ResponseEntity<Void> activeAccount(@RequestBody UserActiveDTO dto) {

        activeUserUseCase.active(dto.getLogin(), dto.getPinCode());

        return ResponseEntity
                .ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addBalance(@RequestBody UserAddBalanceDTO dto) {

        addBalanceByUserUseCase.add(dto.getUserId(), dto.getValue());

        return ResponseEntity
                .ok().build();
    }
}
