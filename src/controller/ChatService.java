package controller;

import db.ChatRepository;
import db.ChatRepositoryStub;
import domain.Chat;
import domain.Conversation;
import domain.Message;
import domain.Person;

import java.util.ArrayList;
import java.util.List;

public class ChatService {

    private PersonService personService;


    private MessageService messageService;
    private ChatRepository chatRepository = new ChatRepositoryStub();
    private List<Conversation> conversations = new ArrayList<>();


    public ChatService () {
        personService = new PersonService();
        messageService = new MessageService();

    }

    public void addChat(Chat c){
        chatRepository.addChat(c);
    }
    public List<Chat> getChats(){
        return chatRepository.getChats();
    }

    public Conversation newConversation(Person p, Person p1){
        Conversation c = new Conversation(p,p1);
        return c;
    }
    public void addConversation(Conversation c){
        conversations.add(c);
    }
    public List<Conversation> getConversations(){
        return conversations;
    }

    public Conversation getConversation(Person p, Person p2){
        for (int i = 0; i!=this.conversations.size(); i++){
            if((this.conversations.get(i).getUser1() == p && this.conversations.get(i).getUser2() == p2)
                    ||this.conversations.get(i).getUser2() == p && this.conversations.get(i).getUser1() == p2 ){
                return conversations.get(i);
            }
        }
        return null;
    }
    public List<Message> getAllBerichten(){
        List<Message> result = new ArrayList<>();
        for (int i = 0; i!=conversations.size(); i++){
            result.addAll(conversations.get(i).getBerichten());
        }
        return result;
    }
    public List<Message> getAllBerichtenFromUser(Person p){
        List<Message> result = new ArrayList<>();
        for (int i = 0; i!=conversations.size(); i++){
            if(conversations.get(i).getUser1() == p || conversations.get(i).getUser2() == p){
                result.addAll(conversations.get(i).getBerichten());
            }
        }
        return result;
    }


    public Chat getChat(Chat c){
        return chatRepository.getChat(c);
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }


    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }


}
