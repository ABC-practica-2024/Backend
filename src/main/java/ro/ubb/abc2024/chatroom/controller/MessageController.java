package ro.ubb.abc2024.chatroom.controller;

import org.apache.logging.log4j.util.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.chatroom.domain.ChatRoom;
import ro.ubb.abc2024.chatroom.domain.Message;
import ro.ubb.abc2024.chatroom.service.ChatRoomService;
import ro.ubb.abc2024.chatroom.service.MessageService;

import java.util.List;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping("${api.endpoint.base-url}/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ChatRoomService chatroomService;

    @GetMapping("/{senderId}/{recipientId}")
    public ResponseEntity<List<Message>> getChatMessages(@PathVariable String senderId,
                                                         @PathVariable String recipientId) {
        List<Message>messagesFromSenderRepicient = null;
        try{
            ChatRoom cr = chatroomService.findChatroomBySenderIdAndRecipientId(senderId, recipientId);

            if(cr!=null){
                messagesFromSenderRepicient = messageService.findChatMessagesByChatroomId(cr.getId().toString());
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new InternalException("Cannot find messages between sender "+senderId+" and recipient "+recipientId);
        }
        return new ResponseEntity<List<Message>>(messagesFromSenderRepicient, HttpStatus.OK);
    }

    @PutMapping("/seen")
    public ResponseEntity<Void> markMessagesAsSeen(@RequestBody List<Message> messages) {
        try {
            messageService.updateMessagesStatusToSeen(messages);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
