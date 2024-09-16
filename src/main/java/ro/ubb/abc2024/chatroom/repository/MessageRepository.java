package ro.ubb.abc2024.chatroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.ubb.abc2024.chatroom.domain.Message;
import ro.ubb.abc2024.user.User;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    //TODO: check if these work as needed!!!

    @Query(value = "FROM Message m WHERE m.recipient.id = :recipientId AND m.sender.id = :senderId")
    List<Message> findMessagesFromSelectedUsers(Long recipientId, Long senderId);

    @Query(value = "FROM Message m WHERE m.chatroom.id = :chatRoomId")
    List<Message> findChatMessagesByChatroomId(Long chatRoomId);
}