package domain;


import java.util.ArrayList;
import java.util.List;



public class Chat {
    private Person from;
    private Person to;
    private List<Message> messages ;


    public Chat(Person from, Person to) {
        setFrom(from);
        setTo(to);
        this.messages = new ArrayList<>();
    }
    public Chat(){

    }
    public Person getFrom() {
        return from;
    }

    public void setFrom(Person from) {
        this.from = from;
    }

    public Person getTo() {
        return to;
    }

    public void setTo(Person to) {
        this.to = to;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message b){
        messages.add(b);
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
