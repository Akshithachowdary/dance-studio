

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class candidate_servlet
 */
public class candidate_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public candidate_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 String name=request.getParameter("name");
		    String email=request.getParameter("email");
		    String mobile=request.getParameter("mobile");
		    String gender=request.getParameter("gender");
		    String tod=request.getParameter("Type of dance");
		    String cname=request.getParameter("cname");
		    String comment=request.getParameter("comment");
		    String date=request.getParameter("do");
		        
		        
		    System.out.println("username : " + name);
		    System.out.println(" email : "+ email);
		    System.out.println("mobile no : " + mobile);
		    System.out.println("gender : " + gender);
		    System.out.println("Date: "+date);
		    System.out.println("type of dance"+tod);
		    System.out.println("country:  "+cname);
		    System.out.println("Comments : "+comment);
		    
		    
		     try {
		              Class.forName("oracle.jdbc.OracleDriver");
		              System.out.println("Driver Loaded");
		              Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","anil");
		              System.out.println("connected to database");
		              
		              String sql="insert into slotbooking values(?,?,?,?,?,?,?,?)";
		              PreparedStatement pstmt=con.prepareStatement(sql);
		              pstmt.setString(1,name);
		              pstmt.setString(2,email);
		              pstmt.setString(3,mobile);
		              pstmt.setString(4,gender);
		              pstmt.setString(5,date);
		              pstmt.setString(6,tod);
		              pstmt.setString(7,cname);
		              pstmt.setString(8,comment);

		              ResultSet rs=pstmt.executeQuery();
		              
		             
		              if(rs.next()) {
		            	  
		                System.out.println("Booked  Succesfully");
		              }
		              else {
		                System.out.println("Booking Failed");
		              }
		              con.close();
		          }
		          catch(Exception e){
		              System.out.println(e);
		              
		          }
		      
		    
		    
		  }
	}

