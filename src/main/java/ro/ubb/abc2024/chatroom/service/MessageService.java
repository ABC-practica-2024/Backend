package ro.ubb.abc2024.chatroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.chatroom.domain.Message;
import ro.ubb.abc2024.chatroom.repository.MessageRepository;

import java.util.List;

import static java.lang.Long.parseLong;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> findChatMessagesFromSelectedUser(String senderId, String recipientId){
        return messageRepository.findMessagesFromSelectedUsers(parseLong(senderId), parseLong(recipientId));
    }

    public List<Message> findChatMessagesByChatroomId(String chatroomId){
        return messageRepository.findChatMessagesByChatroomId(parseLong(chatroomId));
    }


}
