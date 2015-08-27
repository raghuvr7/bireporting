

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


@WebServlet("/OrdersProvisioned")
public class OrdersProvisioned extends HttpServlet {
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
		String url="jdbc:oracle:thin:@192.168.0.168:1521:orcl";
		String user="scott";
		String pass="tiger";
		String filename = "C:\\kishore\\reports\\WebContent\\OrdersProvisioned.csv";
		 FileWriter fw = new FileWriter(filename);
		Connection con=DriverManager.getConnection(url,user,pass);
		PreparedStatement pst;
		String querry="select count(circuit_design.modified_date),orders_demo.service_id from circuit_design inner join orders_demo on circuit_design.order_id=orders_demo.order_id where circuit_design.modified_date between ? and ? group by orders_demo.service_id"; 
		pst=con.prepareStatement(querry);
		pst.setDate(1,Fdate);
		pst.setDate(2,Tdate); 
		ResultSet rs=pst.executeQuery();
		  fw.append("countOrders");
		  fw.append(',');
		  fw.append("serviceType");
		   fw.append('\n');
		   System.out.println("hello");
		  while(rs.next())
		  {
			  System.out.println(rs.getInt(1));
			  fw.append(""+rs.getInt(1));
			  fw.append(',');
			  
			  if(rs.getInt(2)==1)
				  fw.append("voice");
			  else if(rs.getInt(2)==2)
				  fw.append("data");
			  else if(rs.getInt(2)==3)
				  fw.append("fios");
			  else if(rs.getInt(2)==4)
				  fw.append("bundles");
			  else if(rs.getInt(2)==5)
				  fw.append("wireless");
			  else if(rs.getInt(2)==6)
				  fw.append("enterprise");
			  
			  	  fw.append('\n');
			
		  }
		  fw.flush();
		  fw.close();
		  con.close();
		  System.out.println("CSV File is created successfully.");
		} catch (Exception e) {

		e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("OrdersProvisionedD3.jsp");
		r.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
