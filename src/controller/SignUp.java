package controller;

import domain.Person;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class SignUp extends SyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String destination = "chat.jsp";
        List<String> errors = new ArrayList<String>();

        String firstName = request.getParameter("firstName");
        if(firstName == null || firstName.isEmpty()){
            errors.add("no first name given");
        }

        String lastName = request.getParameter("lastName");
        if(lastName == null || lastName.isEmpty()){
            errors.add("no last name given");
        }
        String email = request.getParameter("email");
        if (email == null || email.isEmpty()) {
            errors.add("No email given");
        }
        String sex = request.getParameter("sex");
        if (sex == null || sex.isEmpty()) {
            errors.add("No sex given");
        }
        String password = request.getParameter("password");
        if (password == null || password.isEmpty()) {
            errors.add("No password given");
        }
        String password2 = request.getParameter("password2");
        if (!password2.equals(password) ) {
            errors.add("Passwords don't match");
        }

        if (errors.size() == 0) {
            PersonService personService = Controller.getInstance().getChatService().getPersonService();
            Person person = new Person(email, password, firstName, lastName, sex, Role.LID  );

            if(person != null) {
                personService.addPerson(person);
                createSession(person, request, response);
            }
            else{
                errors.add("lel");
            }


        }

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            return "signup.jsp";
        }

        return destination;

    }


    private void createSession(Person person, HttpServletRequest request,
                               HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("user", person);
    }
}
