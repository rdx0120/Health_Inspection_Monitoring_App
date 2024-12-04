package MainPackage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import Database.DatabaseConnection;
import GetterSetter.Book;
import GetterSetter.Countries;
import sendmail11.SendEmail;

/**
 * Servlet implementation class resetpassword
 */
@WebServlet("/resetpassword")
public class resetpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String methodname="";
	DatabaseConnection db1=new DatabaseConnection();
	 JsonObject jsonObject;
	 Connection con;
	 String sendToMObile;
	    ArrayList<Book> books=new ArrayList<Book>();  
	    
	    public static String passwordresethostpath="http://192.168.0.106:8080/HospitalInformation/";
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetpassword() {
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
		String password=request.getParameter("password");
		String hcode=request.getParameter("hcode");
		
		
		
		
		
		
		 ArrayList<Book> books=new ArrayList<Book>();
		  books=getAllCountries(password,hcode);
		  Gson gson = new Gson();
		  JsonElement element = gson.toJsonTree(books, new TypeToken<List<Countries>>() {}.getType());
JsonObject jsonObject=new JsonObject();

		  JsonArray jsonArray = element.getAsJsonArray();
		  jsonObject.add("jsonarrayval", jsonArray);
		  response.setContentType("application/json");
		  response.getWriter().print(jsonObject);
	
	
	}

	public  ArrayList<Book> getAllCountries(String password, String hcode) {
		
		
		
		
		
	     //connection = con;
	        ArrayList<Book> booklist = new ArrayList<Book>();
	        String sql="select * from user where hashcode='"+hcode+"'";
	    	
	    	PreparedStatement ps1;
	    	try {
	    		ps1 = con.prepareStatement(sql);
	    		// ps1.setString(1, "1" );
	    		    
	    	     ResultSet rs=ps1.executeQuery();
	    	     Book book=new Book();
	            if(rs.next()) { 
	            	
	            	String passwords = "SHA-256";

	        		MessageDigest md;
					
						if(!hcode.equals(""))
						{
	        		
	        		
	        		String qrt="update user set hashcode='',password='"+password+"' where hashcode='"+hcode+"'";
	        		System.out.println(qrt);
	        		db1.getUpdate(qrt);
	        		
	        		
						}
	        		
					
	            book.setBookName("Successfully updated password");
	           
	               
	               
	            }
	            else
	            {
	            	
	            	 book.setBookName("Something went wrong! Password not reset");
	            }
	            booklist.add(book);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return booklist;
	}
}

