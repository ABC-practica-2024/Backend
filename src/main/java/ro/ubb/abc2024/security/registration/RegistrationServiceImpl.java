package ro.ubb.abc2024.security.registration;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ro.ubb.abc2024.utils.email.EmailService;
import ro.ubb.abc2024.security.token.TokenService;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.utils.file.FileService;


@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final FileService fileService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final TokenService tokenService;


    @Override
    @Transactional
    public void addUser(User user, MultipartFile file) {
        var newUser = this.userRepository.save(User.builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .uniqueKey(user.getUniqueKey())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .build());
        var profilePicturePath = this.fileService.saveFile(file, newUser.getUsername());
        newUser.setImagePath(profilePicturePath);
        this.userRepository.save(newUser);
        var token = this.tokenService.createToken(newUser, 60);

        String htmlContent = "<html>" +
                "<head>" +
                "<style>" +
                "body {font-family: Arial, sans-serif; margin: 20px;}" +
                "h1 {color: #4CAF50;}" +
                "p {font-size: 16px;}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<h1>Welcome to Our Service!</h1>" +
                "<p>Thank you for signing up. We're excited to have you on board.</p>" +
                "<p>Please click the link below to activate your account:</p>" +
                "<p>" + token.getToken() + "</p>" +
                "<p>The token will be available for 60 minutes. </p>" +
                "<p>Best regards,<br/>The Team</p>" +
                "</body>" +
                "</html>";

        emailService.sendHtmlEmail(newUser.getEmail(), "Registration", htmlContent);
    }

    @Override
    @Transactional
    public boolean enableUser(String token) {
        var retrievedToken = this.tokenService.getToken(token);
        if (this.tokenService.isTokenValid(retrievedToken)) {
            var user = this.userRepository.findById(retrievedToken.getUser().getId()).orElseThrow(() -> new EntityNotFoundException("No user associated with token."));
            user.setEnabled(true);
            userRepository.save(user);
            this.tokenService.removeToken(retrievedToken);
            return true;
        } else {
            throw new CredentialsExpiredException("Token is expired.");
        }
    }

    @Override
    public void removeUser(User user) {
        this.userRepository.delete(user);
    }

    @Transactional
    @Override
    public boolean updateUser(User user) {
        this.userRepository.findByUsername(user.getUsername()).ifPresentOrElse(fetchedUser -> {

                },
                () -> {
                    throw new EntityNotFoundException("User not found");
                });

        return true;
    }
}
