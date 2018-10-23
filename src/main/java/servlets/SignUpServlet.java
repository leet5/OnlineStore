package servlets;

import entities.Account;
import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        AccountService accountService = new AccountService();
        try{
            if(first_name.equals("") || password.equals("")){
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().println("Login or password are not entered!");
            } else if(email.equals("")){
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().println("EMail is not entered!");
            } else {
                resp.setStatus(HttpServletResponse.SC_OK);
                if(!last_name.equals("")){
                    Account account = new Account(first_name, last_name, email, password);
                    accountService.add(account);
                } else {
                    Account account = new Account(first_name, email, password);
                    accountService.add(account);
                }
            }
        } catch (Exception e) {e.printStackTrace();}
    }
}
