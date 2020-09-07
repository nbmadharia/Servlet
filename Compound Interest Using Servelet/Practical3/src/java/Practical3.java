import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Practical3 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        //reading values from user entered in html page
        String p = request.getParameter("p");
        String t = request.getParameter("t");
        String r = request.getParameter("r");
       //calculating the amount after adding interest
      double ci = Float.parseFloat(p) * Math.pow(1 + (((Float.parseFloat(r))/100 / 12)), 12 * Float.parseFloat(t));  
      //calculating interest value
      double ciInterest=ci-Float.parseFloat(p);
      //printing the ouput
      out.println("The compound interest is "+ciInterest +" Rs & ");
      out.println("\r\n"+"the amount after " + t + " years is "+ ci + " Rs");
    }
}