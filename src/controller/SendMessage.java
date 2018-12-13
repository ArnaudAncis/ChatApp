package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import domain.Conversation;
import org.json.JSONObject;

import domain.Message;
import domain.Chat;
import domain.Person;

public class SendMessage extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jsonBericht = request.getParameter("b");
        System.out.println(jsonBericht);
        JSONObject jsonObject = new JSONObject(jsonBericht);

        Person zender = (Person) request.getSession().getAttribute("user");


        String ontvanger = (String) jsonObject.get("ontvanger");
        Person otherUser = Controller.getInstance().getChatService().getPersonService().getPersonByName(ontvanger);
        Message b = new Message((String) jsonObject.get("bericht"), zender);
        Conversation c = Controller.getInstance().getChatService().getConversation(zender, otherUser);

        if(c == null){
            Conversation co = new Conversation(zender, otherUser);
            Controller.getInstance().getChatService().addConversation(co);
        }

        c.addBericht(b);
        System.out.println(c.getBerichten());



//        Chat zenderChat = zender.getChatSessie(ontvanger);
//        Chat ontvangerChat = otherUser.getChatSessie(zender.getFirstName());
//
//
//        if (zenderChat == null) {
//            Chat chat = new Chat(zender, otherUser);
//            chat.addMessage(b);
//            zender.addChat(ontvanger, chat);
//            System.out.println("yes");
//
//        }else{
//            zenderChat.addMessage(b);
//        }
//        if (ontvangerChat == null){
//            Chat chat = new Chat(zender, otherUser);
//            chat.addMessage(b);
//            otherUser.addChat(zender.getFirstName(), chat);
//            System.out.println("yes");
//
//        } else{
//            ontvangerChat.addMessage(b);
//        }
//
//        zender.addMessage(b, ontvanger);
//        otherUser.addMessage(b, zender.getFirstName());



//        System.out.println(zenderChat.getFrom().getFirstName() + " " + zenderChat.getTo().getFirstName() + " " + ontvangerChat.getFrom().getFirstName() + " " + ontvangerChat.getTo().getFirstName());
//        System.out.println(zenderChat.getMessages() + " " + ontvangerChat.getMessages() );
//        System.out.println(jsonBericht);
        return jsonBericht;
    }
}






