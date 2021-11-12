package com.example.in100gramm.payload.Request;

import com.example.in100gramm.Annotations.PasswordMatches;
import com.example.in100gramm.Annotations.ValidEmail;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class SignUpRequest {
    @Email(message = "It should be email format")
    @NotBlank(message = "User email is required")
    @ValidEmail
    private String email;

    @NotEmpty(message = "Please enter your name")
    private String firstname;

    @NotEmpty(message = "Please enter your lastname")
    private String lastname;

    @NotEmpty(message = "Please enter your nickname")
    private String username;

    @NotEmpty(message = "Please enter yout password")
    @Size(min = 5, max = 58)
    private String password;

    @NotEmpty(message = "Please enter your password again")
    private String confirmPassword;

}
