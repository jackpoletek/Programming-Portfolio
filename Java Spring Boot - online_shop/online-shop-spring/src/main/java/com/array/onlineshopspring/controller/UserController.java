package com.array.onlineshopspring.controller;

import com.array.onlineshopspring.dto.AppUserDTO;
import com.array.onlineshopspring.payload.ApiResponse;
import com.array.onlineshopspring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@ResponseBody
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200")
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @GetMapping(value = "/for-admin")
    public String forAdmin() {
        return "URL accessible only to ADMIN";
    }
    @GetMapping(value = "/for-user")
    public String forUser() {
        return "URL accessible only to USER";
    }

    @ResponseBody
    @PostMapping(value = "/new-user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUserDTO> addUser(@RequestBody AppUserDTO userDTO) {
        AppUserDTO newUser = userService.addUser(userDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/all-users")
    public ResponseEntity<List<AppUserDTO>> getAllUsers() {
        List<AppUserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/by-id/{userId}")
    public ResponseEntity<AppUserDTO> getUserById(@PathVariable("userId") Integer userId) {
        AppUserDTO user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/by-username/{username}")
    public ResponseEntity<AppUserDTO> getUserByUserName(@PathVariable("username") String username) {
        AppUserDTO user = userService.getUserByUserName(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/by-order/{orderId}")
    public ResponseEntity<List<AppUserDTO>> getUsersByOrderId(@PathVariable("orderId") Integer orderId) {
        List<AppUserDTO> users = userService.getUsersByOrderId(orderId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{userId}")
    public ResponseEntity<AppUserDTO> updateUser(@PathVariable("userId") Integer userId, @Valid @RequestBody AppUserDTO user) {
        AppUserDTO updatedUser = userService.updateUser(user, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }
}
