package cocop;

import java.util.*;  
import java.sql.*;  
  
public class ProductDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://192.168.18.245:3306/javamp1004","javamp1004","javamp1004");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Product p){  
        int status=0;  
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into producttable(name,price) values (?,?)");  
            ps.setString(1,p.getName());  
            ps.setString(2,p.getPrice());                
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Product p){  
        int status=0;  
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update producttable set name=?,price=? where id=?");  
            ps.setString(1,p.getName());  
            ps.setString(2,p.getPrice()); 
            ps.setInt(3,p.getId());  

        
               
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from producttable where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Product getProductById(int id){  
        Product p=new Product();  
          
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from producttable where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                p.setId(rs.getInt(1));  
                p.setName(rs.getString(2));  
                p.setPrice(rs.getString(3));  
               
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return p;  
    }  
    public static List<Product> getAllProducts(){  
        List<Product> list=new ArrayList<Product>();  
          
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from producttable");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Product p=new Product();  
                p.setId(rs.getInt(1));  
                p.setName(rs.getString(2));  
                p.setPrice(rs.getString(3));  
             
                list.add(p);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}