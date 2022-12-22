//package com.array.onlineshopspring.service.serviceimpl;
//
//import com.array.onlineshopspring.constants.UserRole;
//import com.array.onlineshopspring.exception.ResourceNotFoundException;
//import com.array.onlineshopspring.model.AppUser;
//import com.array.onlineshopspring.request.RegistrationRequest;
//import com.array.onlineshopspring.service.RegistrationService;
//import com.array.onlineshopspring.service.UserService;
//import com.array.onlineshopspring.validation.EmailValidator;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RegistrationServiceImpl implements RegistrationService {
//
//    private final UserService userService;
//    private final EmailValidator emailValidator;
//
//    public RegistrationServiceImpl(UserService userService, EmailValidator emailValidator) {
//        this.userService = userService;
//        this.emailValidator = emailValidator;
//    }
//
//    @Override
//    public AppUser registerUser(RegistrationRequest request) {
//        String email = request.getEmail();
//        boolean isValidEmail = emailValidator.test(email);
//
//        if (!isValidEmail) {
//            throw new ResourceNotFoundException(email);
//        }
//
//        return userService.addUser(
//                new AppUser(
//                        request.getFirstName(),
//                        request.getLastName(),
//                        request.getEmail(),
//                        request.getLogin(),
//                        request.getUserPassword(),
//                        UserRole.USER
//                )
//        );
//    }
//
//    @Override
//    public String confirmToken(String token) {
//        return null;
//    }
//}
