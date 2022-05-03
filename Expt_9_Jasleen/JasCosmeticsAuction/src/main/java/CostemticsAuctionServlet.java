
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CostemticsAuctionServlet
 */

@WebServlet("/CostemticsAuctionServlet")
public class CostemticsAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CostemticsAuctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("userName");
		String productname = request.getParameter("productName");
		int bid = Integer.parseInt(request.getParameter("bidValue"));
		
		
		 try {

             // Connecting with the MYSQL database
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jas_Cosmetics_Auction",
                             "root", "12345");
             Statement st = con.createStatement();
             PreparedStatement ps = con.prepareStatement("Insert into Auctions values(?,?,?)");
             
             ps.setString(1, name);
             ps.setString(2, productname);
             ps.setInt(3, bid);
             
             int i = ps.executeUpdate();
             if(i>0) 
            	 out.println("You have Successfully bid in the Auction...... ");
            	 
            ResultSet rs = st.executeQuery("Select * from Auctions where UserName = '" + name + "'");
            	 
            while(rs.next()) {
            	out.println("<BR><BR>* Data is:  ");
            	out.println("<BR>User name: "+ rs.getString(1));
            	out.println("<BR>Product name: "+ rs.getString(2));
            	out.println("<BR>Bid Value: "+ rs.getInt(3));
            }
            con.close();
             
		 }catch(Exception e){
			 System.out.println(e);
		 }
		 out.close();
	}

}
