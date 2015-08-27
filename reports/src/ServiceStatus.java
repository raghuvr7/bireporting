

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServiceStatus")
public class ServiceStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String tdate;
		String fdate;
		System.out.println("done");
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		
		 String filename = "C:\\kishore\\reports\\WebContent\\pie.csv";
		 FileWriter fw = new FileWriter(filename);
		
		 String user="scott";
		String pass="admin";
		
		Connection con=DriverManager.getConnection(url,user,pass);
		PreparedStatement pst;
		String querry="select count(service_id),type_status from customer_ticket group by type_status";
		pst=con.prepareStatement(querry); 
		ResultSet rs=pst.executeQuery();
		  fw.append("service");
		  fw.append(',');
		  fw.append("status");
		   fw.append('\n');
		  while(rs.next())
		  {
			  
		  fw.append(""+rs.getInt(1));
		  fw.append(',');
		  if(rs.getString(2).equals("0"))
		  {
			  fw.append("Customers Abandoned");
		  }
		  if(rs.getString(2).equals("1"))
		  {
			  fw.append("Self Served Customers");
		  }
		  if(rs.getString(2).equals("2"))
		  {
			  fw.append("Trouble Tickets Created");
		  }
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
		RequestDispatcher r =request.getRequestDispatcher("ServiceStatusPie.jsp");
		r.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
