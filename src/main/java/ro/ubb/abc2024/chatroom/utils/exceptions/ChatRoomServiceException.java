package ro.ubb.abc2024.chatroom.utils.exceptions;

import ro.ubb.abc2024.chatroom.service.ChatRoomService;

public class ChatRoomServiceException extends RuntimeException{

    public ChatRoomServiceException(String message) {super(message);}

    public ChatRoomServiceException(String message, Throwable cause) {super(message, cause);}
}
