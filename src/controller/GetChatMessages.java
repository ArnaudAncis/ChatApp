package controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import domain.Message;
import domain.Person;

public class GetChatMessages extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String naam = request.getParameter("naam");
        Person p = (Person) request.getSession().getAttribute("user");

        Person p2 = Controller.getInstance().getChatService().getPersonService().getPersonByName(naam);


       return toJSON(Controller.getInstance().getChatService().getAllBerichtenFromUsers(p, p2));


       // return toJSON(Controller.getInstance().getChatService().getAllBerichtenFromUser(p));
    }

    public String toJSON(List<Message> messages) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(messages);
    }
}


//





