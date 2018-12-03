package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.PersonRepository;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddFriendsHandler extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String friend = request.getParameter("friend");
        Person person = new Person();
        person.setFirstName(friend);
        Person p = (Person) session.getAttribute("user");
        p.addFriend(person);
        person.addFriend(p);
        return friend;


    }
}
