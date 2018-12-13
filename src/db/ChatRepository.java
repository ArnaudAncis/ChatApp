package db;

import domain.Chat;
import java.util.List;

public interface ChatRepository {

    public abstract void addChat(Chat c);

    public abstract List<Chat> getChats();

    public abstract Chat getChat(Chat c);
}
