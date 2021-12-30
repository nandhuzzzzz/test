package cocop;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewProduct
 */
@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
     response.setContentType("text/html");  
     PrintWriter out=response.getWriter();  
     out.println("<a href='product.html'>Add Product</a>");  
     out.println("<h1>Product</h1>");  
       
     List<Product> list=ProductDao.getAllProducts();  
       
     out.print("<table border='1' width='100%'");  
     out.print("<tr><th>Id</th><th>Name</th><th>Price</th><th>Edit</th><th>Delete</th></tr>");  
     for(Product p:list){  
      out.print("<tr><td>"+p.getId()+"</td><td>"+p.getName()+"</td><td>"+p.getPrice()+"</td> <td><a href='EditProduct?id="+p.getId()+"'>edit</a></td>  <td><a href='DeleteProduct?id="+p.getId()+"'>delete</a></td></tr>");  
     }  
     out.print("</table>");  
       
     out.close();  
 }  
} 