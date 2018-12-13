package controller;

import domain.Conversation;
import domain.Message;
import domain.Person;
import domain.Chat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaakChat extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Person p = (Person) request.getSession().getAttribute("user");
        String pe = request.getParameter("b");
        Person per = Controller.getInstance().getChatService().getPersonService().getPersonByName(pe);

        Conversation conversation = new Conversation(p,per);
        Controller.getInstance().getChatService().addConversation(conversation);


//        Chat zenderChat = p.getChatSessie(pe);
//        Chat ontvangerChat = per.getChatSessie(p.getFirstName());
//
//        if(zenderChat == null){
//            Chat chat = new Chat(p, per);
//            p.addChat(per.getFirstName(), chat);
//
//            System.out.println("chat met " + per.getFirstName() + " en " + p.getFirstName() + " gemaakt" );
//        }
//        else{
//            System.out.println("ni goed he");
//        }
//        if(ontvangerChat == null){
//            Chat chat = new Chat(p, per);
//            per.addChat(p.getFirstName(), chat);
//            System.out.println("chat met " + p.getFirstName() + " en " + per.getFirstName() + " gemaakt" );
//        }
//        else{
//            System.out.println("Godver");
//        }
//
//        Chat c = new Chat(p, per);
//        if(Controller.getInstance().getChatService().getChats().contains(c)){
//            System.out.println("bestaat al");
//            return "kekeke";
//        }
//        else {
//            Controller.getInstance().getChatService().addChat(c);
//        }
        return "";
    }
}
