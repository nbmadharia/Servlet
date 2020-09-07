import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;  

public class UseName extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
    
    response.setContentType("text/html;charset=UTF-8");  
PrintWriter out = response.getWriter();  
          try{
              String name=request.getParameter("Name");
              out.println(name);
              //RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
        //rd.forward(request,response);
          }finally{
              out.close();
          }
//String name=request.getParameter("Name");
 
    
    
        
    }

    
}
