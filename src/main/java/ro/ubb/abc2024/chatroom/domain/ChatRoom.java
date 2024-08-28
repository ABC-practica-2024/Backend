package ro.ubb.abc2024.chatroom.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.ubb.abc2024.arheo.domain.Artifact;
import ro.ubb.abc2024.user.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat_rooms")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Chat type cannot be null")
    @Enumerated(EnumType.STRING)
    private ChatType chatType;
    @ManyToOne
    @JoinColumn(name = "mainArcheologist_id", nullable = false)
    private User mainArchaeologist;
    @ManyToOne
    @JoinColumn(name = "otherParty_id", nullable = false)
    private User otherParty;
    @ManyToOne
    @JoinColumn(name = "artifact_id", nullable = false)
    private Artifact artifact;

}
