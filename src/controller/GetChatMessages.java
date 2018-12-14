package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import domain.Chat;
import domain.Conversation;
import domain.Message;
import domain.Person;

public class GetChatMessages extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(Controller.getInstance().getChatService().getConversations());
        Person p = (Person) request.getSession().getAttribute("user");
        //Person an = Controller.getInstance().getChatService().getPersonService().getPersonByName("An");
        System.out.println(Controller.getInstance().getChatService().getAllBerichten());
        return toJSON(Controller.getInstance().getChatService().getAllBerichtenFromUser(p));
    }

    public String toJSON(List<Message> messages) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(messages);
    }
}


//





