package com.array.onlineshopspring.service;

import com.array.onlineshopspring.dto.AppUserDTO;

import java.util.List;

public interface UserService {
	
//    UserDetails loadUserByUsername(String email);
    void initRoleAndUser();
    AppUserDTO addUser(AppUserDTO userDTO);
    List<AppUserDTO> getAllUsers();
    AppUserDTO getUserById(Integer userId);
    AppUserDTO getUserByUserName(String username);
    List<AppUserDTO> getUsersByOrderId(Integer orderId);
    AppUserDTO updateUser(AppUserDTO userDTO, Integer userId);
    void deleteUser(Integer userId);
//    Page<User> getUsersOnPage(UserPage userPage);
}
