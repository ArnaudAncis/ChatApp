package db;

import java.util.List;

import domain.Message;

public interface MessageRepository {

    public abstract void addMessage(Message m);

    public abstract List<Message> getMessages();
}
