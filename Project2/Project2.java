import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.OracleCallableStatement; 
public class Project2 extends HttpServlet{
    
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException
{
   
   
     response.setContentType("text/html");
   PrintWriter out = response.getWriter();
int n = Integer.parseInt(request.getParameter("op"));     // JDBC driver name and database URL
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

      //STEP 4: Execute a query

      
     // out.println(n);
      if(n == 1)
      {
      stmt = conn.prepareCall("{call prjjct_2.show_products(?)}");
      
     stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.execute();
     rs = ((OracleCallableStatement)stmt).getCursor(1);
     out.println("<html><head><title><b>Retail Business Management System</b></title><style> #wrapper{margin:auto;width:auto;}#header{background-color:black;color:white;text-align:center;padding:5px;}#content{backgroundcolor:white;color:black;text-align:center;width:90px;height:7px;padding:10px;}#footer{background-color:black;color:white;clear:both;width:auto;margin:auto;text-align:center;padding:5px;}h2 {font-family:courier;text-align: center;}form{text-align: center;font-family:courier;color: blue;}</style></head><body><div id ='wrapper'><div id ='header'><h2>Product Details</h2>");
    // out.println("</br>");
     out.println("</div>");

   
     //out.println("<p>PRODUCT DETAILS</p>");
     //out.println("</br>");
     //out.println("</br>");
     //out.println("<body>");
     out.println("<div>");
     out.println("<center>");
     out.println("<table>");
     while(rs.next())
     {
       out.println("<tr>");
       
       out.println("<td>");
       out.println("PID:"+rs.getString("pid"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
       out.println("<td>");
       out.println("PNAME:"+rs.getString("pname"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("QOH:"+rs.getInt("qoh"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("QOH_T:"+rs.getInt("qoh_threshold"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("O_price:"+rs.getFloat("original_price"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("D_rate:"+rs.getFloat("discnt_rate"));
       out.println("</td>");
       out.println("</tr>");
       
     out.println("</tr>"); 
     out.println("</br>");//STEP 5: Extract data from result set
      //out.println("</br>");
      //out.println("</br>");
      }
   
     out.println("</table>");
      out.println("</center>");
    out.println("</div>"); 
    out.println("<br/><br/><br/><br/><br/><br/><br/><br/>");
    out.println("<div id = 'footer'>This is a Copyright Reserved<sup> c </sup> version permission to copy is denied</div>");
//    out.println("</body>");
      out.println("</html>");
     }
     else if(n==2)
     {
       stmt = conn.prepareCall("{call prjjct_2.show_employees(?)}");
      
     stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.execute();
     rs = ((OracleCallableStatement)stmt).getCursor(1);
      out.println("<html><head><title><b>Retail Business Management System</b></title><style> #wrapper{margin:auto;width:auto;}#header{background-color:black;color:white;text-align:center;padding:5px;}#content{backgroundcolor:white;color:black;text-align:center;width:90px;height:7px;padding:10px;}#footer{background-color:black;color:white;clear:both;width:auto;margin:auto;text-align:center;padding:5px;}h2 {font-family:courier;text-align: center;}form{text-align: center;font-family:courier;color: blue;}</style></head><body><div id ='wrapper'><div id ='header'><h2>Employee Details</h2>");
    // out.println("</br>");
     out.println("</div>");
 out.println("<div>");
     out.println("<center>");
     out.println("<table>");   
  while(rs.next())
     {
       out.println("<tr>");
       
       out.println("<td>");
       out.println("EID:"+rs.getString("eid"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
       out.println("<td>");
       out.println("ENAME:"+rs.getString("ename"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("TELEPHONE:"+rs.getString("telephone#"));
       out.println("</td>");
       //out.println(rs.getString("eid") + "," + rs.getString("ename") + "," + rs.getString("telephone#"));
       //out.println("</br>");
out.println("</tr>");
       
     out.println("</tr>"); 
     out.println("</br>");   
     out.println("</br>"); 
  }
   out.println("</table>");
      out.println("</center>");
    out.println("</div>"); 
    out.println("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></br></br></br></br>");
    out.println("<div id = 'footer'>This is a Copyright Reserved<sup> c </sup> version permission to copy is denied</div>");
//    out.println("</body>");
      out.println("</html>");
     }
     else if(n==3)
     {
       stmt = conn.prepareCall("{call prjjct_2.show_purchases(?)}");
      
     stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.execute();
     rs = ((OracleCallableStatement)stmt).getCursor(1);
     out.println("<html><head><title><b>Retail Business Management System</b></title><style> #wrapper{margin:auto;width:auto;}#header{background-color:black;color:white;text-align:center;padding:5px;}#content{backgroundcolor:white;color:black;text-align:center;width:90px;height:7px;padding:10px;}#footer{background-color:black;color:white;clear:both;width:auto;margin:auto;text-align:center;padding:5px;}h2 {font-family:courier;text-align: center;}form{text-align: center;font-family:courier;color: blue;}</style></head><body><div id ='wrapper'><div id ='header'><h2>Purchases Details</h2>");
     out.println("</br>");
     out.println("</div>");
 out.println("<div>");
     out.println("<center>");
     out.println("<table>");    
 while(rs.next())
     {
out.println("<tr>");
       
       out.println("<td>");
       out.println("PURID:"+rs.getString("pur#"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
       out.println("<td>");
       out.println("EID:"+rs.getString("eid"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("PID:"+rs.getString("pid"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("CID:"+rs.getString("cid"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("QTY:"+rs.getInt("qty"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("PTIME:"+rs.getString("ptime"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("Total_Price:"+rs.getFloat("total_price"));
       out.println("</td>");
       out.println("</tr>");
       
     out.println("</tr>"); 
    // out.println("</br>");//STEP 5: Extract data from result set
      //out.println("</br>");
      //out.println("</br>");
       //out.println(rs.getInt("pur#") + "," + rs.getString("eid") + "," + rs.getString("pid")+ "," + rs.getString("cid") + "," + rs.getInt("qty") + "," + rs.getString("ptime")+ "," + rs.getFloat("total_price"));
       //out.println("</br>");
      }
out.println("</table>");
      out.println("</center>");
    out.println("</div>"); 
    out.println("<br/><br/><br/><br/><br/><br/><br/><br/>");
    out.println("<div id = 'footer'>This is a Copyright Reserved<sup> c </sup> version permission to copy is denied</div>");
//    out.println("</body>");
      out.println("</html>");
     }
     else if(n==4)
     {
       stmt = conn.prepareCall("{call prjjct_2.show_customers(?)}");
      
     stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.execute();
     rs = ((OracleCallableStatement)stmt).getCursor(1);
      out.println("<html><head><title><b>Retail Business Management System</b></title><style> #wrapper{margin:auto;width:auto;}#header{background-color:black;color:white;text-align:center;padding:5px;}#content{backgroundcolor:white;color:black;text-align:center;width:90px;height:7px;padding:10px;}#footer{background-color:black;color:white;clear:both;width:auto;margin:auto;text-align:center;padding:5px;}h2 {font-family:courier;text-align: center;}form{text-align: center;font-family:courier;color: blue;}</style></head><body><div id ='wrapper'><div id ='header'><h2>Customer Details</h2>");
    // out.println("</br>");
     out.println("</div>");
 out.println("<div>");
     out.println("<center>");
     out.println("<table>");     
while(rs.next())
     {
out.println("<tr>");
       
       out.println("<td>");
       out.println("CID:"+rs.getString("cid"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
       out.println("<td>");
       out.println("CNAME:"+rs.getString("cname"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("TELEPHONE#:"+rs.getString("telephone#"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("VISITS_MADE:"+rs.getInt("visits_made"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("LAST_VISIT_DATE:"+rs.getString("last_visit_date"));
       out.println("</td>");
out.println("</tr>");
       
     out.println("</tr>"); 
     out.println("</br>");//STEP 5: Extract data from result set
      //out.println("</br>");
      //out.println("</br>");
       //out.println(rs.getInt("pur#") + "," + rs.getString("eid") + "," + rs.getString("pid")+ "," + rs.getString("cid") + "," + rs.getInt("qty") + "," + rs.getString("ptime")+ "," + rs.getFloat("total_price"));
       //out.println("</br>");
      // out.println(rs.getString("cid") + "," + rs.getString("cname") + "," + rs.getString("telephone#")+ "," + rs.getString("visits_made") + "," + rs.getString("last_visit_date"));
      // out.println("</br>");
     }
out.println("</table>");
      out.println("</center>");
    out.println("</div>"); 
    out.println("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
    out.println("<div id = 'footer'>This is a Copyright Reserved<sup> c </sup> version permission to copy is denied</div>");
//    out.println("</body>");
      out.println("</html>");
     }
     else if(n==5)
     {
       stmt = conn.prepareCall("{call prjjct_2.show_suppliers(?)}");
      
     stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.execute();
     rs = ((OracleCallableStatement)stmt).getCursor(1);
     out.println("<html><head><title><b>Retail Business Management System</b></title><style> #wrapper{margin:auto;width:auto;}#header{background-color:black;color:white;text-align:center;padding:5px;}#content{backgroundcolor:white;color:black;text-align:center;width:90px;height:7px;padding:10px;}#footer{background-color:black;color:white;clear:both;width:auto;margin:auto;text-align:center;padding:5px;}h2 {font-family:courier;text-align: center;}form{text-align: center;font-family:courier;color: blue;}</style></head><body><div id ='wrapper'><div id ='header'><h2>Supplier Details</h2>");
    // out.println("</br>");
     out.println("</div>");
 out.println("<div>");
     out.println("<center>");
     out.println("<table>");     
while(rs.next())
     {
 out.println("<tr>");
       
       out.println("<td>");
       out.println("SID:"+rs.getString("sid"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
       out.println("<td>");
       out.println("SNAME:"+rs.getString("sname"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("CITY:"+rs.getString("city"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("TELEPHONE#:"+rs.getString("telephone#"));
       out.println("</td>");
      // out.println(rs.getString("sid") + "," + rs.getString("sname") + "," + rs.getString("city")+ "," + rs.getString("telephone#"));
      // out.println("</br>");
    out.println("</tr>");
       
     out.println("</tr>"); 
     out.println("</br>");//STEP 5: Extract data from result set
      //out.println("</br>");
     }
out.println("</table>");
      out.println("</center>");
    out.println("</div>"); 
    out.println("<br/><br/><br/><br/><br/><br/><br/>");
    out.println("<div id = 'footer'>This is a Copyright Reserved<sup> c </sup> version permission to copy is denied</div>");
//    out.println("</body>");
      out.println("</html>");
     }
     else if(n==6)
     {
       stmt = conn.prepareCall("{call prjjct_2.show_supply(?)}");
      
     stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.execute();
     rs = ((OracleCallableStatement)stmt).getCursor(1);
      out.println("<html><head><title><b>Retail Business Management System</b></title><style> #wrapper{margin:auto;width:auto;}#header{background-color:black;color:white;text-align:center;padding:5px;}#content{backgroundcolor:white;color:black;text-align:center;width:90px;height:7px;padding:10px;}#footer{background-color:black;color:white;clear:both;width:auto;margin:auto;text-align:center;padding:5px;}h2 {font-family:courier;text-align: center;}form{text-align: center;font-family:courier;color: blue;}</style></head><body><div id ='wrapper'><div id ='header'><h2>SUPPLY DETAILS</h2>");
    // out.println("</br>");
     out.println("</div>");
 out.println("<div>");
     out.println("<center>");
     out.println("<table>");    
 while(rs.next())
     {
out.println("<tr>");
       
       out.println("<td>");
       out.println("SUP#:"+rs.getString("sup#"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
       out.println("<td>");
       out.println("PID:"+rs.getString("pid"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("SID:"+rs.getString("sid"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("SDATE:"+rs.getString("sdate"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("QUANTITY:"+rs.getString("quantity"));
       out.println("</td>");
out.println("</tr>");
       
     out.println("</tr>"); 
     out.println("</br>");//STEP 5: Extract data from result set
      out.println("</br>");
       //out.println(rs.getString("sup#") + "," + rs.getString("pid") + "," + rs.getString("sid")+ "," + rs.getString("sdate") + "," + rs.getInt("quantity"));
      out.println("</br>"); 
     }
out.println("</table>");
      out.println("</center>");
    out.println("</div>"); 
    out.println("<br/><br/><br/><br/><br/><br/><br/><br/>");
    out.println("<div id = 'footer'>This is a Copyright Reserved<sup> c </sup> version permission to copy is denied</div>");
//    out.println("</body>");
      out.println("</html>");
     }
  else if(n==7)
     {
       stmt = conn.prepareCall("{call prjjct_2.show_logs(?)}");
      
     stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.execute();
     rs = ((OracleCallableStatement)stmt).getCursor(1);
      out.println("<html><head><title><b>Retail Business Management System</b></title><style> #wrapper{margin:auto;width:auto;}#header{background-color:black;color:white;text-align:center;padding:5px;}#content{backgroundcolor:white;color:black;text-align:center;width:90px;height:7px;padding:10px;}#footer{background-color:black;color:white;clear:both;width:auto;margin:auto;text-align:center;padding:5px;}h2 {font-family:courier;text-align: center;}form{text-align: center;font-family:courier;color: blue;}</style></head><body><div id ='wrapper'><div id ='header'><h2>LOGS</h2>");
    // out.println("</br>");
     out.println("</div>");
 out.println("<div>");
     out.println("<center>");
     out.println("<table>");     
while(rs.next())
     {
out.println("<tr>");
       
       out.println("<td>");
       out.println("LOG#:"+rs.getString("log#"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
       out.println("<td>");
       out.println("USER:"+rs.getString("who"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("Time:"+rs.getString("otime"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("Table"+rs.getString("table_name"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("OPERATION:"+rs.getString("operation"));
       out.println("</td>");
out.println("<td>");
       out.println("</td>");
out.println("<td>");
       out.println("KEY:"+rs.getString("key_value"));
       out.println("</td>");
out.println("</tr>");
       
     out.println("</tr>"); 
     out.println("</br>");//STEP 5: Extract data from result set
      //out.println("</br>");
      //out.println("</br>");
       //out.println(rs.getInt("pur#") + "," + rs.getString("eid") + "," + rs.getString("pid")+ "," + rs.getString("cid") + "," + rs.getInt("qty") + "," + rs.getString("ptime")+ "," + rs.getFloat("total_price"));
       //out.println("</br>");
      // out.println(rs.getString("cid") + "," + rs.getString("cname") + "," + rs.getString("telephone#")+ "," + rs.getString("visits_made") + "," + rs.getString("last_visit_date"));
      // out.println("</br>");
     }
out.println("</table>");
      out.println("</center>");
    out.println("</div>"); 
    out.println("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
    out.println("<div id = 'footer'>This is a Copyright Reserved<sup> c </sup> version permission to copy is denied</div>");
//    out.println("</body>");
      out.println("</html>");
     }
     else if(n==8)
     {
      response.sendRedirect("RMS.html");
      String s = request.getParameter("ppid");
      stmt = conn.prepareCall("{call rms_pack.REPORT_MONTHLY_SAL(?,?,?)}");
      stmt.setString(1,s);
 stmt.registerOutParameter(2,OracleTypes.CURSOR);     
      stmt.registerOutParameter(3,OracleTypes.CURSOR);
      stmt.execute();
     rs = ((OracleCallableStatement)stmt).getCursor(2);
     
     ResultSet r = ((OracleCallableStatement)stmt).getCursor(3);
     out.println("<html><head><title><b>Retail Business Management System</b></title><style> #wrapper{margin:auto;width:auto;}#header{background-color:black;color:white;text-align:center;padding:5px;}#content{backgroundcolor:white;color:black;text-align:center;width:90px;height:7px;padding:10px;}#footer{background-color:black;color:white;clear:both;width:auto;margin:auto;text-align:center;padding:5px;}h2 {font-family:courier;text-align: center;}form{text-align: center;font-family:courier;color: blue;}</style></head><body><div id ='wrapper'><div id ='header'><h2>Product Details</h2>");
    // out.println("</br>");
     out.println("</div>");
 out.println("<div>");
     out.println("<center>");
     out.println("<table>");    
while(r.next())
     {
     out.println(r.getString("pname"));
     out.println("</br>");    
 }
      while(rs.next())
     {
       out.println(rs.getString("t") + "," + rs.getString("t1") + "," + rs.getInt("t2")+ "," + rs.getFloat("t3")+ "," + (rs.getFloat("t3"))/(rs.getInt("t2")));
       out.println("</br>"); 
     }
     
     }
     else if(n==9)
     {
       response.sendRedirect("pur.html");
       
       
     }
     else if(n==10)
     {
       response.sendRedirect("prod.html");
     }
     rs.close();
      rs = null;
      stmt.close();
      conn.close();
      out.close();
   }//catch(SQLException se){
     //se.printStackTrace();}
  catch(Exception e){
      out.println(e);
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