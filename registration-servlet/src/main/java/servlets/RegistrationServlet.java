package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "registrationServlet",
        urlPatterns = {"/registration", "/registration-from"}
)
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        // Fetching parameters
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Setting response content type to html
        resp.setContentType("text/html");

        // Return a parameters in table as response
        out.write("<style>" +
                "table{text-align: center; border-collapse: collapse; margin-left: auto; margin-right: auto;}" +
                "th, td{padding:10px}" +
                "table,th,td {border: 1px solid black;}" +
                "</style>");
        out.write("<h3 style='text-align: center;'>Successfully Registered</h3>");
        out.write("<table>");
        out.write("<tr><th>Email</th><th>Username</th><th>Password</th></tr>");
        out.write("<tr><td>" + email + "</td><td>" + username + "</td><td>" + password + "</td></tr>");
        out.write("</table>");
        out.flush();
    }
}
