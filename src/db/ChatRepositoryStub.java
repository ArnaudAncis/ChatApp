package db;

import domain.Chat;
import domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatRepositoryStub implements ChatRepository {
    private Map<String, Chat> chats = new HashMap<String, Chat>();

    @Override
    public void addChat(Chat c) {
       chats.put(c.getFrom().getFirstName() + c.getTo().getFirstName(), c);
    }

    @Override
    public List<Chat> getChats() {
       return new ArrayList<Chat>(chats.values());
    }

    @Override
    public Chat getChat(Chat c) {

        for (Map.Entry<String, Chat> entry : chats.entrySet())
        {
            if (entry.getValue().getFrom().equals(c.getFrom())
                    && entry.getValue().getTo().equals(c.getTo())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
