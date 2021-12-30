package cocop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveProduct
 */
@WebServlet("/SaveProduct")
public class SaveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
           response.setContentType("text/html");  
           PrintWriter out=response.getWriter();  
             
           String name=request.getParameter("name");  
           String price=request.getParameter("price");  

             
           Product p=new Product(); 
           p.setName(name);
           p.setPrice(price);             
           int status=ProductDao.save(p);  
           if(status>0){  
               out.print("<p>Record saved successfully!</p>");  
               request.getRequestDispatcher("product.html").include(request, response);  
           }else{  
               out.println("<p>Sorry! unable to save record</p>");  
           }  
             
           out.close();  
       }  
     
   } 