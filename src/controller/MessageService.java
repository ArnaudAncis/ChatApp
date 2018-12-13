package controller;

import java.util.List;

import db.MessageRepositoryInMemory;
import db.MessageRepository;
import domain.Message;

public class MessageService {
    private MessageRepository messageRepository = new MessageRepositoryInMemory();

    public void addMessage(Message m) {
        messageRepository.addMessage(m);
    }

    public List<Message> getMessages() {
        return messageRepository.getMessages();
    }
}
