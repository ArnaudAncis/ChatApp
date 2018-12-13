package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeStatusHandler extends AsyncRequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String status =  request.getParameter("status");
        Person person = (Person)session.getAttribute("user");
        person.setStatus(status);
        return person.getStatus();

    }


}
