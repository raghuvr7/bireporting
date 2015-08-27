

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class BrokenPromises
*/
@WebServlet("/CallsPortals")
public class CallsPortals extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#HttpServlet()
*/
public CallsPortals() {
super();
// TODO Auto-generated constructor stub
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String year;
String month;

try {
month=request.getParameter("month");
year=request.getParameter("year");
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:orcl";
String user="scott";
String pass="admin";
Connection con=DriverManager.getConnection(url,user,pass);
Connection con1=DriverManager.getConnection(url,user,pass);
PreparedStatement pst,pst1;
String querry="select count(customer_id) from customer_orders where to_char(order_due_date,'mm')=? and to_char(order_due_date,'yyyy')=?"; 
String querry1=" select count(cust_id) from customer_ticket where to_char(creation_date,'mm')=? and to_char(creation_date,'yyyy')=?";
pst=con.prepareStatement(querry);
pst.setString(1,month);
pst.setString(2,year);
pst1=con1.prepareStatement(querry1);
pst1.setString(1,month);
pst1.setString(2,year);
ResultSet rs=pst.executeQuery();
ResultSet rs1=pst1.executeQuery();

String filename = "C:\\kishore\\reports\\WebContent\\CallsPortals.csv";
FileWriter fw = new FileWriter(filename);
fw.append("name");
fw.append(',');
fw.append("count");
fw.append('\n');
int x=0;
int y=0;
while(rs.next())
{
	System.out.println(rs.getInt(1));
x=rs.getInt(1);

}

while(rs1.next())
{
y=rs1.getInt(1);
}
fw.append("calls");
fw.append(',');
fw.append(""+x);
fw.append('\n');
fw.append("support");
fw.append(',');
fw.append(""+y);
fw.append('\n');
fw.flush();
fw.close();
con.close();
con1.close();
System.out.println("CSV File is created successfully.");

} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
RequestDispatcher r =request.getRequestDispatcher("CallsPortalsPie.jsp");
r.forward(request, response);
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
}

}



