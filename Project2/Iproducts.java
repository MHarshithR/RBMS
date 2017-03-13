import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.OracleCallableStatement; 
public class Iproducts extends HttpServlet{
    
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException
{
   
   
     response.setContentType("text/html");
   PrintWriter out = response.getWriter();
//int n = Integer.parseInt(request.getParameter("op"));     // JDBC driver name and database URL
   //static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
   final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

   //  Database credentials
   final String USER = "SYSTEM";
   final String PASS = "harshith";
  // response.setContentType("text/html");
  // PrintWriter out = response.getWriter();
//   int n;
//  String s;
   Connection conn = null;
   CallableStatement stmt = null;
   //ResultSet rs = null;
   //n = Integer.parseInt(request.getParameter("op"));
    //  out.println(n);
      //STEP 2: Register JDBC driver
     try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
       
      //STEP 3: Open a connection
      //System.out.println("");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
    String s = request.getParameter("op1");
    String s1 = request.getParameter("op2");
    int n = Integer.parseInt(request.getParameter("op3"));
    int n1 = Integer.parseInt(request.getParameter("op4"));
   float n2 = Float.parseFloat(request.getParameter("op5"));
    float n3 = Float.parseFloat(request.getParameter("op6"));
      
     stmt = conn.prepareCall("{call add_tuples1.add_products(?,?,?,?,?,?)}");
       stmt.setString(1,s);
       stmt.setString(2,s1);
       stmt.setInt(3,n);
       stmt.setInt(4,n1);
       stmt.setFloat(5,n2);
       stmt.setFloat(6,n3);
       stmt.execute();
     out.println("Tuple Inserted");  
     
    //rs.close();
     // rs = null;
      stmt.close();
      conn.close();
      out.close();
   }//catch(SQLException se){
     //se.printStackTrace();}
  catch(Exception e){
      out.println("Insufficient");
      //e.printStackTrace();
   }/*finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }*/
}
}