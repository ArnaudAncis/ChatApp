package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Conversation;
import org.json.JSONObject;

import domain.Message;
import domain.Person;

public class SendMessage extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jsonBericht = request.getParameter("b");
        JSONObject jsonObject = new JSONObject(jsonBericht);

        Person zender = (Person) request.getSession().getAttribute("user");
        String ontvanger = (String) jsonObject.get("ontvanger");
        Person otherUser = Controller.getInstance().getChatService().getPersonService().getPersonByName(ontvanger);
        Message b = new Message((String) jsonObject.get("bericht"), zender, otherUser);
        Conversation c = Controller.getInstance().getChatService().getConversation(zender, otherUser);

        if(c == null){
            Conversation co = new Conversation(zender, otherUser);
            Controller.getInstance().getChatService().addConversation(co);
        }

        c.addBericht(b);

        jsonObject.put("sender", zender.getFirstName());

        return jsonObject.toString();
    }
}






