package cocop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditProduct2
 */
@WebServlet("/EditProduct2")
public class EditProduct2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
          response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
            
          String pid=request.getParameter("id");  
          int id=Integer.parseInt(pid);  
          String name=request.getParameter("name");  
          String price=request.getParameter("price");  
            
          Product e=new Product();  
          e.setId(id);  
          e.setName(name);  
          e.setPrice(price);  
            
          int status=ProductDao.update(e);  
          if(status>0){  
              response.sendRedirect("ViewProduct");  
          }else{  
              out.println("Sorry! unable to update record");  
          }  
            
          out.close();  
      }  
    
  } 