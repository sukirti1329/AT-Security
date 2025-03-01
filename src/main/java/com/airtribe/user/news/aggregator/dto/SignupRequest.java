package com.airtribe.user.news.aggregator.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignupRequest {

    @NotBlank(message = "Name cannot be blank")
    private String userName;

    @Email(message = "Email cannot be blank")
    @NotBlank(message = "Email cannot be blank")
    private String emailId;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, max = 20, message = "Password must be in between 6 to 20 length")
    private String password;

    //TODO: We will write verification logic later on
    @Builder.Default
    private Boolean isEnabled = false;
}
