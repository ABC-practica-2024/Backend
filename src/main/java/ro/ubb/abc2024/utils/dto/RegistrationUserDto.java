package ro.ubb.abc2024.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.ubb.abc2024.user.Role;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RegistrationUserDto {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
}
