import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.OracleCallableStatement; 
public class RMS extends HttpServlet{
    
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
   ResultSet rs = null;
   //n = Integer.parseInt(request.getParameter("op"));
    //  out.println(n);
      //STEP 2: Register JDBC driver
     try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
       
      //STEP 3: Open a connection
      //System.out.println("");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
String s = request.getParameter("ppid");
      stmt = conn.prepareCall("{call rms_pack.REPORT_MONTHLY_SAL(?,?,?)}");
      stmt.setString(1,s);
 stmt.registerOutParameter(2,OracleTypes.CURSOR);     
      stmt.registerOutParameter(3,OracleTypes.CURSOR);
      stmt.execute();
     rs = ((OracleCallableStatement)stmt).getCursor(2);
     
     ResultSet r = ((OracleCallableStatement)stmt).getCursor(3);
   out.println("<html><head><title><b>Retail Business Management System</b></title><style> #wrapper{margin:auto;width:auto;}#header{background-color:black;color:white;text-align:center;padding:5px;}#content{backgroundcolor:white;color:black;text-align:center;width:90px;height:7px;padding:10px;}#footer{background-color:black;color:white;clear:both;width:auto;margin:auto;text-align:center;padding:5px;}h2 {font-family:courier;text-align: center;}form{text-align: center;font-family:courier;color: blue;}</style></head><body><div id ='wrapper'><div id ='header'><h2>MONTHLY SALE</h2>");
    // out.println("</br>");
     out.println("</div>");
 out.println("<div>");
     out.println("<center>");
    while(r.next())
     {
     out.println("PRODUCT_NAME:"+r.getString("pname"));
     out.println("</br>");    
     }
     out.println("<table>");
      while(rs.next())
     {
      out.println("<tr>");
       
       out.println("<td>");
       out.println("MONTH:"+rs.getString("t"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
       out.println("<td>");
       out.println("YEAR:"+rs.getString("t1"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("T_QTY:"+rs.getInt("t2"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("T_PRICE:"+rs.getFloat("t3"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("AVG:"+(rs.getFloat("t3"))/(rs.getInt("t2")));
       out.println("</td>");
out.println("</tr>");
       
     out.println("</tr>"); 
      // out.println(rs.getString("t") + "," + rs.getString("t1") + "," + //rs.getInt("t2")+ "," + rs.getFloat("t3")+ "," + (rs.getFloat("t3"))/(rs.getInt//("t2")));
  //     out.println("</br>"); 
     }
out.println("</table>");
      out.println("</center>");
    out.println("</div>"); 
    out.println("<br/><br/><br/><br/><br/><br/><br/><br/>");
    out.println("<div id = 'footer'>This is a Copyright Reserved<sup> c </sup> version permission to copy is denied</div>");
//    out.println("</body>");
      out.println("</html>");

    rs.close();
      rs = null;
      stmt.close();
      conn.close();
      out.close();
   }//catch(SQLException se){
     //se.printStackTrace();}
  catch(Exception e){
      out.println("Product Not available");
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