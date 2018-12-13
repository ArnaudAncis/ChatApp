package domain;

import com.google.gson.annotations.Expose;

public class Message {

    @Expose
    private String text;
    @Expose
    private Person person;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public Message(String text, Person person) {
        this.text = text;
        this.person = person;
    }



}
