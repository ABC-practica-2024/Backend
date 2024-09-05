/*
package ro.ubb.abc2024;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.ubb.abc2024.user.*;
import ro.ubb.abc2024.user.userRoleRequest.RequestStatus;
import ro.ubb.abc2024.user.userRoleRequest.UserRoleRequest;
import ro.ubb.abc2024.user.userRoleRequest.UserRoleRequestRepository;
import ro.ubb.abc2024.user.userRoleRequest.UserRoleRequestService;
import ro.ubb.abc2024.utils.exception.UserRoleRequestException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RoleRequestImplTest {

    @Autowired
    private UserRoleRequestRepository repository;
    @Autowired
    private UserRoleRequestService service;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeAll
    void setUp() throws Exception {

        User userAdmin = new User();
        userAdmin.setUsername("admin");
        userAdmin.setPassword(passwordEncoder.encode("Adminpassword1!"));
        userAdmin.setEmail("admin@gmail.com");
        userAdmin.setFirstName("firstName");
        userAdmin.setLastName("lastName");
        userAdmin.setRole(Role.ADMIN);
        userAdmin.setEnabled(true);
        userRepository.save(userAdmin);

        User userGuest = new User();
        userGuest.setUsername("guest");
        userGuest.setPassword(passwordEncoder.encode("Guestpassword1!"));
        userGuest.setEmail("guest@gmail.com");
        userGuest.setFirstName("firstName");
        userGuest.setLastName("lastName");
        userGuest.setRole(Role.GUEST);
        userGuest.setEnabled(true);
        userRepository.save(userGuest);

        System.out.println(userRepository.findAll());
    }

    @Test
    void addUserRoleRequestSuccessfully() throws Exception {
        var userRoleRequest = new UserRoleRequest();
        userRoleRequest.setRole(Role.ARH);
        userRoleRequest.setUser(userRepository.findByUsername("guest").get());
        userRoleRequest.setRequestStatus(RequestStatus.PENDING);
        userRoleRequest.setTimeSent(LocalDateTime.now());
        UserRoleRequest userRoleRequestResult =  service.addUserRoleRequest(userRoleRequest);

        assertTrue(repository.findById(userRoleRequestResult.getId()).isPresent());
        repository.deleteById(userRoleRequestResult.getId());
    }

    @Test
    void addUserRoleRequestViolatesConstraintThrowsUserRoleRequestException() {
        var userRoleRequest = new UserRoleRequest();
        userRoleRequest.setRole(Role.ARH);
        userRoleRequest.setUser(userRepository.findByUsername("guest").get());
        userRoleRequest.setRequestStatus(RequestStatus.PENDING);
        userRoleRequest.setTimeSent(null);

        assertThrows(UserRoleRequestException.class, () -> service.addUserRoleRequest(userRoleRequest));
    }

    @Test
    void getUserRoleRequestByIdSuccessfully() throws Exception {
        var userRoleRequest = new UserRoleRequest();
        userRoleRequest.setRole(Role.ARH);
        userRoleRequest.setUser(userRepository.findByUsername("guest").get());
        userRoleRequest.setRequestStatus(RequestStatus.PENDING);
        userRoleRequest.setTimeSent(LocalDateTime.parse("2024-08-23T14:34"));
        UserRoleRequest userRoleRequestResult =  service.addUserRoleRequest(userRoleRequest);
        var result = service.getUserRoleRequest(userRoleRequestResult.getId());

        assertEquals(result, userRoleRequestResult);
        repository.deleteById(userRoleRequestResult.getId());
    }

    @Test
    void getPendingUserRoleRequestsSuccessfully() throws Exception {
        var userRoleRequest = new UserRoleRequest();
        userRoleRequest.setRole(Role.ARH);
        userRoleRequest.setUser(userRepository.findByUsername("guest").get());
        userRoleRequest.setRequestStatus(RequestStatus.PENDING);
        userRoleRequest.setTimeSent(LocalDateTime.parse("2024-08-23T14:34"));
        UserRoleRequest userRoleRequestResult =  service.addUserRoleRequest(userRoleRequest);
        var result = service.getPendingUserRoleRequests();

        assertFalse(result.isEmpty());
        assertTrue(result.contains(userRoleRequest));
        repository.deleteById(userRoleRequestResult.getId());
    }

    @Test
    void resolveUserRoleRequestSuccessfully() throws Exception {
        var userRoleRequest = new UserRoleRequest();
        userRoleRequest.setRole(Role.ARH);
        userRoleRequest.setUser(userRepository.findByUsername("guest").get());
        userRoleRequest.setRequestStatus(RequestStatus.PENDING);
        userRoleRequest.setTimeSent(LocalDateTime.parse("2024-08-23T14:34"));
        UserRoleRequest userRoleRequestResult =  service.addUserRoleRequest(userRoleRequest);
        service.resolvePendingUserRoleRequest(userRoleRequestResult.getId(), RequestStatus.ACCEPTED);
        var result = service.getUserRoleRequest(userRoleRequestResult.getId());

        assertEquals(result.getRequestStatus(), RequestStatus.ACCEPTED);
        assertEquals(result.getRole(), userRepository.findByUsername("guest").get().getRole());
        repository.deleteById(userRoleRequestResult.getId());
    }

    @Test
    void deleteUserRoleRequestSuccessfully() throws Exception {
        var userRoleRequest = new UserRoleRequest();
        userRoleRequest.setRole(Role.ARH);
        userRoleRequest.setUser(userRepository.findByUsername("guest").get());
        userRoleRequest.setRequestStatus(RequestStatus.PENDING);
        userRoleRequest.setTimeSent(LocalDateTime.parse("2024-08-23T14:34"));
        UserRoleRequest userRoleRequestResult =  service.addUserRoleRequest(userRoleRequest);
        service.deleteUserRoleRequest(userRoleRequestResult.getId());

        assertFalse(repository.findById(userRoleRequestResult.getId()).isPresent());
    }

    @AfterAll
    void cleanUp() throws Exception {
        userRepository.deleteById(userRepository.findByUsername("admin").get().getId());
        userRepository.deleteById(userRepository.findByUsername("guest").get().getId());
    }
}
*/