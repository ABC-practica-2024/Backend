package ro.ubb.abc2024.user.userRoleRequest;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.utils.exception.UserRoleRequestException;
import ro.ubb.abc2024.utils.validation.GenericValidator;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserRoleRequestService {

    private final UserRoleRequestRepository repository;
    private final GenericValidator<UserRoleRequest> validator;
    private final UserRepository userRepository;

    public UserRoleRequest addUserRoleRequest(UserRoleRequest userRoleRequest){
        try {
            validator.validate(userRoleRequest);
            return repository.save(userRoleRequest);
        }
        catch (ConstraintViolationException e) {
            throw new UserRoleRequestException("UserRoleRequest with id " + userRoleRequest.getId() + " not valid");
        }
    }
    
    public List<UserRoleRequest> getUserRoleRequests() {
        return repository.findAll();
    }

     
    public List<UserRoleRequest> getPendingUserRoleRequests() {
        return repository.findPending();
    }

     
    public UserRoleRequest getUserRoleRequest(long id) {
        return repository.findById(id).orElseThrow(()->new EntityNotFoundException("UserRequest with id " + id + " not found"));
    }

     
    public void deleteUserRoleRequest(long id) {
        repository.deleteById(id);
    }

     
    public void resolvePendingUserRoleRequest(long id, RequestStatus requestStatus) {
        try {
            UserRoleRequest userRoleRequest = getUserRoleRequest(id);
            validator.validate(userRoleRequest);
            userRoleRequest.setRequestStatus(requestStatus);
            userRoleRequest.setTimeResolved(LocalDateTime.now());

            var user = userRoleRequest.getUser();
            user.setRole(userRoleRequest.getRole());

            userRepository.save(user);

            repository.save(userRoleRequest);
        }catch (ConstraintViolationException e) {
            throw new UserRoleRequestException("UserRoleRequest with id " + id + " not found");
        }
    }

}
