package db;

import java.util.ArrayList;
import java.util.List;

import domain.Message;

public class MessageRepositoryInMemory implements MessageRepository {
    List<Message> messages;

    public MessageRepositoryInMemory(){
        this.messages = new ArrayList<Message>();
    }

    public void addMessage(Message m){
        this.messages.add(m);
        System.out.println("Message saved");
    }

    public List<Message> getMessages() {
        return messages;
    }

}
