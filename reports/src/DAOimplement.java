
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOimplement implements DAOInterface{
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	@Override
	public Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url,user,pass);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public List<OrderService> orderView(Date filterf ,Date filtert) {
		
		Connection con=getConnection();
		//System.out.println(filterf);
		System.out.println("connection established");
		List<OrderService> list=new ArrayList<OrderService>();
		String querry="select count(customer_orders.order_id),service_description.service_name from customer_orders Inner join product_services on customer_orders.order_id=product_services.order_id inner join service_description on product_services.service_id=service_description.service_id where customer_orders.order_negotiation_date between ? and ? group by  service_description.service_name";
		try {
			pst=con.prepareStatement(querry);
			System.out.println("connection done");
			try {
				
				//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				//java.sql.Date dDate = (Date) formatter.parse(filter);
				
				pst.setDate(1,filterf);
				pst.setDate(2,filtert);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			rs=pst.executeQuery();
			
			while(rs.next()){
			OrderService os=new OrderService();
			os.setCountOrders(rs.getInt(1));
			os.setService_name(rs.getString(2));
			list.add(os);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeDBconn();
		}
		
		return list;
		
	}

	@Override
	public void closeDBconn() {
		try
		{
			con.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Payment> paymentView(Date filterf,Date filtert){
		
		Connection con=getConnection();
		List<Payment> list=new ArrayList<Payment>();
		String querry="select sum(current_bill_amount),sum(amount_paid),cust_id from payment where bill_gen_date between ? and ? group by cust_id";
		try {
			pst=con.prepareStatement(querry);
			pst.setDate(1,filterf);
			pst.setDate(2,filtert);
			rs=pst.executeQuery();
			System.out.println("from date dao : "+filterf);
			System.out.println("to date dao : "+filtert);
			
			while(rs.next()){
				System.out.println(rs.getFloat(1));
				Payment p=new Payment();
				p.setCountBill(rs.getFloat(1));
				p.setCountPayments(rs.getFloat(2));
				p.setCustId(rs.getInt(3));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeDBconn();
		}
		return list;
	}

	public List<PurchasedProduct> purchasedView(String year){
		Connection con=getConnection();
		List<PurchasedProduct> list=new ArrayList<PurchasedProduct>();
		String querry="select count(product_services.order_id),product_description,to_char(order_negotiation_date,'month') from product_services inner join customer_orders on customer_orders.order_id=product_services.order_id where to_char(order_negotiation_date,'yyyy')=? group by product_description,to_char(order_negotiation_date,'month')";
		try {
			pst=con.prepareStatement(querry);
			pst.setString(1,year);
			rs=pst.executeQuery();
			while(rs.next()){
				PurchasedProduct pp=new PurchasedProduct();
				pp.setCountPro(rs.getInt(1));
				pp.setPName(rs.getString(2));
				
				pp.setMonthName(rs.getString(3));
				System.out.println(pp.MonthName);
				list.add(pp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}

