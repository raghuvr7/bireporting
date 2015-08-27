

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderView
 */
@WebServlet("/OrderView")
public class OrderView extends HttpServlet {
	
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
			//System.out.println(tdate);
			/*DAOimplement e=new DAOimplement();
			
			List<OrderService> listE=e.orderView(Fdate,Tdate);
			request.setAttribute("empls",listE);
			RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
			rd.forward(request,response);*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pass="tiger";
			Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement pst;
			String querry="select count(customer_orders.order_id),service_description.service_name from customer_orders Inner join product_services on customer_orders.order_id=product_services.order_id inner join service_description on product_services.service_id=service_description.service_id where customer_orders.order_negotiation_date between ? and ? group by  service_description.service_name";
			pst=con.prepareStatement(querry);
			pst.setDate(1,Fdate);
			pst.setDate(2,Tdate);		
			ResultSet rs=pst.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
