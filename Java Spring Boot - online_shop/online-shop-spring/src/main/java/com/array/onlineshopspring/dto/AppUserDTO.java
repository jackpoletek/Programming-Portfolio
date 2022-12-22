package com.array.onlineshopspring.dto;

import com.array.onlineshopspring.constants.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppUserDTO {
	
	private final String MANDATORY = "This field is mandatory";

    private Integer userId;
	
	@NotBlank(message = MANDATORY)
    private String firstName;
	
	@NotBlank(message = MANDATORY)
    private String lastName;
	
	@NotBlank(message = MANDATORY)
    private String email;
	
	@NotBlank(message = MANDATORY)
    private String username;
	
	@NotBlank(message = MANDATORY)
    private String userPassword;
	
    private UserRole userRole;

    @JsonManagedReference
    private List<UserOrderDTO> orders;
}
