package ro.ubb.abc2024.security.registration;

import org.springframework.web.multipart.MultipartFile;
import ro.ubb.abc2024.user.User;

public interface RegistrationService {
    void addUser(User user);

    boolean enableUser(String token);

    void removeUser(User user);

    boolean updateUser(User user);
}
