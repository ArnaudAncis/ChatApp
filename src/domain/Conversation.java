package domain;

import java.util.ArrayList;
import java.util.List;

public class Conversation {

    private Person user1;
    private Person user2;
    private List<Message> messages;

    public Conversation(Person user1, Person user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.messages = new ArrayList<>();
    }

    public Person getUser1() {
        return user1;
    }

    public void setUser1(Person user1) {
        this.user1 = user1;
    }

    public Person getUser2() {
        return user2;
    }

    public void setUser2(Person user2) {
        this.user2 = user2;
    }

    public List<Message> getBerichten() {
        return messages;
    }

    public void setBerichten(List<Message> berichten) {
        this.messages = berichten;
    }

    public void addBericht(Message m){
        messages.add(m);
    }
}
