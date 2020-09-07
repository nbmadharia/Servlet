import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;  

public class Login extends HttpServlet {

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
    
    response.setContentType("text/html;charset=UTF-8");  
    PrintWriter out = response.getWriter();  
    String un=request.getParameter("username");  
    String p=request.getParameter("pass"); 
    
   // out.println(un);
   // out.println(p);
         if(un.equals("admin") && p.equals("1234")){  
             out.println("Login successfull");
         }
          else{  
        out.println("Sorry username or password error");
         }
    
    
     out.close();     
    }

    
}
