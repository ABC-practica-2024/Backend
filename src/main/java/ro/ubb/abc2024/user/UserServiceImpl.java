package ro.ubb.abc2024.user;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ro.ubb.abc2024.utils.dto.ChangePasswordDto;
import ro.ubb.abc2024.utils.dto.ChangeRoleDto;
import ro.ubb.abc2024.utils.dto.EnableUserDto;
import ro.ubb.abc2024.utils.exception.PasswordMissmatchException;
import ro.ubb.abc2024.utils.exception.UserServiceException;
import ro.ubb.abc2024.utils.file.FileService;
import ro.ubb.abc2024.utils.validation.GenericValidator;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final FileService fileService;
    private final GenericValidator<User> validator;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User addUser(User user, MultipartFile file) {
        try {
            validator.validate(user);
            var imagePath = this.fileService.saveFile(file, user.getUsername());

            return this.userRepository.save(user);
        } catch (ConstraintViolationException ex){
            throw new UserServiceException(ex.getMessage());
        }
    }
    @Override
    @Transactional
    public User updateUser(User user) {
        var updatedUser = this.userRepository.findByUsername(user.getUsername()).orElseThrow(
                () -> new EntityNotFoundException(String.format("User with id %d, does not exist.", user.getId())
                ));
        updatedUser.setEmail(user.getEmail());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        try {
            validator.validate(user);
            return this.userRepository.save(updatedUser);
        } catch (ConstraintViolationException ex){
            throw new UserServiceException(ex.getMessage());
        }
    }

    @Override
    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        return this.userRepository.findAllByRole(role.name());
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUser(String username) {
       return this.userRepository
               .findByUsername(username)
               .orElseThrow(()->new EntityNotFoundException(String.format("User with username: %s, not found", username)));
    }

    @Override
    public User getUser(long id) {
        return this.userRepository
                .findById(id)
                .orElseThrow(
                        ()->new EntityNotFoundException(String.format("User with id: %d, not found", id))
                );
    }

    @Override
    @Transactional
    public void changePassword(ChangePasswordDto changePasswordDto) {
        var user = this.getUser(changePasswordDto.username());
        if (passwordEncoder.matches(changePasswordDto.oldPassword(), user.getPassword())){
            user.setPassword(passwordEncoder.encode(changePasswordDto.newPassword()));
            this.userRepository.save(user);
        } else {
            throw new PasswordMissmatchException("Current password is not correct.");
        }
    }

    @Override
    @Transactional
    public void changeRole(ChangeRoleDto changeRoleDto) {
        var user = this.getUser(changeRoleDto.username());
        user.setRole(Role.valueOf(changeRoleDto.role()));
        this.userRepository.save(user);
    }

    @Override
    @Transactional
    public void enableUser(EnableUserDto enableUserDto) {
        var user = this.getUser(enableUserDto.username());
        user.setEnabled(enableUserDto.isEnabled());
        this.userRepository.save(user);
    }
}
