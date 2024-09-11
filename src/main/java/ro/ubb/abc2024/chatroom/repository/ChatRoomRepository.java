package ro.ubb.abc2024.chatroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.ubb.abc2024.chatroom.domain.ChatRoom;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    //TODO: check if it works fine

    @Query(value = "FROM ChatRoom c WHERE c.mainArchaeologist.id = :mainArheoId AND c.otherParty.id = :otherPartId")
    Optional<ChatRoom> findChatRoomByMainArchaeologistAndOtherParty(Long mainArheoId, Long otherPartId);
}
