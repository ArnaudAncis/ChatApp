package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Person;
import domain.Role;

import java.io.IOException;

public abstract class RequestHandler {

	
	private PersonService personService;
	private ChatService chatService;
	
	public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException;


	public void setModel (ChatService chatService) {
		this.chatService = chatService;
	}

	public PersonService getPersonService() {
		return personService;
	}
	public ChatService getChatService(){return chatService;}
	public void forward(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}


	
	protected boolean isFromUserWithRole (HttpServletRequest request, Role role) {
		Person person = (Person) request.getSession().getAttribute("user");
		if (person != null && person.getRole().equals(role)) {
			return true;
		}
		return false;
	}

}
