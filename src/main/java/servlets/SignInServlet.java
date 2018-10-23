package servlets;

import entities.Account;
import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        AccountService accountService = new AccountService();
        try {
            long id = 0;
            try {
                id = accountService.getByEmail(email).getId();
            } catch (NullPointerException e) {
            }
            if (id == 0) {
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                resp.getWriter().println("Account does not exist");
            } else {
                Account account = accountService.getByEmail(email);
                if (!account.getPassword().equals(password)) {
                    resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    resp.getWriter().println("Wrong password");
                } else {
                    resp.setStatus(HttpServletResponse.SC_OK);
                    resp.getWriter().println("Success!");
                    resp.getWriter().println(account);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
