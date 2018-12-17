package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Users extends AsyncRequestHandler  {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonService s = Controller.getInstance().getChatService().getPersonService();
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        return toJSON(s.getPersons());

    }
    public String toJSON (List<Person> friends) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(friends);
    }
}
