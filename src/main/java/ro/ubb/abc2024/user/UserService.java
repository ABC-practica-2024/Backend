package ro.ubb.abc2024.user;

import org.springframework.web.multipart.MultipartFile;
import ro.ubb.abc2024.utils.dto.ChangePasswordDto;
import ro.ubb.abc2024.utils.dto.ChangeRoleDto;
import ro.ubb.abc2024.utils.dto.EnableUserDto;
import ro.ubb.abc2024.utils.dto.PasswordResetDto;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(long id);
    List<User> getUsersByRole(Role role);
    List<User> getUsers();
    User getUser(String username);
    User getUser(long id);
    void changePassword(ChangePasswordDto changePasswordDto);
    void changeRole(ChangeRoleDto changeRoleDto);
    void enableUser(EnableUserDto enableUserDto);

}
