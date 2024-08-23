package ro.ubb.abc2024.user.userRoleRequest;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.ubb.abc2024.user.Role;
import ro.ubb.abc2024.user.User;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userolerequests")
public class UserRoleRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    @NotNull
    private LocalDateTime timeSent;
    private LocalDateTime timeResolved;
    @ManyToOne
    @JoinColumn(name= "user_id", nullable = false)
    private User user;
}
