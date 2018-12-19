package controller;
import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddFriendsHandler extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String friend = request.getParameter("friend");
        Person vriend = Controller.getInstance().getChatService().getPersonService().getPersonByName(friend);
        if(vriend == null) {
            return "nope";
        }

        Person p = (Person) session.getAttribute("user");
        if(p.getFriends().contains(vriend)){
            return "nope";
        }
        if(p.equals(vriend)){
            return "nope2";
        }
        p.addFriend(vriend);
        if(vriend.getFriends().contains(p)){
            return null;
        }
        vriend.addFriend(p);
        return friend;


    }


}
