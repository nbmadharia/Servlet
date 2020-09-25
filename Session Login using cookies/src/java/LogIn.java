import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/Login"})
public class LogIn extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(true);
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        if(username.equals("naman") && password.equals("1234")){
            try{
                response.setContentType("text/html;charset=UTF-8");
                writer.println("<html><link rel=\"stylesheet\" href=\"style.css\"><body>");
                writer.println("Thank You, "+username+". You are now Logged in");
                if(session == null){
                    writer.println("<p>You are not logged in</p>");
                }else{
                    writer.println("Your details are: ");
                    Enumeration names = session.getAttributeNames();
                    while(names.hasMoreElements()){
                        String name = (String) names.nextElement();
                        Object value = session.getAttribute(name);
                        writer.println("<p>Name = "+name+" Value = "+value+"</p>");
                    }
                }
                writer.println("<p><a href=\"index.html\"> Return </a>to login page</p>");
                writer.println("</body></html>");
                writer.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            writer.println("Authentication Failed!!!");
        }
    }
    
}
