package InsertingData;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;
import GetterSetter.Book;
import GetterSetter.Countries;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class insertdoctorsdetails
 */
@WebServlet("/insertdoctorsdetails")
public class insertdoctorsdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection db1;
	 JsonObject jsonObject;
	 Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertdoctorsdetails() {
        super();
        db1 = new DatabaseConnection();
		con=db1.dbconnection();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String doctorname=request.getParameter("doctorname");
		String password=request.getParameter("password");
		String hospitalname=request.getParameter("hospitalname");
		String address=request.getParameter("address");
		String Specilization=request.getParameter("Specilization");
		String availability=request.getParameter("availability");
		String education=request.getParameter("education");
		String operation=request.getParameter("operation");
		String about=request.getParameter("about");
		String phonenumber=request.getParameter("phonenumber");
		
String emailid=request.getParameter("email");
		
		
		String query1="insert into doctorsdetails(doctorname,hospitalname,availability,education,operation,about,phonenumber,specialization,password,emailid,address) values(?,?,?,?,?,?,?,?,?,?,?)";


			
	        PreparedStatement psmt1;
	        InputStream is = null;
				try {
					psmt1 = con.prepareStatement(query1);
					 psmt1.setString(1,doctorname);
					 psmt1.setString(2,hospitalname);
					 psmt1.setString(3,availability);
					 psmt1.setString(4,education);
					 psmt1.setString(5,operation);
					 psmt1.setString(6,about);
					 psmt1.setString(7,phonenumber);
					 psmt1.setString(8,Specilization);
					 psmt1.setString(9,password);
					 psmt1.setString(10,emailid);
					 psmt1.setString(11,address);
			        
		   		      
		                   int i1 = psmt1.executeUpdate();
		                   

		 				  ArrayList<Book> booklist = new ArrayList<Book>();
		 			       
		 			    	
		 		    	     Book book=new Book();
		 		            if(i1>0) { 
		 		            	
		 		            	
		 		            	
		 		            book.setBookName("1");
		 		           
		 		               
		 		               
		 		            }
		 		            else
		 		            {
		 		            	
		 		            	 book.setBookName("0");
		 		            }
		 		            booklist.add(book);
		 		           
		 		  		  Gson gson = new Gson();
		 		  		  JsonElement element = gson.toJsonTree(booklist, new TypeToken<List<Countries>>() {}.getType());
		 		  JsonObject jsonObject=new JsonObject();

		 		  		  JsonArray jsonArray = element.getAsJsonArray();
		 		  		  jsonObject.add("jsonarrayval", jsonArray);
		 		  		  response.setContentType("application/json");
		 		  		  response.getWriter().print(jsonObject);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				RequestDispatcher rs = request.getRequestDispatcher("insertdoctordetails.jsp");
//				rs.forward(request,response);
				
				
		
	
	}

}
