package com.array.onlineshopspring.service.serviceimpl;

import com.array.onlineshopspring.constants.UserRole;
import com.array.onlineshopspring.dto.AppUserDTO;
import com.array.onlineshopspring.exception.ResourceNotFoundException;
import com.array.onlineshopspring.model.AppUser;
import com.array.onlineshopspring.model.UserOrder;
import com.array.onlineshopspring.repository.OrderRepository;
import com.array.onlineshopspring.repository.UserRepository;
import com.array.onlineshopspring.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
	
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, OrderRepository orderRepository,
                           ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initRoleAndUser() {
        UserRole adminRole = UserRole.admin;
        UserRole userRole = UserRole.user;

        AppUser admin = new AppUser();
        admin.setFirstName("Admin");
        admin.setLastName("admin");
        admin.setEmail("admin@admin.com");
        admin.setUsername("leader");
        admin.setUserPassword(getEncodedPassword("*admin*"));
        admin.setUserRole(adminRole);
        userRepository.save(admin);

        AppUser user = new AppUser();
        user.setFirstName("User");
        user.setLastName("user");
        user.setEmail("user@user.com");
        user.setUsername("follower");
        user.setUserPassword(getEncodedPassword("*user*"));
        user.setUserRole(userRole);
        userRepository.save(user);
    }

    @Override
    public AppUserDTO addUser(AppUserDTO userDTO) {

        AppUser user = AppUser.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .username(userDTO.getUsername())
                .userPassword(userDTO.getUserPassword())
                .userRole(UserRole.user)
                .build();

        userRepository.save(user);

        return modelMapper.map(user, AppUserDTO.class);
    }

    @Override
    public List<AppUserDTO> getAllUsers() {
        List<AppUser> allUsers = userRepository.findAll();

        List<AppUserDTO> users = allUsers.stream()
                .map(it -> modelMapper.map(it, AppUserDTO.class)).toList();

        return users;
    }

    @Override
    public AppUserDTO getUserById(Integer userId) {
		
        AppUser user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));

        return modelMapper.map(user, AppUserDTO.class);
    }

    @Override
    public AppUserDTO getUserByUserName(String username) {
        Optional<AppUser> userDb = userRepository.findByUsername(username);
        AppUser user = null;

        if (userDb.isPresent()) {
            user = userDb.get();
        }

        return modelMapper.map(user, AppUserDTO.class);
    }

    @Override
    public List<AppUserDTO> getUsersByOrderId(Integer orderId) {
		
        List<UserOrder> orders = orderRepository.findAll();

        List<AppUser> allUsers = orders.stream()
                .filter(order -> Objects.equals(order.getOrderId(), orderId))
                .map(UserOrder::getUser)
                .toList();

        List<AppUserDTO> users = allUsers.stream()
                .map(it -> modelMapper.map(it, AppUserDTO.class)).toList();

        return users;
    }

    public List<AppUser> getUserByLastName() {
        List<AppUser> users = userRepository.findAll();

        return users.stream()
                .sorted(Comparator.comparing(AppUser::getLastName))
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDTO updateUser(AppUserDTO userDTO, Integer userId) {
		
        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setUserPassword(userDTO.getUserPassword());

        AppUser updatedUser = userRepository.save(user);

        return modelMapper.map(updatedUser, AppUserDTO.class);
    }

    @Override
    public void deleteUser(Integer userId) {
        AppUser user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);
    }

    private String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
	
    private AppUserDTO mapToDTO(AppUser user) {
        AppUserDTO userDTO = new AppUserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setUserPassword(user.getUserPassword());
//        userDTO.setUserRole(user.getUserRole());

        return userDTO;
    }
    private AppUser mapToEntity(AppUserDTO userDTO) {
        AppUser user = new AppUser();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setUserPassword(userDTO.getUserPassword());
//        user.setUserRole(userDTO.getUserRole());

        return user;
    }
}
