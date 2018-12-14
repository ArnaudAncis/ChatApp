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
        return "";
    }
}
