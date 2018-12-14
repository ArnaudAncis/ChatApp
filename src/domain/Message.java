package domain;


public class Message {


    private String text;
    private Person ontvanger;
    private Person sender;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Person getOntvanger() {
        return ontvanger;
    }

    public void setOntvanger(Person person) {
        this.ontvanger = person;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Message(String text, Person ontvanger, Person sender) {
        this.text = text;
        this.ontvanger = ontvanger;
        this.sender = sender;
    }



}
