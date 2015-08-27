

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrdersPlaced")
public class OrdersPlaced extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String tdate;String fdate;
		System.out.println("done");
		try {
		fdate=request.getParameter("ddate");
		tdate=request.getParameter("edate");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date fDate = formatter.parse(fdate);
		java.sql.Date Fdate=new java.sql.Date(fDate.getTime());
		java.util.Date tDate = formatter.parse(tdate);
		java.sql.Date Tdate=new java.sql.Date(tDate.getTime());
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@192.168.0.121:1521:orcl";
		
		 String filename = "C:\\kishore\\reports\\WebContent\\OrdersPlaced.csv";
		 FileWriter fw = new FileWriter(filename);
		
		 String user="hr";
		String pass="hr";
		
		Connection con=DriverManager.getConnection(url,user,pass);
		PreparedStatement pst;
		String querry="select count(customer_orders.order_id),service_description.service_name from customer_orders Inner join product_services on customer_orders.order_id=product_services.order_id inner join service_description on product_services.service_id=service_description.service_id where customer_orders.order_negotiation_date between ? and ? group by service_description.service_name";
		pst=con.prepareStatement(querry);
		pst.setDate(1,Fdate);
		pst.setDate(2,Tdate); 
		ResultSet rs=pst.executeQuery();
		  fw.append("countOrders");
		  fw.append(',');
		  fw.append("serviceType");
		   fw.append('\n');
		  while(rs.next())
		  {
			  
		  fw.append(""+rs.getInt(1));
		  fw.append(',');
		  fw.append(rs.getString(2));
		  fw.append('\n');
		  }
		  fw.flush();
		  fw.close();
		  con.close();
		  System.out.println("CSV File is created successfully.");
		  
		} 
		
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("OrdersPlacedD3.jsp");
		r.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
