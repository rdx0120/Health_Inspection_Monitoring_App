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
import mesage91.SendSms;
import sendmail.sendEmailThread;

/**
 * Servlet implementation class LoginuserMobileDoctor
 */
@WebServlet("/LoginuserMobileDoctor")
public class LoginuserMobileDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String methodname="";
	DatabaseConnection db1=new DatabaseConnection();
	 JsonObject jsonObject;
	 Connection con;
	 String sendToMObile;
	    ArrayList<Book> books=new ArrayList<Book>(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginuserMobileDoctor() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		 ArrayList<Book> books=new ArrayList<Book>();
		  books=getAllCountries(username,password);
		  Gson gson = new Gson();
		  JsonElement element = gson.toJsonTree(books, new TypeToken<List<Countries>>() {}.getType());
JsonObject jsonObject=new JsonObject();

		  JsonArray jsonArray = element.getAsJsonArray();
		  jsonObject.add("jsonarrayval", jsonArray);
		  response.setContentType("application/json");
		  response.getWriter().print(jsonObject);
	
	
	}

	public  ArrayList<Book> getAllCountries(String username, String password) {
	     //connection = con;
	        ArrayList<Book> booklist = new ArrayList<Book>();
	        String sql="select * from doctorsdetails where doctorname='"+username+"' and password='"+password+"'";
	    	
	    	PreparedStatement ps1;
	    	try {
	    		ps1 = con.prepareStatement(sql);
	    		// ps1.setString(1, "1" );
	    		    
	    	     ResultSet rs=ps1.executeQuery();
	    	     Book book=new Book();
	            if(rs.next()) { 
	            	
	            	
	            	
	            book.setBookName("1");
	           
	            String mobilenumber=rs.getString("phonenumber");	
	            String emailid=rs.getString("emailid");	
		          
	            int randomPIN = (int)(Math.random()*9000)+1000;
	            String val = ""+randomPIN;
	            
	            
	            String updateOTP="update doctorsdetails set otp='"+val+"' where doctorname='"+username+"'";
	            
	            db1.getUpdate(updateOTP);
	            
//	            SendSms sm=new SendSms();
//	    		sm.sendmessageto91(mobilenumber, "your OTP for app login is "+val, ""); 
	               
	            
	            sendEmailThread sendEmail = new sendEmailThread(emailid, "OTP for Doctor-patient app","your OTP for app login is "+val);
	            Thread t = new Thread(sendEmail);
	            t.start();
	               
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
}

