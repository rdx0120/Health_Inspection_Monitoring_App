package MainPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import Database.DatabaseConnection;
import GetterSetter.Book;
import GetterSetter.Countries;
import sendmail.sendEmailThread;

/**
 * Servlet implementation class passwordresetbymaildoctor
 */
@WebServlet("/passwordresetbymaildoctor")
public class passwordresetbymaildoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	DatabaseConnection db1=new DatabaseConnection();
	String message1="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passwordresetbymaildoctor() {
        super();
        con=db1.dbconnection();
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
		// TODO Auto-generated method stub

	String email = request.getParameter("mail");
		
		String phone="";
		try {
			phone=getphonenum(email);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		 ArrayList<Book> books=new ArrayList<Book>();
		  books=getAllCountries(email,phone);
		  Gson gson = new Gson();
		  JsonElement element = gson.toJsonTree(books, new TypeToken<List<Countries>>() {}.getType());
		  JsonObject jsonObject=new JsonObject();

		  JsonArray jsonArray = element.getAsJsonArray();
		  jsonObject.add("jsonarrayval", jsonArray);
		  response.setContentType("application/json");
		  response.getWriter().print(jsonObject);
	
	
	}

	public  ArrayList<Book> getAllCountries(String email,String phone) {
	     //connection = con;
	        ArrayList<Book> booklist = new ArrayList<Book>();
	        String query1="select * from doctorsdetails where emailid='"+email+"'";
	    	
	    	PreparedStatement ps1;
	    	try {
	    		ps1 = con.prepareStatement(query1);
	    		// ps1.setString(1, "1" );
	    		    
	    	     ResultSet rs=ps1.executeQuery();
	    	     Book book=new Book();
	            if(rs.next()) { 
	            	
	            	

	            		sendEmailThread sendEmail = new sendEmailThread(email, "Forgot Password", "Your password for user app is "+ phone);
	                    Thread t = new Thread(sendEmail);
	                    t.start();
	                    book.setBookName("1");
	            
	            }
	            else
	            {
	            	
	            	 book.setBookName("0");
	            }
	            booklist.add(book);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return booklist;	
	
	}
	
	private String getphonenum(String email) throws SQLException {
		String phonenum="";
		String qry="select * from doctorsdetails where emailid='"+email+"'";
		ResultSet rs=db1.getResultSet(qry);
		while(rs.next())
		{
			phonenum=rs.getString("password");	
		}
		return phonenum;
	}

}



